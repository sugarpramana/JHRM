package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeLicense;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeLicenseDAO {
	public void save(TrsEmployeeLicense trsEmployeeLicense);
	public void update(TrsEmployeeLicense trsEmployeeLicense);
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense);
	public void delete(TrsEmployeeLicense TrsEmployeeLicense);
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense();
	public List<TrsEmployeeLicense> getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(Map<String, Object> requestMap);
	public List<TrsEmployeeLicense> getTrsEmployeeLicensePaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeLicenses();
}