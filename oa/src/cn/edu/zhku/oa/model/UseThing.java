package cn.edu.zhku.oa.model;

/**
 * ��Ʒ
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-14 ����07:48:50
 * @hibernate.class table="t_usething" lazy="false"
 */
public class UseThing {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * ��Ʒ����
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * ��Ʒ���
	 * @hibernate.property
	 */
	private String serialNumber;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private int amount;
	
	/**
	 * �������
	 * @hibernate.many-to-one
	 */
	private Category category;

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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
