package cn.edu.zhku.oa.manager;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;

/**
 * ���Ĺ���ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-3-1 ����11:03:13
 */
public interface DocumentManager {
	
	/**
	 * ��ӹ�����Ϣ
	 * @param document ���Ķ���
	 * @param workflowId ���Ķ�Ӧ������ID
	 * @param userId ���ĵĴ�����ID
	 * @param props ��������� 
	 */
	public void addDocument(Document document,int workflowId,int userId,Map props);
	
	/**
	 * ���¹�����Ϣ
	 * @param document
	 */
	public void updateDocument(Document document,int workflowId,int userId);
	
	/**
	 * ����ĳ������
	 * @param documentId
	 * @return
	 */
	public Document findDocument(int documentId);
	
	/**
	 * �����ҵĹ����б��������ɵ�ǰ��¼�û������Ĺ����б�
	 * @param userId ��ǰ��¼�û�
	 * @return
	 */
	public PagerModel searchMyDocuments(int userId);
	
	/**
	 * ɾ��������Ϣ
	 * @param documentId
	 */
	public void delDocument(int documentId);
	
	/**
	 * �������ģ���¼������Ϣ
	 * @param approveInfo ������Ϣ
	 * @param documentId �������Ĺ���
	 * @param approverId �����ߣ�ȡ��ǰ��¼�û���ID
	 * @param back �Ƿ����
	 */
	public void addApproveInfo(ApproveInfo approveInfo,int documentId,int approverId,boolean back);
	
	/**
	 * ��ѯ(��ǰ��¼�û���)�������б�
	 * @param userId �û�ID��ȡ��ǰ��¼�û���ID
	 * @return
	 */
	public PagerModel searchApprovedDocuments(int userId);
	
	/**
	 * ��ѯ���ĵ�������ʷ������ѯ���Ķ���������Щ��������
	 * @param documentId ���ĵ�ID
	 * @return
	 */
	public List searchApproveInfos(int documentId);
	
	/**
	 * ��ѯ���󣨼��ȴ���ǰ��¼�û������ģ������б�
	 * @param userId ��ǰ��¼�û���ID
	 * @return
	 */
	public PagerModel searchApprovingDocuments(int userId);
	
	
	/**
	 * ��ѯ��һ����ѡ�����б�����ID���û���ʶ��
	 * @param documentId
	 * @param userId
	 * @return
	 */
	public List searchNextSteps(int documentId,int userId);
	
	/**
	 * �ύ������
	 * @param userId ��ǰ��¼�û���ID
	 * @param documentId ���ύ�Ĺ���ID
	 * @param transistionName Ҫ�ύ������ȥ
	 */
	public void submitToWorkflow(int userId,int documentId,String transistionName);

	/**
	 * ���Ĺ鵵����
	 * @param status
	 * @return
	 */
	public PagerModel searchAllFinishedDocuments(String status);
}
