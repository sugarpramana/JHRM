package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstGeneralInformation;

/**
*
* @author formulateko@admin.com
*/
public interface MstGeneralInformationDAO {
	public void save(MstGeneralInformation mstGeneralInformation);
    public void update(MstGeneralInformation mstGeneralInformation);
    public void saveOrUpdate(MstGeneralInformation mstGeneralInformation);
    public void delete(MstGeneralInformation mstGeneralInformation);
    public List<MstGeneralInformation> getAllMstGeneralInformations();
    public List<MstGeneralInformation> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstGeneralInformation> getMstGeneralInformationPaging(HashMap<String, Object> hashMap);
    public int getCountMstGeneralInformations();
}