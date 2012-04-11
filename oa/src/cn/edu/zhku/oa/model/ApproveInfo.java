package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * ������ʷ��Ϣ
 * ���ߣ���Ȩ
 * @hibernate.class table="t_approveInfo"
 */
public class ApproveInfo {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * �������
	 * @hibernate.property
	 */
	private String comment;
	
	/**
	 * ����ʱ��
	 * @hibernate.property
	 */
	private Date approveTime;
	
	/**
	 * �������Ĺ���
	 * @hibernate.many-to-one
	 */
	private Document document;
	
	/**
	 * ������
	 * @hibernate.many-to-one
	 */
	private User approver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}
}
