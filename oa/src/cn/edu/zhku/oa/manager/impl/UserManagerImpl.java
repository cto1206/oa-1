package cn.edu.zhku.oa.manager.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.dao.PersonDao;
import cn.edu.zhku.oa.dao.RoleDao;
import cn.edu.zhku.oa.dao.UserDao;
import cn.edu.zhku.oa.manager.UserManager;
import cn.edu.zhku.oa.model.User;
import cn.edu.zhku.oa.model.UsersRoles;
import cn.edu.zhku.oa.web.SystemException;

public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	private RoleDao roleDao;
	private PersonDao personDao;
	@Override
	public void addOrUpdateUserRole(int userId, int roleId, int orderNo) {
		//���ȸ���userId��roleId����UsersRoles����
		UsersRoles ur = userDao.findUsersRoles(userId, roleId);
				
		if(ur == null){
			ur = new UsersRoles();
			ur.setOrderNo(orderNo);
			ur.setRole(roleDao.findRole(roleId));
			ur.setUser(userDao.findUser(userId));
			userDao.addUserRole(ur);
			return;
		}
		
		ur.setOrderNo(orderNo);
		userDao.updateUserRole(ur);
	}

	@Override
	public void addUser(User user, int personId) {
		if(personId == 0){
			throw new SystemException("����ѡ����Ӧ����Ա��Ϣ");
		}
		
		user.setPerson(personDao.findPerson(personId));
		
		//���ô���ʱ��
		user.setCreateTime(new Date());
		
		userDao.addUser(user);
	}

	@Override
	public void delUser(int userId) {
		userDao.delUser(userId);
	}

	@Override
	public void delUserRole(int userId, int roleId) {
		userDao.delUserRole(userId, roleId);
	}

	@Override
	public User findUser(int userId) {
		return userDao.findUser(userId);
	}

	@Override
	public User login(String username, String password) {
		
		/**
		 * ��Ϊ������User��auto-import="false"�����ԣ�������ʹ��
		 * HQL��ѯ��ʱ�򣬱���ʹ��ȫ·��������
		 */
		User user = userDao.findUserByName(username);
		
		if(user == null){
			return null;
		}
		
		if(!user.getPassword().equals(password)){
			throw new SystemException("�������!");
		}
		
		if(user.getExpireTime() != null){
			//����ʱ��
			Calendar now = Calendar.getInstance();
			
			//ʧЧʱ��
			Calendar expireTime = Calendar.getInstance();
			expireTime.setTime(user.getExpireTime());
			
			//���������ʧЧʱ��֮��
			if(now.after(expireTime)){
				throw new SystemException("�û���Ϣ��ʧЧ!");
			}
		}
		return user;
	}

	@Override
	public List searchUserRoles(int userId) {
		return userDao.searchUserRoles(userId);
	}

	@Override
	public void updateUser(User user, int personId) {
		if(personId == 0){
			throw new SystemException("����ѡ����Ӧ����Ա��Ϣ");
		}
		
		user.setPerson(personDao.findPerson(personId));
		
		userDao.updateUser(user);
	}
	
	@Override
	public void updatePassword(int userId, String oldPassword, String newPassword) {
		User user = userDao.findUser(userId);
		if(!oldPassword.equals(user.getPassword())){
			throw new SystemException("������˼��ԭʼ���벻��ȷ�����������ˣ�");
		}
		user.setPassword(newPassword);
		userDao.updateUser(user);
	}
	
	@Override
	public User findUserByName(String username) {
		return userDao.findUserByName(username);	
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
