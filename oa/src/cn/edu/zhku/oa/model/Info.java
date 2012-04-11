package cn.edu.zhku.oa.model;

import java.util.Date;

/**
 * ������Ϣ
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-14 ����10:06:21
 * @hibernate.class table="t_info"
 */
public class Info {
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	private int id;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * ����
	 * @hibernate.property
	 */
	private String content;
	
	/**
	 * ����ʱ��
	 * @hibernate.property
	 */
	private Date time;
	
	/**
	 * ������
	 * @hibernate.many-to-one column="user_info_id"
	 */
	private User publisher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
}
