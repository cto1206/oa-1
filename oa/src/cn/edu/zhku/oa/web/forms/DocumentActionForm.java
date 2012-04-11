package cn.edu.zhku.oa.web.forms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class DocumentActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private int id;
	
	/**
	 * ����
	 */
	private String title;
	
	/**
	 * ����
	 */
	private String description;
	
	/**
	 * �������ݣ����ϴ��ļ������ݣ�
	 * ��Щ�ϴ��ļ������ݽ��ᱻ���浽���ݿ�
	 */
	private FormFile contentFile;
	
	/**
	 * ������
	 * @hibernate.many-to-one
	 */
	private int creatorId;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 * �������ߵ�����
	 */
	private int workflowId;
	
	/**
	 * ��һ�����������
	 */
	private String transitionName;
	
	private String approveInfo;
	
	//���ݶ�̬������
	private Map props = new HashMap();
	
	//��ʶ�Ƿ���˲���
	private boolean back;

	public FormFile getContentFile() {
		return contentFile;
	}

	public void setContentFile(FormFile contentFile) {
		this.contentFile = contentFile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(int workflowId) {
		this.workflowId = workflowId;
	}

	public String getTransitionName() {
		return transitionName;
	}

	public void setTransitionName(String transitionName) {
		this.transitionName = transitionName;
	}

	public String getApproveInfo() {
		return approveInfo;
	}

	public void setApproveInfo(String approveInfo) {
		this.approveInfo = approveInfo;
	}

	public Map getProps() {
		return props;
	}

	public void setProps(Map props) {
		this.props = props;
	}

	public boolean isBack() {
		return back;
	}

	public void setBack(boolean back) {
		this.back = back;
	}
}