package cn.edu.zhku.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class RoleActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private int id;

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
