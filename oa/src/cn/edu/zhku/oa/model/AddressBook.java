package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * ͨ��¼
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-11 ����10:58:01
 * @hibernate.class table="t_addressBook"
 */
public class AddressBook {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ����
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String name;
	
	/**
	 * �����ʼ�
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String email;
	
	/**
	 * �ֻ�����
	 * @hibernate.property
	 */
	private String mobilePhone;
	
	/**
	 * �̶��绰
	 * @hibernate.property
	 */
	private String phs;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String nickName;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private Date birthday;
	
	/**
	 * ��ͥסַ
	 * @hibernate.property
	 */
	private String street;
	
	/**
	 * ��˾����
	 * @hibernate.property
	 */
	private String company;
	
	/**
	 * ��ע
	 * @hibernate.property
	 */
	private String notes;
	
	/**
	 * �����û�
	 * @hibernate.many-to-one column="userId"
	 */
	private User user;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhs() {
		return phs;
	}

	public void setPhs(String phs) {
		this.phs = phs;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
