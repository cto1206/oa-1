package cn.edu.zhku.oa.model;

/**
 * ����
 * ���ߣ���Ȩ
 * @hibernate.class table="t_workflow"
 */
public class Workflow {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ��������
	 * @hibernate.property
	 * 		unique="true"
	 */
	private String name;
	
	/**
	 * ���̶����ļ�
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processDefinition;
	
	/**
	 * ���̶���ͼƬ
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processImage;
	
	/**
	 * @hibernate.one-to-one property-ref="workflow"
	 */
	private FlowForm flowForm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(byte[] processDefinition) {
		this.processDefinition = processDefinition;
	}

	public byte[] getProcessImage() {
		return processImage;
	}

	public void setProcessImage(byte[] processImage) {
		this.processImage = processImage;
	}

	public FlowForm getFlowForm() {
		return flowForm;
	}

	public void setFlowForm(FlowForm flowForm) {
		this.flowForm = flowForm;
	}
}
