package cn.edu.zhku.oa.dao.impl;

import java.util.List;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.DocumentDao;
import cn.edu.zhku.oa.dao.WorkflowDao;
import cn.edu.zhku.oa.model.ApproveInfo;
import cn.edu.zhku.oa.model.Document;

public class DocumentDaoImpl extends AbstractDao implements
		DocumentDao {

	private WorkflowDao workflowDao;
	public void setWorkflowDao(WorkflowDao workflowDao) {
		this.workflowDao = workflowDao;
	}

	//����
	@Override
	public void addApproveInfo(ApproveInfo approveInfo) {
		getHibernateTemplate().save(approveInfo);
	}

	//��ӹ���
	@Override
	public void addDocument(Document document) {
		//���湫����Ϣ
		getHibernateTemplate().save(document);
	}

	//ɾ������
	@Override
	public void delDocument(Document document) {
		//ɾ��������Ϣ
		getHibernateTemplate().delete(document);
	}

	//�����ض�����
	@Override
	public Document findDocument(int documentId) {
		return (Document)getHibernateTemplate().load(Document.class, documentId);
	}

	//�����û����������Ĺ���
	@Override
	public PagerModel searchApprovedDocuments(int userId) {
		return searchPaginated("select distinct ai.document from ApproveInfo ai where ai.approver.id=?",userId);
	}

	@Override
	public List searchApproveInfos(int documentId) {
		return getHibernateTemplate().find("from ApproveInfo ai where ai.document.id=?",documentId);
	}

	//�����û����������й���
	@Override
	public PagerModel searchMyDocuments(int userId) {
		return searchPaginated("select d from Document d where d.creator.id = ?",userId);
	}

	//���¹�����Ϣ
	@Override
	public void updateDocument(Document document) {
		getHibernateTemplate().update(document);
	}
	
	@Override
	public PagerModel findAllDocumentsByIds(List docIds) {
		//���ݹ��ı�ʶ�������еĹ��Ķ���
		PagerModel pm = new PagerModel();
		pm.setDatas(getSession().createQuery("select d from Document d where d.id in (:ids)")
				   .setParameterList("ids", docIds)
				   .list());
		return pm;
	}

	@Override
	public PagerModel searchAllFinishedDocuments(String status) {
		return searchPaginated("select d from Document d where d.status=?", status);
	}

}
