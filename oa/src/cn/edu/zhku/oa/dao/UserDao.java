package cn.edu.zhku.oa.dao;

import java.util.List;

import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.model.UsersRoles;

/**
 * �û��־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����03:50:04
 */
public interface UserDao {
	
	/**
	 * ����û���Ϣ
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * ɾ���û���Ϣ
	 * @param userId
	 */
	public void delUser(int userId);
	
	/**
	 * �����ض����û�
	 * @param userId
	 * @return
	 */
	public User findUser(int userId);
	
	/**
	 * �����û��������ض��û�
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	
	/**
	 * ��ѯ�û�ӵ�е����еĽ�ɫ
	 * @param userId �û�ID
	 * @return UsersRoles����ļ���
	 */
	public List searchUserRoles(int userId);
	
	/**
	 * ��ӻ�����û�ӵ�еĽ�ɫ������û�[userId]�Ѿ�ӵ�н�ɫ[roleId]��
	 * ����������ȼ�[orderNo]��������û�������Ӧ�Ľ�ɫ�����������ȼ�
	 * @param userId
	 * @param roleId
	 * @param orderNo
	 */
	public void addUserRole(UsersRoles ur);
	
	/**
	 * �����û������Ľ�ɫ
	 * @param ur
	 */
	public void updateUserRole(UsersRoles ur);
	
	/**
	 * ɾ��������û��Ľ�ɫ��������
	 * @param userId
	 * @param roleId
	 */
	public void delUserRole(int userId,int roleId);
	
	/**
	 * �����û������Ľ�ɫ
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UsersRoles findUsersRoles(int userId,int roleId);
}
