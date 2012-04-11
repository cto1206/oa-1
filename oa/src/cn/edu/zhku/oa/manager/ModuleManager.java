package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Module;

public interface ModuleManager {
	
	/**
	 * ���ģ����Ϣ�������ģ���IDΪ0������Ӷ���ģ��
	 * @param module ģ����Ϣ
	 * @param parentId ��ģ���ID
	 */
	public void addModule(Module module,int parentId);
	
	/**
	 * ɾ��ģ��
	 * @param moduleId
	 */
	public void delModule(int moduleId);
	
	/**
	 * ����ģ����Ϣ
	 * @param module
	 * @param parentId
	 */
	public void updateModule(Module module,int parentId);
	
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
}
