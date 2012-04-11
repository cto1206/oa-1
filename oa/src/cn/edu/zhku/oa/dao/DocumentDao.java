package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;

/**
 * ���ĳ־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����08:24:06
 */
public interface DocumentDao {
	
	/**
	 * ��ӹ�����Ϣ
	 * @param document
	 * @param workfowId
	 * @param userId
	 */
	public void addDocument(Document document);

	/**
	 * ����ĳ�����ĵ���Ϣ
	 * @param documentId
	 * @return
	 */
	public Document findDocument(int documentId);
	
	/**
	 * ���¹�����Ϣ
	 * @param document
	 */
	public void updateDocument(Document document);
	
	/**
	 * ɾ��������Ϣ
	 * @param documentId
	 */
	public void delDocument(Document document);
	
	/**
	 * �����û��������Ĺ����б�
	 * @param userId
	 * @return
	 */
	public PagerModel searchMyDocuments(int userId);
	
	/**
	 * ��ѯ���ĵ�������Ϣ
	 * @param documentId
	 * @return
	 */
	public List searchApproveInfos(int documentId);
	
	/**
	 * ��ѯ�����б�
	 * @param docIds
	 * @return
	 */
	public PagerModel findAllDocumentsByIds(List docIds);
	
	/**
	 * ��ѯ�û����������Ĺ����б�
	 * @param userId
	 * @return
	 */
	public PagerModel searchApprovedDocuments(int userId);
	
	/**
	 * �洢������Ϣ
	 * @param approveInfo ������Ϣ
	 * @param documentId �������Ĺ���
	 * @param approverId ������ID
	 */
	public void addApproveInfo(ApproveInfo approveInfo);
	
	/**
	 * ���Ĺ鵵����
	 * @param status
	 * @return
	 */
	public PagerModel searchAllFinishedDocuments(String status);
	
}
