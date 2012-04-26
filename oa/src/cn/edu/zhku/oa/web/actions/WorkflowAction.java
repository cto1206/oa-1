package cn.edu.zhku.oa.web.actions;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.io.SAXReader;

import cn.edu.zhku.oa.manager.WorkflowManager;
import cn.edu.zhku.oa.model.DWZResponser;
import cn.edu.zhku.oa.model.Workflow;
import cn.edu.zhku.oa.web.common.DWZConstants;
import cn.edu.zhku.oa.web.common.util.DWZResponseFactory;
import cn.edu.zhku.oa.web.forms.WorkflowActionForm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WorkflowAction extends BaseAction {
	
	private WorkflowManager workflowManager;

	/**
	 * �����̹��������棬�г���ǰ���е�����
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());
		return mapping.findForward("index");
	}
	
	/**
	 * �����̷���ҳ��
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_input");
	}
	
	//������̶���
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		//��һЩ�жϣ��ж��ϴ����ļ��Ƿ�Ϊ�գ������Ƿ��׳��쳣���ȵȣ���
		
		//��������
		if(waf.getProcessDefinition()!=null && waf.getProcessImage()!=null){
			workflowManager.addOrUpdateWorkflow(waf.getProcessDefinition().getFileData(), waf.getProcessImage().getFileData());
		}
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		DWZResponser dwzResponser = DWZResponseFactory.create();
		dwzResponser.setStatusCode(DWZConstants.SUCCESS_CODE);
		dwzResponser.setMessage(DWZConstants.SUCCESS_OPERATE);
		dwzResponser.setCallbackType(DWZConstants.CALLBACK_CLOSE_CURRENT);
		dwzResponser.setForwardUrl("workflow.do");
		
		String json = gson.toJson(dwzResponser);
		response.getWriter().write(json);
		response.getWriter().flush();
		return null;
	}
	
	//ɾ�����̶���
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WorkflowActionForm waf = (WorkflowActionForm)form;
		
		workflowManager.delWorkflow(waf.getId());
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		DWZResponser dwzResponser = DWZResponseFactory.create();
		dwzResponser.setStatusCode(DWZConstants.SUCCESS_CODE);
		dwzResponser.setMessage(DWZConstants.SUCCESS_OPERATE);
		dwzResponser.setCallbackType(DWZConstants.CALLBACK_CLOSE_CURRENT);
		dwzResponser.setForwardUrl("workflow.do");
		
		String json = gson.toJson(dwzResponser);
		response.getWriter().write(json);
		response.getWriter().flush();
		return null;
	}
	
	//�򿪲鿴����ͼƬ�Ľ���
	public ActionForward openViewImage(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		return mapping.findForward("flow_image");
	}
	
	//�鿴ͼƬ����������flow_image.jsp�е�<img src="workflow.do?method=viewImage">���������
	public ActionForward viewImage(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		WorkflowActionForm waf = (WorkflowActionForm)form;
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		response.setContentType("image/jpeg");
		response.getOutputStream().write(wf.getProcessImage());
		return null;
	}
	
	//�鿴���̶����ļ�������
	public ActionForward viewFlowDef(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		WorkflowActionForm waf = (WorkflowActionForm)form;
		Workflow wf = workflowManager.findWorkflow(waf.getId());
		byte[] defs = wf.getProcessDefinition();
		
		//��byte[]ת��Ϊ�ַ���
		//String defString = new String(defs,"UTF-8");
		
		//Ϊ�˱���Ӳ����encoding����������dom4j��������������ת��xml�ļ�
		String defString = new SAXReader().read(
			new ByteArrayInputStream(defs)
		).asXML();
		request.setAttribute("def", defString);
		return mapping.findForward("flow_def");
	}
	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
}
