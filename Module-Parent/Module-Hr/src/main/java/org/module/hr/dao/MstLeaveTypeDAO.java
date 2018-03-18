package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstLeaveType;

/**
*
* @author formulateko@admin.com
*/
public interface MstLeaveTypeDAO {
	public void save(MstLeaveType mstLeaveType);
    public void update(MstLeaveType mstLeaveType);
    public void saveOrUpdate(MstLeaveType mstLeaveType);
    public void delete(MstLeaveType mstLeaveType);
    public List<MstLeaveType> getAllMstLeaveTypes();
    public List<MstLeaveType> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstLeaveType> getMstLeaveTypePaging(HashMap<String, Object> hashMap);
    public int getCountMstLeaveTypes();
}