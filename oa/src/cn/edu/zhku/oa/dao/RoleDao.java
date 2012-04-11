package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Role;

/**
 * ��ɫ�־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����03:32:18
 */
public interface RoleDao {
	
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
