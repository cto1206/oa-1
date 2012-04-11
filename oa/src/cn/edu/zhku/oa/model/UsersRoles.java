package cn.edu.zhku.oa.model;

/**
 * ���ߣ���Ȩ
 * @hibernate.class table="t_usersroles"
 */
public class UsersRoles {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ��Ӧ�Ľ�ɫ
	 * @hibernate.many-to-one
	 */
	private Role role;
	
	/**
	 * ��Ӧ���û�
	 * @hibernate.many-to-one
	 */
	private User user;
	
	/**
	 * ��ɫ������û��е����ȼ�
	 * @hibernate.property
	 */
	private int orderNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
