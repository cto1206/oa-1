package cn.edu.zhku.oa.manager.impl;

import java.util.Date;
import java.util.List;

import cn.edu.zhku.oa.dao.MeetingRoomDao;
import cn.edu.zhku.oa.manager.MeetingRoomManager;
import cn.edu.zhku.oa.manager.SystemException;
import cn.edu.zhku.oa.model.MeetingRoom;
import cn.edu.zhku.oa.model.MeetingRoomApply;

public class MeetingRoomManagerImpl implements MeetingRoomManager {

	private MeetingRoomDao meetingRoomDao;
	public void setMeetingRoomDao(MeetingRoomDao meetingRoomDao) {
		this.meetingRoomDao = meetingRoomDao;
	}

	public void addRoom(MeetingRoom room) {
		meetingRoomDao.addRoom(room);
	}

	public void applyRoom(MeetingRoomApply apply,String sn) {
		
		//�Ƿ��г�ͻ��
		Long size = meetingRoomDao.findSize(apply, sn);
		if(size >= 1){
			throw new SystemException("������Ļ������������˵������г�ͻ�����������룡");
		}
		apply.setRoom(meetingRoomDao.findMeetingRoom(sn));
		meetingRoomDao.applyRoom(apply);
	}

	public MeetingRoomApply findRoomApply(int applyId) {
		return meetingRoomDao.findRoomApply(applyId);
	}

	public void updateApply(MeetingRoomApply apply, String sn) {
		//�Ƿ��г�ͻ��
		Long size = meetingRoomDao.findSizeForUpdate(apply, sn);
		if(size >= 1){
			throw new SystemException("������Ļ������������˵������г�ͻ�����������룡");
		}		
		apply.setRoom(meetingRoomDao.findMeetingRoom(sn));		
		meetingRoomDao.updateApply(apply);
	}

	public List searchAllRooms() {
		return meetingRoomDao.searchAllRooms();
	}

	public List searchApplies(Date begin, Date end) {
		return meetingRoomDao.searchApplies(begin, end);
	}

}
