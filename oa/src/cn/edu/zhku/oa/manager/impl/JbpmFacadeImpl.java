package cn.edu.zhku.oa.manager.impl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import cn.edu.zhku.oa.dao.impl.AbstractDao;
import cn.edu.zhku.oa.manager.JbpmFacade;
import cn.edu.zhku.oa.model.Document;
import cn.edu.zhku.oa.web.actions.CreateTransitionAction;

public class JbpmFacadeImpl extends AbstractDao implements JbpmFacade {

	private JbpmConfiguration jbpmConfiguration;
	
	public long addProcessInstance(String processName, Document document) {
		
		JbpmContext context = getJbpmContext();
		
		ProcessDefinition def = context.getGraphSession().findLatestProcessDefinition(processName);
		
		ProcessInstance instance = new ProcessInstance(def);
		
		instance.getContextInstance().setVariable("document", document.getId());
		
		//�����ı���Ҳ�ύ������ʵ�������У��Ա���E-Mail���ܹ���ʾ������ĵ�����
		instance.getContextInstance().setVariable("docTitle", document.getTitle());
		
		//�����ĵ�����������ý�������ʵ������
		Map props = document.getProps();
		if(props != null){
			Set entries = props.entrySet();
			for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				String propertyName = (String)entry.getKey();
				Object obj = document.getProperty(propertyName);
				//��������������ʵ������
				instance.getContextInstance().setVariable(propertyName, obj);
			}
		}
		
		context.save(instance);
		
		return instance.getId();
	}

	public void delProcessDefinition(String processName) {
		JbpmContext context = getJbpmContext();
		List defs = context.getGraphSession().findAllProcessDefinitionVersions(processName);
		for (Iterator iterator = defs.iterator(); iterator.hasNext();) {
			ProcessDefinition def = (ProcessDefinition) iterator.next();
			context.getGraphSession().deleteProcessDefinition(def);
		}
	}

	public void delProcessInstance(long processInstanceId) {
		JbpmContext context = getJbpmContext();
		context.getGraphSession().deleteProcessInstance(processInstanceId);
	}

	public String deployProcessDefinition(byte[] processDef) {
		
		JbpmContext context = getJbpmContext();
		
		ProcessDefinition def = ProcessDefinition.parseXmlInputStream(
			new ByteArrayInputStream(processDef)
		);
		
		context.deployProcessDefinition(def);
		
		return def.getName();
	}

	public String nextStep(long processInstanceId, String actorId,
			String transitionName) {
		
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//��ǰ�ڵ�
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//��������
		String startNodeName = instance.getProcessDefinition().getStartState().getName();
				
		//����������
		if(startNodeName.equals(currentNodeName)){
			if(transitionName == null){
				instance.signal();
			}else{
				instance.signal(transitionName);
			}
		}else{
			List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
			for (Iterator iterator = taskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					if(transitionName == null){
						ti.end();
					}else{
						ti.end(transitionName);
					}
					break;
				}
			}
			
			
			//���������������ʵ��
			List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					if(transitionName == null){
						ti.end();
					}else{
						ti.end(transitionName);
					}
					break;
				}
			}
		}
		
		//����ת��֮��Ľڵ�����
		return instance.getRootToken().getNode().getName();
	}
	
	//����
	public Object[] backStep(long processInstanceId, String actorId) {
		JbpmContext context = getJbpmContext();
		
		//��������ʵ����ʶ��������ʵ��
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		Object[] os = new Object[2];
		//�����û���Ӧ�����е�����ʵ��
		List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
		for (Iterator iterator = taskInstances.iterator(); iterator
				.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			if(ti.getProcessInstance().getId() == processInstanceId){
				
				//���ж��Ƿ���Ҫ���˵����
				Set set = ti.getToken().getNode().getArrivingTransitions();
				for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
					Transition t = (Transition) iterator2.next();
					//�������Ҫ���˵����
					if(t.getFrom().equals(ti.getProcessInstance().getProcessDefinition().getStartState())){
						int docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
						//������ǰ������ʵ��
						ti.getProcessInstance().end();
						//������ǰ����ʵ��
						ti.end();
						
						//���´�������ʵ������
						ProcessInstance pi = new ProcessInstance(ti.getProcessInstance().getProcessDefinition());
						pi.getContextInstance().setVariable("document", docId);
						//������ʵ���������³־û������ݿ�
						context.save(pi);
						
						os[0] = Document.STATUS_NEW;
						os[1] = pi.getId();
						
						return os;
					}
				}
				
				//�������Ҫ���˵����
				ti.end(CreateTransitionAction.BACK_TRANSITION);
				break;
			}
		}
		
		os[0] = instance.getRootToken().getNode().getName();
		os[1] = processInstanceId;
		
		return os;
	}

	public List searchMyTaskList(String actorId) {
		
		JbpmContext context = getJbpmContext();
		List docIds = new ArrayList();
		List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
		for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			Integer docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);
		}
		
		//���������������ʵ��
		List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
		for (Iterator iterator = pooledTaskInstances.iterator(); iterator
				.hasNext();) {
			TaskInstance ti = (TaskInstance) iterator.next();
			Integer docId = (Integer)ti.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);
		}		
		
		return docIds;
	}

	public List searchNextTransitions(long processInstanceId, String actorId) {
		JbpmContext context = getJbpmContext();
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//��ǰ�ڵ�
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//��������
		String startNodeName = instance.getProcessDefinition().getStartState().getName();
		
		Collection transitions = null;
		
		//����������
		if(startNodeName.equals(currentNodeName)){
			transitions = instance.getRootToken().getAvailableTransitions();
		}else{
			List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
			for (Iterator iterator = taskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
					break;
				}
			}
			
			//���������������ʵ��
			List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
			for (Iterator iterator = pooledTaskInstances.iterator(); iterator
					.hasNext();) {
				TaskInstance ti = (TaskInstance) iterator.next();
				if(ti.getProcessInstance().getId() == processInstanceId){
					transitions = ti.getAvailableTransitions();
				}
			}
		}
		
		List transitionNames = new ArrayList();
		
		if(transitions != null){
			//Ϊ�˲���Transition����ֱ�ӱ�¶��OAϵͳ����Ҫ����ת��Ϊ�����б�
			for (Iterator iterator = transitions.iterator(); iterator.hasNext();) {
				Transition transition = (Transition) iterator.next();
				transitionNames.add(transition.getName());
			}
		}
		
		return transitionNames;
	}
	
	private JbpmContext getJbpmContext(){
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSession(getSession());
		return context;
	}

	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

}
