package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;
import org.module.hr.model.TrsEntitlement;
import org.module.hr.model.TrsLeave;

public interface LeaveService {
	/*- Leave +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsLeave trsLeave);
    public void update(TrsLeave trsLeave);
    public void saveOrUpdate(TrsLeave trsLeave);
    public void delete(TrsLeave trsLeave);
    public List<TrsLeave> getAllTrsLeaves();
    public List<TrsLeave> getByTrsLeaveRequestMap(HashMap<String, Object> hashMap);
    public List<TrsLeave> getTrsLeavePaging(HashMap<String, Object> hashMap);
    public int getCountTrsLeaves();
    
	/*- Leave Entitlement +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(TrsEntitlement trsEntitlement);
    public void update(TrsEntitlement trsEntitlement);
    public void saveOrUpdate(TrsEntitlement trsEntitlement);
    public void delete(TrsEntitlement trsEntitlement);
    public List<TrsEntitlement> getAllTrsEntitlements();
    public List<TrsEntitlement> getByTrsEntitlementRequestMap(HashMap<String, Object> hashMap);
    public List<TrsEntitlement> getTrsEntitlementPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEntitlements();
    
	/*- Leave Period +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstLeavePeriod mstLeavePeriod);
    public void update(MstLeavePeriod mstLeavePeriod);
    public void saveOrUpdate(MstLeavePeriod mstLeavePeriod);
    public void delete(MstLeavePeriod mstLeavePeriod);
    public List<MstLeavePeriod> getAllMstLeavePeriods();
    public List<MstLeavePeriod> getByMstLeavePeriodRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeavePeriod> getMstLeavePeriodPaging(HashMap<String, Object> hashMap);
    public int getCountMstLeavePeriods();
	
    /*- Leave Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstLeaveType mstLeaveType);
    public void update(MstLeaveType mstLeaveType);
    public void saveOrUpdate(MstLeaveType mstLeaveType);
    public void delete(MstLeaveType mstLeaveType);
    public List<MstLeaveType> getAllMstLeaveTypes();
    public List<MstLeaveType> getByMstLeaveTypeRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeaveType> getMstLeaveTypePaging(HashMap<String, Object> hashMap);
    public int getCountMstLeaveTypes();
    
    /*- Holiday +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstHoliday mstHoliday);
    public void update(MstHoliday mstHoliday);
    public void saveOrUpdate(MstHoliday mstHoliday);
    public void delete(MstHoliday mstHoliday);
    public List<MstHoliday> getAllMstHolidays();
    public List<MstHoliday> getByMstHolidayRequestMap(HashMap<String, Object> hashMap);
    public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap);
    public int getCountMstHolidays();
}