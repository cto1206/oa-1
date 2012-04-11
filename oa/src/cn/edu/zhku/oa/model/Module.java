package cn.edu.zhku.oa.model;

import java.util.Set;

/**
 * ���ߣ���Ȩ
 * @hibernate.class table="t_module"
 */
public class Module {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * ģ������
	 * @hibernate.property
	 * 		not-null
	 * 		unique="true"
	 */
	private String name;
	
	/**
	 * ģ����
	 * @hibernate.property
	 * 		not-null="true"
	 * 		unique="true"
	 */
	private String sn;
	
	/**
	 * ģ����ڵ�ַ
	 * @hibernate.property
	 */
	private String url;
	
	/**
	 * ģ�������
	 * @hibernate.property
	 */
	private int orderNo;
	
	/**
	 * @hibernate.many-to-one column="parentId"
	 */
	private Module parent;
	
	/**
	 * @hibernate.set inverse="true" lazy="false"
	 * @hibernate.key column="parentId"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.Module"
	 */
	private Set children;
	
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
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Module getParent() {
		return parent;
	}
	public void setParent(Module parent) {
		this.parent = parent;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
	
}
