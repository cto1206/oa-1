package cn.edu.zhku.oa.dao;

import java.util.List;
import java.util.Map;

import cn.edu.zhku.oa.model.ACL;

/**
 * ��Ȩ�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����07:04:37
 */
public interface AclDao {
	
	/**
	 * ��Ȩ
	 * @param principalType ��������
	 * @param principalSn �����ʶ
	 * @param resourceSn ��Դ��ʶ
	 * @param permission Ȩ�ޣ�C/R/U/D
	 * @param yes �Ƿ�����true��ʾ����false��ʾ������
	 */
	public void addPermission(ACL acl);
	public void updatePermission(ACL acl);
	
	/**
	 * ɾ����Ȩ
	 * @param acl
	 */
	public void delPermission(ACL acl);
	
	/**
	 * ����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б����ڵ�¼���γɵ����˵���ʱ��
	 * @return ģ���б����б��Ԫ����Module����
	 */
	public List searchModules(Map map);
	
	/**
	 * �����������ͺ������ʶ����ACL��¼
	 * @param principalType
	 * @param principalSn
	 * @return
	 */
	public List searchAclRecord(String principalType,int principalSn);
	
	/**
	 * ������Ȩ
	 * @param principalType
	 * @param principalSn
	 * @param resourceSn
	 * @return
	 */
	public ACL findACL(String principalType, int principalSn, int resourceSn);
	
	/**
	 * ͨ���û�Id�����û���Ȩ
	 * @param userId
	 * @return
	 */
	public List findACLById(int userId);
	
	/**
	 * ������Դ��ʶ
	 * @param resourceSn
	 * @return
	 */
	public int findResourceSn(String resourceSn);
	
	public List findUserACLs(int userId);
	
	public List findRoleACLs(Integer userId);
}
