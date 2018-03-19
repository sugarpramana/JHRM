package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstEmployementStatusDAO;
import org.module.hr.dao.MstJobCategoryDAO;
import org.module.hr.dao.MstJobtitleDAO;
import org.module.hr.dao.MstPaygradeDAO;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstPaygrade;
import org.module.hr.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private MstJobtitleDAO mstJobtitleDAO;
	
	@Autowired
	private MstPaygradeDAO mstPaygradeDAO;
	
	@Autowired
	private MstEmployementStatusDAO mstEmployementStatusDAO;
	
	@Autowired
	private MstJobCategoryDAO mstJobCategoryDAO;
	
	@Override
	public void save(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.save(mstJobtitle);
	}
	
	@Override
	public void update(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.update(mstJobtitle);
	}
	
	@Override
	public void saveOrUpdate(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.saveOrUpdate(mstJobtitle);
	}
	
	@Override
	public void delete(MstJobtitle mstJobtitle) {
		mstJobtitleDAO.delete(mstJobtitle);
	}
	@Override
	public List<MstJobtitle> getAllMstJobtitles() {
		return mstJobtitleDAO.getAllMstJobtitles();
	}
	
	@Override
	public List<MstJobtitle> getByMstJobtitleRequestMap(HashMap<String, Object> hashMap) {
		return mstJobtitleDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public List<MstJobtitle> getMstJobtitlePaging(HashMap<String, Object> hashMap) {
		return mstJobtitleDAO.getMstJobtitlePaging(hashMap);
	}
	
	@Override
	public int getCountMstJobtitles() {
		return mstJobtitleDAO.getCountMstJobtitles();
	}
	
	@Override
	public void save(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.save(mstPaygrade);
	}
	
	@Override
	public void update(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.update(mstPaygrade);
	}
	
	@Override
	public void saveOrUpdate(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.saveOrUpdate(mstPaygrade);
	}
	
	@Override
	public void delete(MstPaygrade mstPaygrade) {
		mstPaygradeDAO.delete(mstPaygrade);
	}
	
	@Override
	public List<MstPaygrade> getAllMstPaygrades() {
		return mstPaygradeDAO.getAllMstPaygrades();
	}
	
	@Override
	public List<MstPaygrade> getByMstPaygradeRequestMap(HashMap<String, Object> hashMap) {
		return mstPaygradeDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstPaygrade> getMstPaygradePaging(HashMap<String, Object> hashMap) {
		return mstPaygradeDAO.getMstPaygradePaging(hashMap);
	}

	@Override
	public int getCountMstPaygrades() {
		return mstPaygradeDAO.getCountMstPaygrades();
	}
	
	@Override
	public void save(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.save(mstEmployementStatus);
	}
	
	@Override
	public void update(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.update(mstEmployementStatus);
	}
	
	@Override
	public void saveOrUpdate(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.saveOrUpdate(mstEmployementStatus);
	}
	
	@Override
	public void delete(MstEmployementStatus mstEmployementStatus) {
		mstEmployementStatusDAO.delete(mstEmployementStatus);
	}
	
	@Override
	public List<MstEmployementStatus> getAllMstEmployementStatus() {
		return mstEmployementStatusDAO.getAllMstEmployementStatus();
	}
	
	@Override
	public List<MstEmployementStatus> getByMstEmployementStatusRequestMap(HashMap<String, Object> hashMap) {
		return mstEmployementStatusDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public List<MstEmployementStatus> getMstEmployementStatusPaging(HashMap<String, Object> hashMap) {
		return mstEmployementStatusDAO.getMstEmployementStatusPaging(hashMap);
	}
	
	@Override
	public int getCountAllMstEmployementStatus() {
		return mstEmployementStatusDAO.getCountAllMstEmployementStatus();
	}
	
	@Override
	public void save(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.save(mstJobCategory);
	}
	
	@Override
	public void update(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.update(mstJobCategory);
	}
	
	@Override
	public void saveOrUpdate(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.saveOrUpdate(mstJobCategory);
	}
	
	@Override
	public void delete(MstJobCategory mstJobCategory) {
		mstJobCategoryDAO.delete(mstJobCategory);
	}
	
	@Override
	public List<MstJobCategory> getAllMstJobCategories() {
		return mstJobCategoryDAO.getAllMstJobCategories();
	}
	
	@Override
	public List<MstJobCategory> getByMstJobCategoryRequestMap(HashMap<String, Object> hashMap) {
		return mstJobCategoryDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public List<MstJobCategory> getMstJobCategoryPaging(HashMap<String, Object> hashMap) {
		return mstJobCategoryDAO.getMstJobCategoryPaging(hashMap);
	}
	
	@Override
	public int getCountAllMstJobCategory() {
		return mstJobCategoryDAO.getCountAllMstJobCategory();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstJobtitleDAO getMstJobtitleDAO() {
		return mstJobtitleDAO;
	}

	public void setMstJobtitleDAO(MstJobtitleDAO mstJobtitleDAO) {
		this.mstJobtitleDAO = mstJobtitleDAO;
	}

	public MstPaygradeDAO getMstPaygradeDAO() {
		return mstPaygradeDAO;
	}

	public void setMstPaygradeDAO(MstPaygradeDAO mstPaygradeDAO) {
		this.mstPaygradeDAO = mstPaygradeDAO;
	}

	public MstEmployementStatusDAO getMstEmployementStatusDAO() {
		return mstEmployementStatusDAO;
	}

	public void setMstEmployementStatusDAO(MstEmployementStatusDAO mstEmployementStatusDAO) {
		this.mstEmployementStatusDAO = mstEmployementStatusDAO;
	}

	public MstJobCategoryDAO getMstJobCategoryDAO() {
		return mstJobCategoryDAO;
	}

	public void setMstJobCategoryDAO(MstJobCategoryDAO mstJobCategoryDAO) {
		this.mstJobCategoryDAO = mstJobCategoryDAO;
	}
}