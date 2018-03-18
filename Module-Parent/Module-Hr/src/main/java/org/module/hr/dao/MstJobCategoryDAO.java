package org.module.hr.dao;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstJobCategory;

/**
*
* @author formulateko@admin.com
*/
public interface MstJobCategoryDAO {
	public void save(MstJobCategory mstJobCategory);
    public void update(MstJobCategory mstJobCategory);
    public void saveOrUpdate(MstJobCategory mstJobCategory);
    public void delete(MstJobCategory mstJobCategory);
    public List<MstJobCategory> getAllMstJobCategories();
    public List<MstJobCategory> getByRequestMap(HashMap<String, Object> hashMap);
    public List<MstJobCategory> getMstJobCategoryPaging(HashMap<String, Object> hashMap);
    public int getCountAllMstJobCategory();
}