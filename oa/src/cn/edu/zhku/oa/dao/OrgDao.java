package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Organization;

/**
 * ��������־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����10:29:39
 */
public interface OrgDao {

	public void addOrg(Organization org);
	
	public void delOrg(Organization org);
	
	public void updateOrg(Organization org);
	
	public Organization findOrg(int orgId);
	
	public PagerModel findOrgs();
	
	public PagerModel findOrgs(int parentId);
}
