package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstHoliday;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.model.MstLeaveType;

public interface LeaveService {
	public void save(MstLeavePeriod mstLeavePeriod);
    public void update(MstLeavePeriod mstLeavePeriod);
    public void saveOrUpdate(MstLeavePeriod mstLeavePeriod);
    public void delete(MstLeavePeriod mstLeavePeriod);
    public List<MstLeavePeriod> getAllMstLeavePeriods();
    public List<MstLeavePeriod> getByMstLeavePeriodRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeavePeriod> getMstLeavePeriodPaging(HashMap<String, Object> hashMap);
    public int getCountMstLeavePeriods();
	
	public void save(MstLeaveType mstLeaveType);
    public void update(MstLeaveType mstLeaveType);
    public void saveOrUpdate(MstLeaveType mstLeaveType);
    public void delete(MstLeaveType mstLeaveType);
    public List<MstLeaveType> getAllMstLeaveTypes();
    public List<MstLeaveType> getByMstLeaveTypeRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeaveType> getMstLeaveTypePaging(HashMap<String, Object> hashMap);
    public int getCountMstLeaveTypes();
    
    public void save(MstHoliday mstHoliday);
    public void update(MstHoliday mstHoliday);
    public void saveOrUpdate(MstHoliday mstHoliday);
    public void delete(MstHoliday mstHoliday);
    public List<MstHoliday> getAllMstHolidays();
    public List<MstHoliday> getByMstHolidayRequestMap(HashMap<String, Object> hashMap);
    public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap);
    public int getCountMstHolidays();
}