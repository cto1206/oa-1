package cn.edu.zhku.oa.manager;

import java.util.List;

import cn.edu.zhku.oa.model.Workflow;

/**
 * ���̹���ӿ�
 * ���ߣ���Ȩ
 * ʱ�䣺2010-7-28 ����12:05:22
 */
public interface WorkflowManager {
	
	/**
	 * ��ӻ���¹�������
	 * @param processDef ���̶���
	 * @param processImage ����ͼƬ
	 */
	public void addOrUpdateWorkflow(byte[] processDef,byte[] processImage);
	
	/**
	 * ɾ����������
	 * @param workflow ���̱�ʶ
	 */
	public void delWorkflow(int workflow);
	
	/**
	 * �����ض���������
	 * @param workflow ���̱�ʶ
	 * @return
	 */
	public Workflow findWorkflow(int workflow);
	
	/**
	 * �������й�������
	 * @return
	 */
	public List searchAllWorkflows();
	
}
