package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsEmployeeEmergencyContact;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeEmergencyContactDAO {
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();
	public List<TrsEmployeeEmergencyContact> getByRequestMap(HashMap<String, Object> hashMap);
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeEmergencyContacts(HashMap<String, Object> hashMap);
}