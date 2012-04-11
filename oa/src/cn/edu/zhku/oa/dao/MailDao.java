package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Mail;

/**
 * �ʼ��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-18 ����03:49:57
 */
public interface MailDao {
	/**
	 * ����ʼ�
	 */
	public void addMail(Mail mail);
	
	/**
	 * ɾ���ʼ�
	 */
	public void delMail(int mailId);
	
	/**
	 * �޸��ʼ�
	 */
	public void updateMail(Mail mail);
	
	/**
	 * �����ض��ʼ�
	 * @param mailId
	 * @return
	 */
	public Mail findMailById(int mailId);
	
	/**
	 * ���������ʼ�
	 * @return
	 */
	public PagerModel findMails();
	
	/**
	 * ����ĳ�û����͵��ʼ�
	 * @param userId
	 * @return
	 */
	public PagerModel findMail(int userId);
	
}
