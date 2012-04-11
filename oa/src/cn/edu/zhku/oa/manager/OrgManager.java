package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Organization;

/**
 * ��������ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����10:30:29
 */
public interface OrgManager {

	/**
	 * ��ӻ�����Ϣ
	 * @param org
	 * @param parentId ����Action�Ĺ���������Action�߼��ĵ�һ�ԣ���OrgManager���
	 */
	public void addOrg(Organization org,int parentId);
	
	public void delOrg(int orgId);
	
	public void updateOrg(Organization org,int parentId);
	
	public Organization findOrg(int orgId);
	
	/**
	 * ���һ����б�
	 * ���parentIdΪ0������Ҷ��������б�
	 * @param parentId
	 * @return
	 */
	public PagerModel findOrgs(int parentId);
}
