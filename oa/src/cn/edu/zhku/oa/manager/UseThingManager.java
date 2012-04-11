package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;

/**
 * ��Ʒ�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-15 ����01:58:35
 */
public interface UseThingManager {
	public void addUseThing(UseThing useThing,int categoryId);
	public void delUseThing(int useThingId);
	public void updateUseThing(UseThing useThing,int categoryId);
	public UseThing findUseThing(int useThingId);
	public PagerModel findUseThing(Category category);
	public PagerModel findUseThings();
}
