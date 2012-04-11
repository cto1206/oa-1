package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * ������Ϣ
 * ��д���ߣ���Ȩ
 * @hibernate.class table="t_car" lazy="false"
 */
public class Car {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * ��������
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * ���ƺ���
	 * @hibernate.property
	 */
	private String carNumber;
	
	/**
	 * �ؿ�����
	 * @hibernate.property
	 */
	private int carLoad;
	
	/**
	 * ��������
	 * @hibernate.property
	 */
	private Date applyDate;
	
	/**
	 * �黹����
	 * @hibernate.property
	 */
	private Date returnDate;
	
	/**
	 * ������
	 * @hibernate.many-to-one column="user_car_id"
	 */
	private User user;
	
	/**
	 * ����״̬ ��true����ʾ�ѽ��ã�false����ʾδ���ã�
	 * @hibernate.property
	 */
	private boolean status;

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

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getCarLoad() {
		return carLoad;
	}

	public void setCarLoad(int carLoad) {
		this.carLoad = carLoad;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
