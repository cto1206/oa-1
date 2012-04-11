package cn.edu.zhku.oa.manager;

import cn.edu.zhku.oa.PagerModel;
import cn.edu.zhku.oa.model.Car;

/**
 * �����ӿ�
 * ��д���ߣ���Ȩ
 * ��д���ڣ�2011-4-13 ����10:29:05
 */
public interface CarManager {
	/**
	 * ��ӳ���
	 * @param car
	 */
	public void addCar(Car car);
	
	/**
	 * ɾ������
	 * @param carId
	 */
	public void delCar(int carId);
	
	/**
	 * �޸ĳ���
	 * @param car
	 */
	public void updateCar(Car car);
	
	/**
	 * �����ض�����
	 * @param carId
	 * @return
	 */
	public Car findCarById(int carId);
	
	/**
	 * �������г���
	 * @return
	 */
	public PagerModel findCars();
	
	/**
	 * ���ݽ���״̬���ҳ���
	 * @param status
	 * @return
	 */
	public PagerModel findCar(boolean status);
	
	/**
	 * ����ָ���û�����ĳ���
	 * @param carId
	 * @param userId
	 * @return
	 */
	public PagerModel findCar(int userId);
	
	/**
	 * ���ó���
	 * @param car
	 */
	public void borrowCar(int carId,int userId);
	
	/**
	 * �黹����
	 * @param car
	 */
	public void returnCar(int carId);
	
}
