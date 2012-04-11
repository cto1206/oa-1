package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Person;
/**
 * ��Ա����־û��ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-2-15 ����01:02:09
 */
public interface PersonDao {

	/**
	 * �����Ա��Ϣ
	 * @param person ��Ա��Ϣ
	 */
	public void addPerson(Person person);
	
	/**
	 * ������Ա����Ϣ
	 * @param person ��Ա��Ϣ
	 */
	public void updatePerson(Person person);
	
	/**
	 * ������Ա��ʶɾ����Ա��Ϣ
	 * @param person ��Ա��Ϣ
	 */
	public void delPerson(Person person);
	
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
