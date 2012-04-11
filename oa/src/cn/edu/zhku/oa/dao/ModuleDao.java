package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Module;

/**
 * ģ�����־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����02:54:38
 */
public interface ModuleDao {
	
	/**
	 * ���ģ����Ϣ
	 * @param module ģ����Ϣ
	 */
	public void addModule(Module module);
	
	/**
	 * ɾ��ģ��
	 * @param module
	 */
	public void delModule(Module module);
	
	/**
	 * ����ģ����Ϣ
	 * @param module
	 */
	public void updateModule(Module module);
	
	/**
	 * ��ѯ�ض���ģ��
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);
	
	/**
	 * ��ҳ��ѯģ�����Ϣ
	 * @param parentId
	 * @return
	 */
	public PagerModel searchModules(int parentId);
	
	/**
	 * ��ҳ��ѯģ�����Ϣ(�鶥��ģ��)
	 * @return
	 */
	public PagerModel searchModules();
	
}
