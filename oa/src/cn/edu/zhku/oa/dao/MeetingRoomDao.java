package cn.edu.zhku.oa.dao;

import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.model.MeetingRoom;
import cn.edu.zhku.oa.model.MeetingRoomApply;

public interface MeetingRoomDao {
	public void addRoom(MeetingRoom room);
	public void applyRoom(MeetingRoomApply apply);
	public MeetingRoomApply findRoomApply(int applyId);
	public void updateApply(MeetingRoomApply apply);
	
	/**
	 * ����������
	 * @return
	 */
	public List searchAllRooms();
	
	/**
	 * ���������������¼
	 * @param begin
	 * @param end
	 * @return
	 */
	public List searchApplies(Date begin,Date end);
	
	/**
	 * �����Ƿ��ͻ
	 * @param apply
	 * @return
	 */
	public long findSize(MeetingRoomApply apply,String sn);
	
	/**
	 * �����Ƿ��ͻ
	 * @param apply
	 * @return
	 */
	public long findSizeForUpdate(MeetingRoomApply apply,String sn);
	
	/**
	 * ͨ��sn���һ�����
	 * @param sn
	 * @return
	 */
	public MeetingRoom findMeetingRoom(String sn);
}
