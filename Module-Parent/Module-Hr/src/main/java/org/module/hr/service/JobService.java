package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstPaygrade;

/**
*
* @author formulateko@admin.com
*/
public interface JobService {
	/*- Job Title +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstJobtitle mstJobtitle);
    public void update(MstJobtitle mstJobtitle);
    public void saveOrUpdate(MstJobtitle mstJobtitle);
    public void delete(MstJobtitle mstJobtitle);
    public List<MstJobtitle> getAllMstJobtitles();
    public List<MstJobtitle> getByMstJobtitleRequestMap(HashMap<String, Object> hashMap);
    public List<MstJobtitle> getMstJobtitlePaging(HashMap<String, Object> hashMap);
    public int getCountMstJobtitles();
    
    /*- Pay Grade +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstPaygrade mstPaygrade);
    public void update(MstPaygrade mstPaygrade);
    public void saveOrUpdate(MstPaygrade mstPaygrade);
    public void delete(MstPaygrade mstPaygrade);
    public List<MstPaygrade> getAllMstPaygrades();
    public List<MstPaygrade> getByMstPaygradeRequestMap(HashMap<String, Object> hashMap);
    public List<MstPaygrade> getMstPaygradePaging(HashMap<String, Object> hashMap);
    public int getCountMstPaygrades();
    
    /*- Employment Status +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstEmployementStatus mstEmployementStatus);
    public void update(MstEmployementStatus mstEmployementStatus);
    public void saveOrUpdate(MstEmployementStatus mstEmployementStatus);
    public void delete(MstEmployementStatus mstEmployementStatus);
    public List<MstEmployementStatus> getAllMstEmployementStatus();
    public List<MstEmployementStatus> getByMstEmployementStatusRequestMap(HashMap<String, Object> requestMap);
    public List<MstEmployementStatus> getMstEmployementStatusPaging(HashMap<String, Object> requestMap);
    public int getCountAllMstEmployementStatus();
    
    /*- Job Category +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstJobCategory mstJobCategory);
    public void update(MstJobCategory mstJobCategory);
    public void saveOrUpdate(MstJobCategory mstJobCategory);
    public void delete(MstJobCategory mstJobCategory);
    public List<MstJobCategory> getAllMstJobCategories();
    public List<MstJobCategory> getByMstJobCategoryRequestMap(HashMap<String, Object> requestMap);
    public List<MstJobCategory> getMstJobCategoryPaging(HashMap<String, Object> requestMap);
    public int getCountAllMstJobCategory();
}