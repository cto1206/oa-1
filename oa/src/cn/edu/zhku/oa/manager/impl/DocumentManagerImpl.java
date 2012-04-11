package cn.edu.zhku.oa.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.DocumentDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.manager.DocumentManager;
import cn.edu.zhku.oa.manager.JbpmFacade;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;
import cn.edu.zhku.oa.model.User;

public class DocumentManagerImpl implements DocumentManager {

	private DocumentDao documentDao;
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private WorkflowDao workflowDao;
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	private JbpmFacade jbpmFacade;
	
	//����
	public void addApproveInfo(ApproveInfo approveInfo, int documentId,
			int approverId,boolean back) {
		Document doc = documentDao.findDocument(documentId);
		User user = userDao.findUser(approverId);
		approveInfo.setDocument(doc);
		approveInfo.setApprover(user);
		documentDao.addApproveInfo(approveInfo);
		
		//����ǲ��أ��򷵻���һ���ڵ�
		if(back){
			Object[] os = jbpmFacade.backStep(doc.getProcessInstanceId(), user.getUsername());
			doc.setStatus((String)os[0]);
			doc.setProcessInstanceId((Long)os[1]);
			documentDao.updateDocument(doc);
		}		
	}

	//��ӹ���
	public void addDocument(Document document, int workflowId, int userId,Map props) {
		
		//���湫����Ϣ
		document.setWorkflow(workflowDao.findWorkflowById(workflowId));
		document.setCreator(userDao.findUser(userId));
		document.setStatus(Document.STATUS_NEW);
		document.setCreateTime(new Date());
		
		//������������
		document.setPropertiesMap(props);
		
		documentDao.addDocument(document);
		
		//�������ʵ��
		long processInstanceId = jbpmFacade.addProcessInstance(document.getWorkflow().getName(), document);
		
		//������ʵ���ı�ʶ�����Ķ���
		document.setProcessInstanceId(processInstanceId);
		documentDao.updateDocument(document);
	}

	//ɾ������
	public void delDocument(int documentId) {
		Document document = documentDao.findDocument(documentId);
		
		//ɾ��������Ϣ
		documentDao.delDocument(document);
		
		//ɾ������ʵ��
		jbpmFacade.delProcessInstance(document.getProcessInstanceId());
	} 

	//�����ض�����
	public Document findDocument(int documentId) {
		
		return documentDao.findDocument(documentId);
	}

	//���ҹ��ĵ�������ʷ
	public List searchApproveInfos(int documentId) {
		
		return documentDao.searchApproveInfos(documentId);
	}

	//�����û����������Ĺ���
	public PagerModel searchApprovedDocuments(int userId) {
		
		return documentDao.searchApprovedDocuments(userId);
	}

	//�������ڵȴ������Ĺ���
	public PagerModel searchApprovingDocuments(int userId) {
		User user = userDao.findUser(userId);
		
		//��������ת���û�����Ĺ��ı�ʶ�б�
		List docIds = jbpmFacade.searchMyTaskList(user.getUsername());
		
		if(docIds == null || docIds.isEmpty()){
			return null;
		}
		
		//���ݹ��ı�ʶ�������еĹ��Ķ���
		return documentDao.findAllDocumentsByIds(docIds);
	}

	//�����û����������й���
	public PagerModel searchMyDocuments(int userId) {
		
		return documentDao.searchMyDocuments(userId);
	}

	public List searchNextSteps(int documentId, int userId) {
		Document doc = documentDao.findDocument(documentId);
		User user = userDao.findUser(userId);
		String username = user.getUsername();
		
		return jbpmFacade.searchNextTransitions(doc.getProcessInstanceId(), username);
	}

	//�ύ������
	public void submitToWorkflow(int userId, int documentId, String transitionName) {
		User user = userDao.findUser(userId);
		String username = user.getUsername();
		
		Document document = documentDao.findDocument(documentId);
		long processInstanceId = document.getProcessInstanceId();
		
		String status = jbpmFacade.nextStep(processInstanceId,username,  transitionName);
		
		document.setStatus(status);
		documentDao.updateDocument(document);
	}
	
	//���¹�����Ϣ
	public void updateDocument(Document document,int workflowId,int userId) {
		documentDao.updateDocument(document);
	}

	public void setJbpmFacade(JbpmFacade jbpmFacade) {
		this.jbpmFacade = jbpmFacade;
	}

	@Override
	public PagerModel searchAllFinishedDocuments(String status) {
		return documentDao.searchAllFinishedDocuments(status);
	}

}
