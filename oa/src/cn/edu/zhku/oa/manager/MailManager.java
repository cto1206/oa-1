package cn.edu.zhku.oa.manager;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Mail;

/**   
 * �ʼ��ӿ�   
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-18 ����04:02:50
 */
public interface MailManager {    
   
    /**   
     * ��÷����˵ĵ�ַ������   
     */   
    public String getFrom();
    
    /**   
     * ��÷����˵�����   
     */ 
    public String getUserName();
    
   
    /**   
     * ����ʼ����ռ��ˣ����ͣ������͵ĵ�ַ�����������������ݵĲ����Ĳ�ͬ "to"----�ռ��� "cc"---�����˵�ַ "bcc"---�����˵�ַ   
     */   
    public String getMailAddress(String type);   
      
   
    /**   
     * ����ʼ�����   
     * @throws MessagingException 
     */   
    public String getSubject();   
       
   
    /**   
     * ����ʼ���������   
     */   
    public String getSentDate();    
      
    
    /**   
     * ����ʼ���������   
     */   
    public String getBodyText();   
   
   
    /**   
     * �����ʼ����ѵõ����ʼ����ݱ��浽һ��StringBuffer�����У������ʼ� ��Ҫ�Ǹ���MimeType���͵Ĳ�ִͬ�в�ͬ�Ĳ�����һ��һ���Ľ���   
     */   
    public void getMailContent(Part part);    
      
   
    /**    
     * �жϴ��ʼ��Ƿ���Ҫ��ִ�������Ҫ��ִ����"true",���򷵻�"false"   
     */    
    public boolean getReplySign() ;    
      
    
    /**   
     * ��ô��ʼ���Message-ID   
     */   
    public String getMessageId();
   
    /**   
     * �жϴ��ʼ��Ƿ��Ѷ������δ�����ط���false,��֮����true
     */   
    public boolean isNew() ;   
      
   
    /**   
     * �жϴ��ʼ��Ƿ��������   
     */   
    public boolean isContainAttach(Part part);    
    
    /**
     * ��ȡ�ʼ���С
     * @param msg
     * @return
     */
    public int getSize(Message msg);
    
    /**
     * ��ȡ�ʼ������
     * @param msg
     * @return
     */
    public int getMsgNum(Message msg);
     
    /**    
     * ���渽��    
     */    
    public void saveAttachMent(Part part) ;    
       
    /**   
     * ����������ʾ��ʽ   
     */   
    public void setDateFormat(String format);    
   
    /**   
     * ��ø������·��   
     */   
    public String getAttachPath();    
    
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
