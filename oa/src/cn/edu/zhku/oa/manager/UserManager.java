package cn.edu.zhku.oa.manager;

import java.util.List;

import cn.edu.zhku.oa.model.User;

public interface UserManager {
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @param personId
	 */
	public void addUser(User user,int personId);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @param personId
	 */
	public void updateUser(User user,int personId);
	
	/**
	 * �޸��û�����
	 * @param userId
	 * @param password
	 */
	public void updatePassword(int userId,String oldPassword,String newPassword);
	
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
	 * ��ѯ�û�ӵ�е����еĽ�ɫ
	 * @param userId �û�ID
	 * @return UsersRoles����ļ���
	 */
	public List searchUserRoles(int userId);
	
	/**
	 * ���ӻ�����û�ӵ�еĽ�ɫ������û�[userId]�Ѿ�ӵ�н�ɫ[roleId]��
	 * ����������ȼ�[orderNo]��������û�������Ӧ�Ľ�ɫ�����������ȼ�
	 * @param userId
	 * @param roleId
	 * @param orderNo
	 */
	public void addOrUpdateUserRole(int userId,int roleId,int orderNo);
	
	/**
	 * ɾ��������û��Ľ�ɫ��������
	 * @param userId
	 * @param roleId
	 */
	public void delUserRole(int userId,int roleId);
	
	/**
	 * �û�ִ�е�½����
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	
	/**
	 * �����û����Ʋ����ض��û�
	 * @param username
	 * @return
	 */
	public User findUserByName(String username);
	
}