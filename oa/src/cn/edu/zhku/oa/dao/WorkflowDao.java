package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.Workflow;

/**
 * ���̹���ӿ�
 * ���ߣ���Ȩ
 * ʱ�䣺2010-7-28 ����12:05:22
 */
public interface WorkflowDao {
	
	/**
	 * �����������ƣ���ѯ����Workflow����
	 * @param workflowName
	 * @return
	 */
	public Workflow findWorkflowByName(String workflowName);
	
	/**
	 * ���湤������
	 * @param workflow ��������
	 */
	public void saveWorkflow(Workflow workflow);
	
	/**
	 * ���¹�������
	 * @param workflow ��������
	 */
	public void updateWorkflow(Workflow workflow);
	
	/**
	 * ɾ����������
	 * @param workflow
	 */
	public void delWorkflow(Workflow workflow);
	
	/**
	 * ���ݹ������̱�ʶ�����ض�������
	 * @param workflowId ���̱�ʶ
	 * @return
	 */
	public Workflow findWorkflowById(int workflowId);
	
	/**
	 * ��ѯ���й�������
	 * @return
	 */
	public List searchAllWorkflows();
}
