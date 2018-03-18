package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsEmployee;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeDAO {
	public void save(TrsEmployee trsEmployee);
	public void update(TrsEmployee trsEmployee);
	public void saveOrUpdate(TrsEmployee trsEmployee);
	public void delete(TrsEmployee trsEmployee);
	public List<TrsEmployee> getAllTrsEmployees();
	public List<TrsEmployee> getByRequestMap(HashMap<String, Object> hashMap);
	public List<TrsEmployee> getMstTrsEmployeePaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployees();
}