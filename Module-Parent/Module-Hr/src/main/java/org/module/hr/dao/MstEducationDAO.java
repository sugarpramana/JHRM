package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstEducation;

/**
*
* @author formulateko@admin.com
*/
public interface MstEducationDAO {
	public void save(MstEducation mstEducation);
    public void update(MstEducation mstEducation);
    public void saveOrUpdate(MstEducation mstEducation);
    public void delete(MstEducation mstEducation);
    public List<MstEducation> getAllMstEducation();
    public List<MstEducation> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstEducation> getMstEducationPaging(HashMap<String, Object> hashMap);
    public int getCountMstEducations();
}