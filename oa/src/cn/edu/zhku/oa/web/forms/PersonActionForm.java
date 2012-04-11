package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class PersonActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	private int id;					//���
	
	private String name;			//����
	
	private String sex;				//�Ա�
	
	private String duty;			//ְ��
	
	private String phone;			//�绰
	
	private String address;			//��ַ

	private String description;     //����

	private int orgId;				//��������
	
	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public String getDuty() {
		return duty;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getOrgId() {
		return orgId;
	}

	public String getPhone() {
		return phone;
	}

	public String getSex() {
		return sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
