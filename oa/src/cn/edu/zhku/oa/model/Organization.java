package cn.edu.zhku.oa.model;

import java.util.Set;

/**
 * ���ߣ���Ȩ
 * @hibernate.class table="t_organization" lazy="false"
 */
public class Organization {

	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;				//����
	
	/**
	 * @hibernate.property
	 */
	private String name;		//����
	
	/**
	 * @hibernate.property
	 */
	private String sn;			//���
	
	/**
	 * @hibernate.property
	 */
	private String description;	//����
	
	/**
	 * @hibernate.many-to-one
	 * 		column="pid"
	 */
	private Organization parent;//������
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="pid"
	 * @hibernate.one-to-many class="cn.edu.zhku.oa.model.Organization"
	 */
	private Set children;		//�ӻ���

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	}