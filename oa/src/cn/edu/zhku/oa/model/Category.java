package cn.edu.zhku.oa.model;

/**
 * ���
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-15 ����12:43:11
 * @hibernate.class table="t_category" lazy="false"
 */
public class Category {
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String name;
	
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
	
}
