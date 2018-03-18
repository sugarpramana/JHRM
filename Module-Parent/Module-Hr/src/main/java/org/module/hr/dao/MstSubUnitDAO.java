package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstSubUnit;

/**
*
* @author formulateko@admin.com
*/
public interface MstSubUnitDAO {
	public void save(MstSubUnit mstSubUnit);
    public void update(MstSubUnit mstSubUnit);
    public void saveOrUpdate(MstSubUnit mstSubUnit);
    public void delete(MstSubUnit mstSubUnit);
    public List<MstSubUnit> getAllMstSubUnitts();
    public List<MstSubUnit> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstSubUnit> getMstSubUnitPaging(HashMap<String, Object> hashMap);
    public int getCountMstSubUnits();
}