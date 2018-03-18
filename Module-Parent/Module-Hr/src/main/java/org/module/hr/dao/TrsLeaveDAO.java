package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsLeave;

/**
*
* @author formulateko@admin.com
*/
public interface TrsLeaveDAO {
	public void save(TrsLeave trsLeave);
    public void update(TrsLeave trsLeave);
    public void saveOrUpdate(TrsLeave trsLeave);
    public void delete(TrsLeave trsLeave);
    public List<TrsLeave> getAllTrsLeaves();
    public List<TrsLeave> getByRequestMap(HashMap<String, Object> hashMap);
    public List<TrsLeave> getTrsLeavePaging(HashMap<String, Object> hashMap);
    public int getCountTrsLeaves();
}