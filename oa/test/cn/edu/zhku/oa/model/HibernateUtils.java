package cn.edu.zhku.oa.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;

	private HibernateUtils() {

	}

	static {
		try {
			// Ĭ�϶�ȡhibernate.cfg.xml�ļ�
			Configuration cfg = new Configuration().configure();
			//����SessionFactory
			factory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	//ȡ��SessionFactory
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	//ȡ��Session
	public static Session getSession() {
		return factory.openSession();
	}

	//�ر�session
	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
