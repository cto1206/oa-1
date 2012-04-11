package cn.edu.zhku.oa.dao.impl;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.dao.AclDao;
import cn.edu.zhku.oa.model.ACL;

public class AclDaoImpl extends AbstractDao implements AclDao {

	//��Ȩ����
	@Override
	public void addPermission(ACL acl) {
		this.getHibernateTemplate().save(acl);
	}
	
	@Override
	public void updatePermission(ACL acl) {
		this.getHibernateTemplate().update(acl);
	}

	//ɾ����Ȩ
	@Override
	public void delPermission(ACL acl) {
		this.getHibernateTemplate().delete(acl);
	}

	@Override
	public List searchAclRecord(String principalType, int principalSn) {
		String sql = "select resourceSn,aclState&1,aclState&2,"+
				"aclState&4,aclState&8,aclTriState " + 
				"from T_ACL where principalType = '"+principalType +
				"' and principalSn = "+principalSn;
		
		return this.getSession().createSQLQuery(sql).list();
	}

	//����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б����ڵ�¼���γɵ����˵���ʱ��
	@Override
	public List searchModules(Map temp){
		
		//�����ѻ���û�ӵ�ж�ȡȨ�޵���Ȩ
		String searchModules = "select m from Module m where m.id in (:ids)";
		return getSession().createQuery(searchModules)
				.setParameterList("ids", temp.keySet())
				.list();
	}
	
	//�����������͡������ʶ����Դ��ʶ����ACLʵ��
	@Override
	public ACL findACL(String principalType, int principalSn, int resourceSn) {
		return (ACL)getSession().createQuery(
				"select acl from ACL acl where acl.principalType=?"+
				"and acl.principalSn=? and acl.resourceSn=?")
				.setParameter(0, principalType)
				.setParameter(1, principalSn)
				.setParameter(2, resourceSn)
				.uniqueResult();
	}

	//�����û�����ֱ�������û�����Ȩ�б�ע�⣺���ֱ�������û�����Ȩ�Ǽ̳еĻ�����Ӧ�ð���������б��У������ص��б�Ԫ���ǣ�ACLʵ��
	@Override
	public List findUserACLs(int userId) {
		String hql = "select acl from ACL acl where acl.principalType = ? " +
			"and acl.principalSn = ? and acl.aclTriState = 0";		
		return getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_USER,userId});
	}

	//���ݽ�ɫ���ҽ�ɫ����Ȩ�б������б��Ԫ���ǣ�ACLʵ��
	@Override
	public List findRoleACLs(Integer userId) {
		String hql = "select acl from ACL acl where acl.principalType = ? "+
				"and acl.principalSn= ? ";
		return this.getHibernateTemplate().find(hql, new Object[]{ACL.TYPE_ROLE,userId});
	}

	@Override
	public List findACLById(int userId) {
		
		//�����ȼ��ӵ͵��߲����û�ӵ�еĽ�ɫ
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " + 
					 "where u.id = ? order by ur.orderNo desc";
		List aclIds = this.getHibernateTemplate().find(hql,userId);
		return aclIds;
	}

	@Override
	public int findResourceSn(String resourceSn) {
		String hql = "select m.id from Module m where m.sn=? ";
		return (Integer)getSession().createQuery(hql).setParameter(0, resourceSn).uniqueResult();
	}

}
