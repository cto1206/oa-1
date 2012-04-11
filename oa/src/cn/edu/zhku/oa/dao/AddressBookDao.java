package cn.edu.zhku.oa.dao;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.AddressBook;

/**
 * ͨ��¼�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-11 ����11:48:42
 */
public interface AddressBookDao {
	
	/**
	 * ���ͨ��¼
	 * @param addressBook
	 */
	public void addAddressBook(AddressBook addressBook);
	
	/**
	 * ɾ��ͨ��¼
	 * @param addressBookId
	 */
	public void delAddressBook(int addressBookId);
	
	/**
	 * �޸�ͨ��¼
	 * @param addressBook
	 */
	public void updateAddressBook(AddressBook addressBook);
	
	/**
	 * ����id����ͨ��¼
	 * @param addressBookId
	 * @return
	 */
	public AddressBook findAddressBookById(int addressBookId);
	
	/**
	 * ��������ͨ��¼
	 * @return
	 */
	public PagerModel findAddressBooks(int userId);
}
