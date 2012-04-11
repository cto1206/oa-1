package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Info;

/**
 * ������Ϣ�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-14 ����10:23:13
 */
public interface InfoManager {
	/**
	 * �����Ϣ
	 * @param info
	 */
	public void addInfo(Info info,int userId);
	
	/**
	 * ɾ����Ϣ
	 * @param infoId
	 */
	public void delInfo(int infoId);
	
	/**
	 * ������Ϣ
	 * @param info
	 */
	public void updateInfo(Info info);
	
	/**
	 * ����Id������Ϣ
	 * @param infoId
	 * @return
	 */
	public Info findInfoById(int infoId);
	
	/**
	 * �����û�Id������Ϣ
	 * @param userId
	 * @return
	 */
	public PagerModel findInfo(int userId);
	
	/**
	 * ����������Ϣ
	 * @return
	 */
	public PagerModel findInfos();
	
	/**
	 * ����ʱ�������Ϣ
	 * @return
	 */
	public PagerModel findInfoByTime();
}
