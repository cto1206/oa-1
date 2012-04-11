package cn.edu.zhku.oa.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.zhku.oa.dao.AclDao;
import cn.edu.zhku.oa.manager.AclManager;
import cn.edu.zhku.oa.model.ACL;
import cn.edu.zhku.oa.model.Permission;

public class AclManagerImpl implements AclManager {
	
	private AclDao aclDao;

	//��Ȩ����
	@Override
	public void addOrUpdatePermission(String principalType, int principalSn,
			int resourceSn, int permission, boolean yes) {
		//���������ʶ����Դ��ʶ����ACLʵ��
		ACL acl = aclDao.findACL(principalType,principalSn,resourceSn);
		
		//�������ACLʵ�������������Ȩ
		if(acl != null){
			acl.setPermission(permission, yes);
			aclDao.updatePermission(acl);
			return;
		}
		
		//������ACLʵ�����򴴽�ACLʵ��
		acl = new ACL();
		acl.setPrincipalType(principalType);
		acl.setPrincipalSn(principalSn);
		acl.setResourceSn(resourceSn);
		acl.setPermission(permission, yes);
		aclDao.addPermission(acl);
	}

	//�����û�ĳ����Դ��Ȩ�ļ̳�����
	@Override
	public void addOrUpdateUserExtends(int userId, int resourceSn, boolean yes) {
		//���������ʶ����Դ��ʶ����ACLʵ��
		ACL acl = aclDao.findACL(ACL.TYPE_USER,userId,resourceSn);
		
		//�������ACLʵ�������������Ȩ
		if(acl != null){
			acl.setExtends(yes);
			aclDao.updatePermission(acl);
			return;
		}
		
		//������ACLʵ�����򴴽�ACLʵ��
		acl = new ACL();
		acl.setPrincipalType(ACL.TYPE_USER);
		acl.setPrincipalSn(userId);
		acl.setResourceSn(resourceSn);
		aclDao.addPermission(acl);
	}

	//ɾ����Ȩ
	@Override
	public void delPermission(String principalType, int principalSn,
			int resourceSn) {
		aclDao.delPermission(aclDao.findACL(principalType, principalSn, resourceSn));
	}

	//��ʱ��֤
	@Override
	public boolean hasPermission(int userId, int resourceSn, int permission) {
		
		//����ֱ�������û�����Ȩ
		ACL acl = aclDao.findACL(ACL.TYPE_USER,userId,resourceSn);
		
		if(acl != null){
			int yesOrNo = acl.getPermission(permission);
			
			//�����ȷ������Ȩ
			if(yesOrNo != ACL.ACL_NEUTRAL){
				return yesOrNo == ACL.ACL_YES ? true :false;
			}
		}
		
		//���������û��Ľ�ɫ��Ȩ
		List aclIds = aclDao.findACLById(userId);
		
		//���ս�ɫ���ȼ����β�������Ȩ
		for(Iterator iter=aclIds.iterator();iter.hasNext();){
			Integer rid = (Integer)iter.next();
			acl = aclDao.findACL(ACL.TYPE_ROLE,rid,resourceSn);
			
			//һ��������Ȩ�����ɷ��ؽ��
			if(acl != null){
				return acl.getPermission(permission) == ACL.ACL_YES ? true : false;
			}
		}
		return false;
	}

	@Override
	public boolean hasPermissionByResourceSn(int userId, String resourceSn,int permission) {
		return hasPermission(userId,aclDao.findResourceSn(resourceSn),permission);
	}

	@Override
	public List searchAclRecord(String principalType, int principalSn) {
		return aclDao.searchAclRecord(principalType, principalSn);
	}

	//����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б����ڵ�¼���γɵ����˵���ʱ��
	@Override
	public List searchModules(int userId) {
		
		//������ʱ����
		Map temp = new HashMap();
		
		//�����ȼ��ӵ͵��߲����û�ӵ�еĽ�ɫ
		List aclIds = aclDao.findACLById(userId);
		
		//����ѭ����ɫ
		for(Iterator iter=aclIds.iterator();iter.hasNext();){
			Integer rid = (Integer)iter.next();
			
			//���ݽ�ɫ��ý�ɫӵ�е���Ȩ�б�
			//���ݽ�ɫ���ҽ�ɫ����Ȩ�б������б��Ԫ���ǣ�ACLʵ��
			List acls = aclDao.findRoleACLs(userId);
			
			//����Ȩ������ʱ����
			for(Iterator iterator=acls.iterator();iterator.hasNext();){
				ACL acl = (ACL)iterator.next();
				temp.put(acl.getResourceSn(), acl);
			}
		}
		
		//����ֱ�������û�����Ȩ�б�
		//�����û�����ֱ�������û�����Ȩ�б�ע�⣺���ֱ�������û�����Ȩ�Ǽ̳еĻ�����Ӧ�ð���������б��У������ص��б�Ԫ���ǣ�ACLʵ��
		List acls = aclDao.findUserACLs(userId);
		for(Iterator iter = acls.iterator();iter.hasNext();){
			ACL acl = (ACL)iter.next();
			temp.put(acl.getResourceSn(), acl);
		}
		
		//�����ѻ���û�ӵ�е�������Ȩ������ֱ�������û������Լ�������Ľ�ɫ����Ȩ)
		List delResources = new ArrayList();
		Set entries = temp.entrySet();
		for(Iterator iter=entries.iterator();iter.hasNext();){
			Map.Entry entry = (Map.Entry)iter.next();
			ACL acl = (ACL)entry.getValue();
			
			//���û�ж�ȡȨ�ޣ�����Ҫ����ʱ������ɾ�������Ȩ
			if(acl.getPermission(Permission.READ) == ACL.ACL_NO){
				delResources.add(entry.getKey());
			}
		}
		
		//����ʱ������ɾ����Щ��Ҫɾ������Ȩ
		for(Iterator iter = delResources.iterator();iter.hasNext();){
			Object key = iter.next();
			temp.remove(key);
		}
		
		//�����Ȩ�б��ǿյģ��򷵻�0���ȵļ���
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		//�����ѻ���û�ӵ�ж�ȡȨ�޵���Ȩ
		return aclDao.searchModules(temp);
	}
	
	public void setAclDao(AclDao aclDao) {
		this.aclDao = aclDao;
	}

}
