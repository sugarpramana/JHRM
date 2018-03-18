package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsEntitlement;

/**
*
* @author formulateko@admin.com
*/
public interface TrsEntitlementDAO {
	public void save(TrsEntitlement trsEntitlement);
    public void update(TrsEntitlement trsEntitlement);
    public void saveOrUpdate(TrsEntitlement trsEntitlement);
    public void delete(TrsEntitlement trsEntitlement);
    public List<TrsEntitlement> getAllTrsEntitlements();
    public List<TrsEntitlement> getByRequestMap(HashMap<String, Object> hashMap);
    public List<TrsEntitlement> getTrsEntitlementPaging(HashMap<String, Object> hashMap);
    public int getCountTrsEntitlements();
}