package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Person;
/**
 * ��Ա����ӿ�
 * ���ߣ���Ȩ
 * ʱ�䣺2010-7-19 ����08:39:04
 */
public interface PersonManager {

	/**
	 * �����Ա��Ϣ
	 * @param person ��Ա��Ϣ
	 * @param orgId ���������ı�ʶ
	 */
	public void addPerson(Person person,int orgId);
	
	/**
	 * ������Ա����Ϣ
	 * @param person ��Ա��Ϣ
	 * @param orgId ���������ı�ʶ
	 */
	public void updatePerson(Person person,int orgId);
	
	/**
	 * ������Ա��ʶɾ����Ա��Ϣ
	 * @param personId ��Ա��ʶ
	 */
	public void delPerson(int personId);
	
	/**
	 * �����ض���Ա����Ϣ
	 * @param personId ��Ա��ʶ
	 * @return
	 */
	public Person findPerson(int personId);
	
	/**
	 * ����������Ա���б���ҳ��ѯ��
	 * @return
	 */
	public PagerModel searchPersons();
	
	/**
	 * ����ĳ�������µ���Ա�б�
	 * @param orgId
	 * @return
	 */
	public PagerModel searchPersons(int orgId);
}
