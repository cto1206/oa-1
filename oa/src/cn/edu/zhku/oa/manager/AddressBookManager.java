package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.AddressBook;

/**
 * ͨ��¼�ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-12 ����12:12:46
 */
public interface AddressBookManager {
	/**
	 * ���ͨ��¼
	 * @param addressBook
	 */
	public void addAddressBook(AddressBook addressBook, int userId);
	
	/**
	 * ɾ��ͨ��¼
	 * @param addressBookId
	 */
	public void delAddressBook(int addressBookId);
	
	/**
	 * �޸�ͨ��¼
	 * @param addressBook
	 */
	public void updateAddressBook(AddressBook addressBook, int userId);
	
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
