package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstLicense;

/**
*
* @author formulateko@admin.com
*/
public interface MstLicenseDAO {
	public void save(MstLicense mstLicense);
    public void update(MstLicense mstLicense);
    public void saveOrUpdate(MstLicense mstLicense);
    public void delete(MstLicense mstLicense);
    public List<MstLicense> getAllMstLicense();
    public List<MstLicense> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstLicense> getMstLicensePaging(HashMap<String, Object> hashMap);
    public int getCountMstLicenses();
}