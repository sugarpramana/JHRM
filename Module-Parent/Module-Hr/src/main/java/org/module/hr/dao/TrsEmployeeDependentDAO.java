package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeDependent;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeDependentDAO {
	public void save(TrsEmployeeDependent trsEmployeeDependent);
	public void update(TrsEmployeeDependent trsEmployeeDependent);
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent);
	public void delete(TrsEmployeeDependent trsEmployeeDependent);
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent();
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap);
	public List<TrsEmployeeDependent> getTrsEmployeeDependentPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeDependents();
}