package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.module.hr.dao.MstEducationDAO;
import org.module.hr.dao.MstLanguageDAO;
import org.module.hr.dao.MstLicenseDAO;
import org.module.hr.dao.MstMembershipDAO;
import org.module.hr.dao.MstSkillDAO;
import org.module.hr.model.MstEducation;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstMembership;
import org.module.hr.model.MstSkill;
import org.module.hr.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	private MstSkillDAO mstSkillDAO; 
	
	@Autowired
	private MstLanguageDAO mstLanguageDAO;
	
	@Autowired
	private MstEducationDAO mstEducationDAO;
	
	@Autowired
	private MstLicenseDAO mstLicenseDAO;
	
	@Autowired
	private MstMembershipDAO mstMembershipDAO;

	/*- Skill +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstSkill mstSkill) {
		mstSkillDAO.save(mstSkill);
	}

	@Override
	public void update(MstSkill mstSkill) {
		mstSkillDAO.update(mstSkill);
	}

	@Override
	public void saveOrUpdate(MstSkill mstSkill) {
		mstSkillDAO.saveOrUpdate(mstSkill);
	}

	@Override
	public void delete(MstSkill mstSkill) {
		mstSkillDAO.delete(mstSkill);
	}

	@Override
	public List<MstSkill> getAllMstSkill() {
		List<MstSkill> list = mstSkillDAO.getAllMstSkill();
		return list;
	}

	@Override
	public MstSkill getMstSkillById(Integer id) {
		return mstSkillDAO.getMstSkillById(id);
	}
	
	@Override
	public List<MstSkill> getByMstSkillRequestMap(HashMap<String, Object> hashMap) {
		return mstSkillDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstSkill> getMstSkillPaging(HashMap<String, Object> hashMap) {
		return mstSkillDAO.getMstSkillPaging(hashMap);
	}

	@Override
	public int getCountMstSkills() {
		return mstSkillDAO.getCountMstSkills();
	}

	/*-Language +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstLanguage mstLanguage) {
		mstLanguageDAO.save(mstLanguage);
	}

	@Override
	public void update(MstLanguage mstLanguage) {
		mstLanguageDAO.update(mstLanguage);
	}

	@Override
	public void saveOrUpdate(MstLanguage mstLanguage) {
		mstLanguageDAO.saveOrUpdate(mstLanguage);
	}

	@Override
	public void delete(MstLanguage mstLanguage) {
		mstLanguageDAO.delete(mstLanguage);
	}

	@Override
	public List<MstLanguage> getAllMstLanguage() {
		return mstLanguageDAO.getAllMstLanguage();
	}
	
	@Override
	public List<MstLanguage> getByMstLanguageRequestMap(HashMap<String, Object> hashMap) {
		return mstLanguageDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstLanguage> getMstLanguagePaging(HashMap<String, Object> hashMap) {
		return mstLanguageDAO.getMstLanguagePaging(hashMap);
	}

	@Override
	public int getCountMstLanguages() {
		return mstLanguageDAO.getCountMstLanguages();
	}

	/*- Education +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstEducation mstEducation) {
		mstEducationDAO.save(mstEducation);
	}

	@Override
	public void update(MstEducation mstEducation) {
		mstEducationDAO.update(mstEducation);
	}

	@Override
	public void saveOrUpdate(MstEducation mstEducation) {
		mstEducationDAO.saveOrUpdate(mstEducation);
	}

	@Override
	public void delete(MstEducation mstEducation) {
		mstEducationDAO.delete(mstEducation);
	}

	@Override
	public List<MstEducation> getAllMstEducation() {
		return mstEducationDAO.getAllMstEducation();
	}
	
	@Override
	public List<MstEducation> getByMstEducationRequestMap(HashMap<String, Object> hashMap) {
		return mstEducationDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstEducation> getMstEducationPaging(HashMap<String, Object> hashMap) {
		return mstEducationDAO.getMstEducationPaging(hashMap);
	}

	@Override
	public int getCountMstEducations() {
		return mstEducationDAO.getCountMstEducations();
	}

	/*- License +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstLicense mstLicense) {
		mstLicenseDAO.save(mstLicense);
	}

	@Override
	public void update(MstLicense mstLicense) {
		mstLicenseDAO.update(mstLicense);
	}

	@Override
	public void saveOrUpdate(MstLicense mstLicense) {
		mstLicenseDAO.saveOrUpdate(mstLicense);
	}

	@Override
	public void delete(MstLicense mstLicense) {
		mstLicenseDAO.delete(mstLicense);
	}

	@Override
	public List<MstLicense> getAllMstLicense() {
		return mstLicenseDAO.getAllMstLicense();
	}
	
	@Override
	public List<MstLicense> getByMstLicenseRequestMap(HashMap<String, Object> hashMap) {
		return mstLicenseDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstLicense> getMstLicensePaging(HashMap<String, Object> hashMap) {
		return mstLicenseDAO.getMstLicensePaging(hashMap);
	}

	@Override
	public int getCountMstLicenses() {
		return mstLicenseDAO.getCountMstLicenses();
	}

	/*- Membership +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(MstMembership mstMembership) {
		mstMembershipDAO.save(mstMembership);
	}

	@Override
	public void update(MstMembership mstMembership) {
		mstMembershipDAO.update(mstMembership);
	}

	@Override
	public void saveOrUpdate(MstMembership mstMembership) {
		mstMembershipDAO.saveOrUpdate(mstMembership);
	}

	@Override
	public void delete(MstMembership mstMembership) {
		mstMembershipDAO.delete(mstMembership);
	}

	@Override
	public List<MstMembership> getAllMstMembership() {
		return mstMembershipDAO.getAllMstMembership();
	}
	
	@Override
	public List<MstMembership> getByMstMembershipRequestMap(HashMap<String, Object> hashMap) {
		return mstMembershipDAO.getByRequestMap(hashMap);
	}

	@Override
	public List<MstMembership> getMstMembershipPaging(HashMap<String, Object> hashMap) {
		return mstMembershipDAO.getMstMembershipPaging(hashMap);
	}

	@Override
	public int getCountMstMemberships() {
		return mstMembershipDAO.getCountMstMemberships();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstSkillDAO getMstSkillDAO() {
		return mstSkillDAO;
	}

	public void setMstSkillDAO(MstSkillDAO mstSkillDAO) {
		this.mstSkillDAO = mstSkillDAO;
	}

	public MstLanguageDAO getMstLanguageDAO() {
		return mstLanguageDAO;
	}

	public void setMstLanguageDAO(MstLanguageDAO mstLanguageDAO) {
		this.mstLanguageDAO = mstLanguageDAO;
	}

	public MstEducationDAO getMstEducationDAO() {
		return mstEducationDAO;
	}

	public void setMstEducationDAO(MstEducationDAO mstEducationDAO) {
		this.mstEducationDAO = mstEducationDAO;
	}

	public MstLicenseDAO getMstLicenseDAO() {
		return mstLicenseDAO;
	}

	public void setMstLicenseDAO(MstLicenseDAO mstLicenseDAO) {
		this.mstLicenseDAO = mstLicenseDAO;
	}

	public MstMembershipDAO getMstMembershipDAO() {
		return mstMembershipDAO;
	}

	public void setMstMembershipDAO(MstMembershipDAO mstMembershipDAO) {
		this.mstMembershipDAO = mstMembershipDAO;
	}	
}