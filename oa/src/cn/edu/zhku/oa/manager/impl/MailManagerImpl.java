package cn.edu.zhku.oa.manager.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.dao.MailDao;
import cn.edu.zhku.oa.manager.MailManager;
import cn.edu.zhku.oa.model.Mail;
   
/**   
 * ��һ���ʼ�����Ҫ����һ��ReciveMail����   
 */   
public class MailManagerImpl implements MailManager{   
	
	private MailDao mailDao;
    public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	private Message mimeMessage = null;    
    private String saveAttachPath = ""; //�������غ�Ĵ��Ŀ¼    
    private StringBuffer bodytext = new StringBuffer();//����ʼ�����    
    private String dateformat = "yy-MM-dd HH:mm"; //Ĭ�ϵ���ǰ��ʾ��ʽ   
    private String personal = null; //�û���
   
    public MailManagerImpl(Message mimeMessage) {    
        this.mimeMessage = mimeMessage;    
    }    
   
    public void setMimeMessage(MimeMessage mimeMessage) {    
        this.mimeMessage = mimeMessage;    
    }    
   
    /**   
     * ��÷����˵ĵ�ַ������   
     */  
    @Override
    public String getFrom(){    
        
        String fromaddr = "";
		try {
			InternetAddress[] address = (InternetAddress[]) mimeMessage.getFrom();
			String from = address[0].getAddress();    
	        if (from == null)    
	            from = "";    
	        personal = address[0].getPersonal();    
	        if (personal == null)    
	            personal = "";    
	        fromaddr = personal + "<" + from + ">";    
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
		return fromaddr;  
    }    
    
    /**   
     * ��÷����˵�����   
     */ 
    @Override
    public String getUserName(){
    	return personal;
    }
    
    /**   
     * ����ʼ����ռ��ˣ����ͣ������͵ĵ�ַ�����������������ݵĲ����Ĳ�ͬ "to"----�ռ��� "cc"---�����˵�ַ "bcc"---�����˵�ַ   
     */   
    @Override
    public String getMailAddress(String type) {    
        String mailaddr = "";    
        try {
			String addtype = type.toUpperCase();    
			InternetAddress[] address = null;    
			if (addtype.equals("TO") || addtype.equals("CC")|| addtype.equals("BCC")) {    
			    if (addtype.equals("TO")) {    
			        address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.TO);    
			    } else if (addtype.equals("CC")) {    
			        address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.CC);    
			    } else {    
			        address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.BCC);    
			    }    
			    if (address != null) {    
			        for (int i = 0; i < address.length; i++) {    
			            String email = address[i].getAddress();    
			            if (email == null)    
			                email = "";    
			            else {    
			                email = MimeUtility.decodeText(email);    
			            }    
			            String personal = address[i].getPersonal();    
			            if (personal == null)    
			                personal = "";    
			            else {    
			                personal = MimeUtility.decodeText(personal);    
			            }    
			            String compositeto = personal + "<" + email + ">";    
			            mailaddr += "," + compositeto;    
			        }    
			        mailaddr = mailaddr.substring(1);    
			    }    
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
        return mailaddr;    
    }    
   
    /**   
     * ����ʼ�����   
     */   
    @Override
    public String getSubject(){    
        String subject = "";    
       
        try {
			subject = MimeUtility.decodeText(mimeMessage.getSubject());    
			if (subject == null)    
			    subject = "";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
        return subject;    
    }    
   
    /**   
     * ����ʼ���������   
     */   
    @Override
    public String getSentDate(){ 
    	SimpleDateFormat format = null;
        Date sentdate = null;
		try {
			sentdate = mimeMessage.getSentDate();    
			format = new SimpleDateFormat(dateformat);
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
        return format.format(sentdate);    
    }    
    
    /**   
     * ����ʼ���������   
     */   
    @Override
    public String getBodyText() {
        return bodytext.toString();
    }    
   
    /**   
     * �����ʼ����ѵõ����ʼ����ݱ��浽һ��StringBuffer�����У������ʼ� ��Ҫ�Ǹ���MimeType���͵Ĳ�ִͬ�в�ͬ�Ĳ�����һ��һ���Ľ���   
     */   
    @Override
    public void getMailContent(Part part) {    
        try {
			String contenttype = part.getContentType();    
			int nameindex = contenttype.indexOf("name");    
			boolean conname = false;    
			if (nameindex != -1)    
			    conname = true;    
			System.out.println("CONTENTTYPE: " + contenttype);    
			if (part.isMimeType("text/plain") && !conname) {    
			    bodytext.append((String) part.getContent());    
			} else if (part.isMimeType("text/html") && !conname) {    
			    bodytext.append((String) part.getContent());    
			    System.out.println("COntent:"+bodytext.toString());
			} else if (part.isMimeType("multipart/*")) {    
			    Multipart multipart = (Multipart) part.getContent();    
			    int counts = multipart.getCount();    
			    for (int i = 0; i < counts; i++) {    
			        getMailContent(multipart.getBodyPart(i));    
			    }    
			} else if (part.isMimeType("message/rfc822")) {    
			    getMailContent((Part) part.getContent());    
			} else {
				/**
				 * �������ʵ�����뿴�������ݣ������������Ͳ���MIME����ô���������������Java����
				 */
				Object o = part.getContent();
				if (o instanceof String) {
					System.out.println("---------------This is just String------------");
					System.out.println((String) o);
				} else if (o instanceof InputStream) {
					System.out.println("------------This is just an input stream----------");
					InputStream is = (InputStream) o;
					int c;
					while ((c = is.read()) != -1)
						System.out.write(c);
				} else {
					System.out.println("--------This is an unknown type----------");
					System.out.println(o.toString());
				}
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }    
   
    /**    
     * �жϴ��ʼ��Ƿ���Ҫ��ִ�������Ҫ��ִ����"true",���򷵻�"false"   
     */    
    @Override
    public boolean getReplySign(){    
        boolean replysign = false;    
        try {
			String needreply[] = mimeMessage    
			        .getHeader("Disposition-Notification-To");    
			if (needreply != null) {    
			    replysign = true;    
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
        return replysign;    
    }    
    
    /**   
     * ��ô��ʼ���Message-ID   
     */   
    @Override
    public String getMessageId(){    
    	return null;
    }    
   
    /**   
     * �жϴ��ʼ��Ƿ��Ѷ������δ�����ط���false,��֮����true   
     */   
    @Override
    public boolean isNew() {    
        boolean isnew = false;    
        try {
			Flags flags = (mimeMessage).getFlags();    
			Flags.Flag[] flag = flags.getSystemFlags();    
			System.out.println("flags's length: " + flag.length);    
			for (int i = 0; i < flag.length; i++) {    
			    if (flag[i] == Flags.Flag.SEEN) {    
			        isnew = true;    
			        System.out.println("seen Message.......");    
			        break;    
			    }    
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}    
        return isnew;    
    }    
   
    /**   
     * �жϴ��ʼ��Ƿ��������   
     */   
    @Override
    public boolean isContainAttach(Part part) {    
        boolean attachflag = false;    
        try {
			String contentType = part.getContentType();    
			if (part.isMimeType("multipart/*")) {    
			    Multipart mp = (Multipart) part.getContent();    
			    for (int i = 0; i < mp.getCount(); i++) {    
			        BodyPart mpart = mp.getBodyPart(i);    
			        String disposition = mpart.getDisposition();    
			        if ((disposition != null)    
			                && ((disposition.equals(Part.ATTACHMENT)) || (disposition    
			                        .equals(Part.INLINE))))    
			            attachflag = true;    
			        else if (mpart.isMimeType("multipart/*")) {    
			            attachflag = isContainAttach(mpart);    
			        } else {    
			            String contype = mpart.getContentType();    
			            if (contype.toLowerCase().indexOf("application") != -1)    
			                attachflag = true;    
			            if (contype.toLowerCase().indexOf("name") != -1)    
			                attachflag = true;    
			        }    
			    }    
			} else if (part.isMimeType("message/rfc822")) {    
			    attachflag = isContainAttach((Part) part.getContent());    
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
        return attachflag;    
    }    
    
    /**
     * ��ȡ�ʼ���С
     * @param msg
     * @return
     */
    @Override
    public int getSize(Message msg){
    	int size = 0;
    	try {
			size = msg.getSize();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return size;
    }
   
    /**
     * ��ȡ�ʼ������
     * @param msg
     * @return
     */
    public int getMsgNum(Message msg){
    	return msg.getMessageNumber();
    }
    
    /**    
     * ���渽��    
     */    
    @Override
    public void saveAttachMent(Part part)  {    
        String fileName = "";    
        try {
			if (part.isMimeType("multipart/*")) {    
			    Multipart mp = (Multipart) part.getContent();    
			    for (int i = 0; i < mp.getCount(); i++) {    
			        BodyPart mpart = mp.getBodyPart(i);    
			        String disposition = mpart.getDisposition();    
			        if ((disposition != null)    
			                && ((disposition.equals(Part.ATTACHMENT)) || (disposition    
			                        .equals(Part.INLINE)))) {    
			            fileName = mpart.getFileName();    
			            if (fileName.toLowerCase().indexOf("gb2312") != -1) {    
			                fileName = MimeUtility.decodeText(fileName);    
			            }    
			            saveFile(fileName, mpart.getInputStream());    
			        } else if (mpart.isMimeType("multipart/*")) {    
			            saveAttachMent(mpart);    
			        } else {    
			            fileName = mpart.getFileName();    
			            if ((fileName != null)    
			                    && (fileName.toLowerCase().indexOf("GB2312") != -1)) {    
			                fileName = MimeUtility.decodeText(fileName);    
			                saveFile(fileName, mpart.getInputStream());    
			            }    
			        }    
			    }    
			} else if (part.isMimeType("message/rfc822")) {    
			    saveAttachMent((Part) part.getContent());    
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}    
    }    
   
    /**    
     * ���ø������·��    
     */    
    
    public void setAttachPath(String attachpath) {    
        this.saveAttachPath = attachpath;    
    }    
   
    /**   
     * ����������ʾ��ʽ   
     */   
    @Override
    public void setDateFormat(String format) {    
        this.dateformat = format;    
    }    
   
    /**   
     * ��ø������·��   
     */   
    @Override
    public String getAttachPath() {    
        return saveAttachPath;    
    }    
   
    /**   
     * �����ı��渽����ָ��Ŀ¼��   
     */   
    private void saveFile(String fileName, InputStream in) {    
        String osName = System.getProperty("os.name");    
        String storedir = getAttachPath();    
        String separator = "";    
        if (osName == null)    
            osName = "";    
        if (osName.toLowerCase().indexOf("win") != -1) {    
            separator = "\\";   
            if (storedir == null || storedir.equals(""))   
                storedir = "c:\\tmp";   
        } else {   
            separator = "/";   
            storedir = "/tmp";   
        }   
        File storefile = new File(storedir + separator + fileName);   
        System.out.println("storefile's path: " + storefile.toString());   
        
        BufferedOutputStream bos = null;   
        BufferedInputStream bis = null;   
        try {
			bos = new BufferedOutputStream(new FileOutputStream(storefile));   
			bis = new BufferedInputStream(in);   
			int c;   
			while ((c = bis.read()) != -1) {   
			    bos.write(c);   
			    bos.flush();   
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();   
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}   
		}
        
    }

	@Override
	public void addMail(Mail mail) {
		mailDao.addMail(mail);		
	}

	@Override
	public void delMail(int mailId) {
		mailDao.delMail(mailId);		
	}

	@Override
	public PagerModel findMail(int userId) {
		return mailDao.findMail(userId);
	}

	@Override
	public Mail findMailById(int mailId) {
		return mailDao.findMailById(mailId);
	}

	@Override
	public PagerModel findMails() {
		return mailDao.findMails();
	}

	@Override
	public void updateMail(Mail mail) {
		mailDao.updateMail(mail);		
	}   
}   
