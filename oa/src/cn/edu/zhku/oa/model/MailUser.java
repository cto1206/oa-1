package cn.edu.zhku.oa.model;

/**
 * �û�����Ӧ���ʼ���ַ������
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-18 ����08:46:50
 * @hibernate.class table="t_mail_user"
 */
public class MailUser {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	/**
	 * �ʼ���ַ
	 * @hibernate.property
	 */
	private String address;
	/**
	 * ����
	 * @hibernate.property
	 */
	private String password;
	/**
	 * @hibernate.many-to-one unique="true"
	 */
	private User user;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return address.substring(0,address.indexOf("@"));
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
