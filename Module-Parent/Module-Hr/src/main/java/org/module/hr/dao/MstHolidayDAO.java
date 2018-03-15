package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstHoliday;

public interface MstHolidayDAO {
	public void save(MstHoliday mstHoliday);
    public void update(MstHoliday mstHoliday);
    public void saveOrUpdate(MstHoliday mstHoliday);
    public void delete(MstHoliday mstHoliday);
    public List<MstHoliday> getAllMstHolidays();
    public List<MstHoliday> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstHoliday> getMstHolidayPaging(HashMap<String, Object> hashMap);
    public int getCountMstHolidays();
}