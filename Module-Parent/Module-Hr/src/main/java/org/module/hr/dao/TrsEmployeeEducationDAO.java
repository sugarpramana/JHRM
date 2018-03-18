package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeEducation;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeEducationDAO {
	public void save(TrsEmployeeEducation trsEmployeeEducation);
	public void update(TrsEmployeeEducation trsEmployeeEducation);
	public void saveOrUpdate(TrsEmployeeEducation trsEmployeeEducation);
	public void delete(TrsEmployeeEducation trsEmployeeEducation);
	public List<TrsEmployeeEducation> getAllTrsEmployeeEducation();
	public List<TrsEmployeeEducation> getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(Map<String, Object> requestMap);
	public List<TrsEmployeeEducation> getTrsEmployeeEducationPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeEducations();
}