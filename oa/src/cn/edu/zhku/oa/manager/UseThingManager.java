package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Category;
import cn.edu.zhku.oa.model.UseThing;

/**
 * 用品接口
 * 编写作者：许权
 * 编写日期：2011-4-15 下午01:58:35
 */
public interface UseThingManager {
	public void addUseThing(UseThing useThing,int categoryId);
	public void delUseThing(int useThingId);
	public void updateUseThing(UseThing useThing,int categoryId);
	public UseThing findUseThing(int useThingId);
	public PagerModel findUseThing(Category category);
	public PagerModel findUseThings();
}
