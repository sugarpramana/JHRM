package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstHolidayDAO;
import org.module.hr.dao.MstLeavePeriodDAO;
import org.module.hr.dao.MstLeaveTypeDAO;
import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private MstLeavePeriodDAO mstLeavePeriodDAO;
	
	@Autowired
    private MstLeaveTypeDAO mstLeaveTypeDAO;
    
	@Autowired
	private MstHolidayDAO mstHolidayDAO;

	@Override
	public void save(MstLeavePeriod mstLeavePeriod) {
		mstLeavePeriodDAO.save(mstLeavePeriod);
	}

	@Override
	public void update(MstLeavePeriod mstLeavePeriod) {
		mstLeavePeriodDAO.update(mstLeavePeriod);
	}

	@Override
	public void saveOrUpdate(MstLeavePeriod mstLeavePeriod) {
		mstLeavePeriodDAO.saveOrUpdate(mstLeavePeriod);
	}

	@Override
	public void delete(MstLeavePeriod mstLeavePeriod) {
		mstLeavePeriodDAO.delete(mstLeavePeriod);
	}

	@Override
	public List<MstLeavePeriod> getAllMstLeavePeriods() {
		return mstLeavePeriodDAO.getAllMstLeavePeriods();
	}

	@Override
	public List<MstLeavePeriod> getByMstLeavePeriodRequestMap(HashMap<String, Object> hashMap) {
		return mstLeavePeriodDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstLeavePeriod> getMstLeavePeriodPaging(HashMap<String, Object> hashMap) {
		return mstLeavePeriodDAO.getMstLeavePeriodPaging(hashMap);
	}

	@Override
	public int getCountMstLeavePeriods() {
		return mstLeavePeriodDAO.getCountMstLeavePeriods();
	}
	
	@Override
	public void save(MstLeaveType mstLeaveType) {
		mstLeaveTypeDAO.save(mstLeaveType);
	}

	@Override
	public void update(MstLeaveType mstLeaveType) {
		mstLeaveTypeDAO.update(mstLeaveType);
	}

	@Override
	public void saveOrUpdate(MstLeaveType mstLeaveType) {
		mstLeaveTypeDAO.saveOrUpdate(mstLeaveType);
	}

	@Override
	public void delete(MstLeaveType mstLeaveType) {
		mstLeaveTypeDAO.delete(mstLeaveType);
	}

	@Override
	public List<MstLeaveType> getAllMstLeaveTypes() {
		return mstLeaveTypeDAO.getAllMstLeaveTypes();
	}

	@Override
	public List<MstLeaveType> getByMstLeaveTypeRequestMap(HashMap<String, Object> hashMap) {
		return mstLeaveTypeDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstLeaveType> getMstLeaveTypePaging(HashMap<String, Object> hashMap) {
		return mstLeaveTypeDAO.getMstLeaveTypePaging(hashMap);
	}

	@Override
	public int getCountMstLeaveTypes() {
		return mstLeaveTypeDAO.getCountMstLeaveTypes();
	}

	@Override
	public void save(MstHoliday mstHoliday) {
		mstHolidayDAO.save(mstHoliday);
	}

	@Override
	public void update(MstHoliday mstHoliday) {
		mstHolidayDAO.update(mstHoliday);
	}

	@Override
	public void saveOrUpdate(MstHoliday mstHoliday) {
		mstHolidayDAO.saveOrUpdate(mstHoliday);
	}

	@Override
	public void delete(MstHoliday mstHoliday) {
		mstHolidayDAO.delete(mstHoliday);
	}

	@Override
	public List<MstHoliday> getAllMstHolidays() {
		return mstHolidayDAO.getAllMstHolidays();
	}

	@Override
	public List<MstHoliday> getByMstHolidayRequestMap(HashMap<String, Object> hashMap) {
		return mstHolidayDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap) {
		return mstHolidayDAO.getMstHolidayPaging(hashMap);
	}

	@Override
	public int getCountMstHolidays() {
		return mstHolidayDAO.getCountMstHolidays();
	}

	public MstLeavePeriodDAO getMstLeavePeriodDAO() {
		return mstLeavePeriodDAO;
	}

	public void setMstLeavePeriodDAO(MstLeavePeriodDAO mstLeavePeriodDAO) {
		this.mstLeavePeriodDAO = mstLeavePeriodDAO;
	}

	public MstLeaveTypeDAO getMstLeaveTypeDAO() {
		return mstLeaveTypeDAO;
	}

	public void setMstLeaveTypeDAO(MstLeaveTypeDAO mstLeaveTypeDAO) {
		this.mstLeaveTypeDAO = mstLeaveTypeDAO;
	}

	public MstHolidayDAO getMstHolidayDAO() {
		return mstHolidayDAO;
	}

	public void setMstHolidayDAO(MstHolidayDAO mstHolidayDAO) {
		this.mstHolidayDAO = mstHolidayDAO;
	}
}