package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstGeneralInformation;
import org.module.hr.model.MstLocation;
import org.module.hr.model.MstSubUnit;

public interface OrganizationService {
	/*- General Information +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstGeneralInformation mstGeneralInformation);
    public void update(MstGeneralInformation mstGeneralInformation);
    public void saveOrUpdate(MstGeneralInformation mstGeneralInformation);
    public void delete(MstGeneralInformation mstGeneralInformation);
    public List<MstGeneralInformation> getAllMstGeneralInformations();
    public List<MstGeneralInformation> getByMstGeneralInformation(HashMap<String, Object> hashMap);
    public List<MstGeneralInformation> getMstGeneralInformationPaging(HashMap<String, Object> hashMap);
    public int getCountMstGeneralInformations();
    
	/*- Location +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstLocation mstLocation);
    public void update(MstLocation mstLocation);
    public void saveOrUpdate(MstLocation mstLocation);
    public void delete(MstLocation mstLocation);
    public List<MstLocation> getAllMstLocation();
    public List<MstLocation> getByMstLocationRequestMap(HashMap<String, Object> hashMap);
    public List<MstLocation> getMstLocationPaging(HashMap<String, Object> hashMap);
    public int getCountMstLocations();
    
    /*- Structure +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstSubUnit mstSubUnit);
    public void update(MstSubUnit mstSubUnit);
    public void saveOrUpdate(MstSubUnit mstSubUnit);
    public void delete(MstSubUnit mstSubUnit);
    public List<MstSubUnit> getAllMstSubUnitts();
    public List<MstSubUnit> getByMstSubUnitRequestMap(HashMap<String, Object> hashMap);
    public List<MstSubUnit> getMstSubUnitPaging(HashMap<String, Object> hashMap);
    public int getCountMstSubUnits();
}
