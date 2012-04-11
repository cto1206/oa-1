package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;

/**
 * ��Ʒ�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-15 ����01:58:35
 */
public interface UseThingDao {
	public void addUseThing(UseThing useThing);
	public void delUseThing(int useThingId);
	public void updateUseThing(UseThing useThing);
	public UseThing findUseThing(int useThingId);
	public PagerModel findUseThing(Category category);
	public PagerModel findUseThings();
}
