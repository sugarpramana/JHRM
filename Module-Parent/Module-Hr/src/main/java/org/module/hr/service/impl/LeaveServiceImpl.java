package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstHolidayDAO;
import org.module.hr.dao.MstLeavePeriodDAO;
import org.module.hr.dao.MstLeaveTypeDAO;
import org.module.hr.dao.TrsEntitlementDAO;
import org.module.hr.dao.TrsLeaveDAO;
import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.model.TrsEntitlement;
import org.module.hr.model.TrsLeave;
import org.module.hr.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private TrsLeaveDAO trsLeaveDAO;
	
	@Autowired
	private TrsEntitlementDAO trsEntitlementDAO;
	
	@Autowired
	private MstLeavePeriodDAO mstLeavePeriodDAO;
	
	@Autowired
    private MstLeaveTypeDAO mstLeaveTypeDAO;
    
	@Autowired
	private MstHolidayDAO mstHolidayDAO;

	@Override
	public void save(TrsLeave trsLeave) {
		trsLeaveDAO.save(trsLeave);
	}

	@Override
	public void update(TrsLeave trsLeave) {
		trsLeaveDAO.update(trsLeave);
	}

	@Override
	public void saveOrUpdate(TrsLeave trsLeave) {
		trsLeaveDAO.saveOrUpdate(trsLeave);
	}

	@Override
	public void delete(TrsLeave trsLeave) {
		trsLeaveDAO.delete(trsLeave);
	}

	@Override
	public List<TrsLeave> getAllTrsLeaves() {
		return trsLeaveDAO.getAllTrsLeaves();
	}

	@Override
	public List<TrsLeave> getByTrsLeaveRequestMap(HashMap<String, Object> hashMap) {
		return trsLeaveDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<TrsLeave> getTrsLeavePaging(HashMap<String, Object> hashMap) {
		return trsLeaveDAO.getTrsLeavePaging(hashMap);
	}

	@Override
	public int getCountTrsLeaves() {
		return trsLeaveDAO.getCountTrsLeaves();
	}

	@Override
	public void save(TrsEntitlement trsEntitlement) {
		trsEntitlementDAO.save(trsEntitlement);
	}

	@Override
	public void update(TrsEntitlement trsEntitlement) {
		trsEntitlementDAO.update(trsEntitlement);
	}

	@Override
	public void saveOrUpdate(TrsEntitlement trsEntitlement) {
		trsEntitlementDAO.saveOrUpdate(trsEntitlement);
	}

	@Override
	public void delete(TrsEntitlement trsEntitlement) {
		trsEntitlementDAO.delete(trsEntitlement);
	}

	@Override
	public List<TrsEntitlement> getAllTrsEntitlements() {
		return trsEntitlementDAO.getAllTrsEntitlements();
	}

	@Override
	public List<TrsEntitlement> getByTrsEntitlementRequestMap(HashMap<String, Object> hashMap) {
		return trsEntitlementDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<TrsEntitlement> getTrsEntitlementPaging(HashMap<String, Object> hashMap) {
		return trsEntitlementDAO.getTrsEntitlementPaging(hashMap);
	}

	@Override
	public int getCountTrsEntitlements() {
		return trsEntitlementDAO.getCountTrsEntitlements();
	}
	
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

	public TrsLeaveDAO getTrsLeaveDAO() {
		return trsLeaveDAO;
	}

	public void setTrsLeaveDAO(TrsLeaveDAO trsLeaveDAO) {
		this.trsLeaveDAO = trsLeaveDAO;
	}

	public TrsEntitlementDAO getTrsEntitlementDAO() {
		return trsEntitlementDAO;
	}

	public void setTrsEntitlementDAO(TrsEntitlementDAO trsEntitlementDAO) {
		this.trsEntitlementDAO = trsEntitlementDAO;
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