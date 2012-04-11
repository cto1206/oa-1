package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Role;

public interface RoleManager {
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * ɾ����ɫ
	 * @param roleId
	 */
	public void delRole(int roleId);
	
	/**
	 * ���½�ɫ
	 * @param roleId
	 */
	public void updateRole(Role role);
	
	/**
	 * ���ҽ�ɫ
	 * @param roleId
	 */
	public Role findRole(int roleId);
	
	/**
	 * ��ҳ��ѯ��ɫ����Ϣ
	 * @return
	 */
	public PagerModel searchRoles();
}
