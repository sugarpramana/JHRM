package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstWorkWeek;

/**
*
* @author formulateko@admin.com
*/
public interface MstWorkWeekDAO {
	public void save(MstWorkWeek mstWorkWeek);
    public void update(MstWorkWeek mstWorkWeek);
    public void saveOrUpdate(MstWorkWeek mstWorkWeek);
    public void delete(MstWorkWeek mstWorkWeek);
    public List<MstWorkWeek> getAllMstWorkWeeks();
    public List<MstWorkWeek> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstWorkWeek> getMstWorkWeekPaging(HashMap<String, Object> hashMap);
    public int getCountMstWorkWeeks();
}