package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeExprience;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeExprienceDAO {
	public void save(TrsEmployeeExprience trsEmployeeExprience);
	public void update(TrsEmployeeExprience trsEmployeeExprience);
	public void saveOrUpdate(TrsEmployeeExprience trsEmployeeExprience);
	public void delete(TrsEmployeeExprience trsEmployeeExprience);
	public List<TrsEmployeeExprience> getAllTrsEmployeeExprience();
	public List<TrsEmployeeExprience> getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(Map<String, Object> requestMap);
	public List<TrsEmployeeExprience> getTrsEmployeeExpriencePaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeExpriences();
}