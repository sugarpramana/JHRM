package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstLeavePeriod;

/**
*
* @author formulateko@admin.com
*/
public interface MstLeavePeriodDAO {
	public void save(MstLeavePeriod mstLeavePeriod);
    public void update(MstLeavePeriod mstLeavePeriod);
    public void saveOrUpdate(MstLeavePeriod mstLeavePeriod);
    public void delete(MstLeavePeriod mstLeavePeriod);
    public List<MstLeavePeriod> getAllMstLeavePeriods();
    public List<MstLeavePeriod> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeavePeriod> getMstLeavePeriodPaging(HashMap<String, Object> hashMap);
    public int getCountMstLeavePeriods();
}