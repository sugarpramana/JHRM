package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeMembership;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEmployeeMembershipDAO {
	public void save(TrsEmployeeMembership trsEmployeeMembership);
	public void update(TrsEmployeeMembership trsEmployeeMembership);
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership);
	public void delete(TrsEmployeeMembership trsEmployeeMembership);
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership();
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap (Map<String, Object> requestMap);
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployeeMemberships();
}