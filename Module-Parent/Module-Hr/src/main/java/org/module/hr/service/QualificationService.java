package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstEducation;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstMembership;
import org.module.hr.model.MstSkill;

/**
*
* @author formulateko@admin.com
*/
public interface QualificationService {
	/*- Skill +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstSkill mstSkill);
    public void update(MstSkill mstSkill);
    public void saveOrUpdate(MstSkill mstSkill);
    public void delete(MstSkill mstSkill);
    public List<MstSkill> getAllMstSkill();
    public MstSkill getMstSkillById(Integer id);
    public List<MstSkill> getByMstSkillRequestMap(HashMap<String, Object> hashMap);
    public List<MstSkill> getMstSkillPaging(HashMap<String, Object> hashMap);
    public int getCountMstSkills();
    
    /*- Language +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstLanguage mstLanguage);
    public void update(MstLanguage mstLanguage);
    public void saveOrUpdate(MstLanguage mstLanguage);
    public void delete(MstLanguage mstLanguage);
    public List<MstLanguage> getAllMstLanguage();
    public List<MstLanguage> getByMstLanguageRequestMap(HashMap<String, Object> hashMap);
    public List<MstLanguage> getMstLanguagePaging(HashMap<String, Object> hashMap);
    public int getCountMstLanguages();
    
    /*- Education +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstEducation mstEducation);
    public void update(MstEducation mstEducation);
    public void saveOrUpdate(MstEducation mstEducation);
    public void delete(MstEducation mstEducation);
    public List<MstEducation> getAllMstEducation();
    public List<MstEducation> getByMstEducationRequestMap(HashMap<String, Object> hashMap);
    public List<MstEducation> getMstEducationPaging(HashMap<String, Object> hashMap);
    public int getCountMstEducations();
    
    /*- License +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstLicense mstLicense);
    public void update(MstLicense mstLicense);
    public void saveOrUpdate(MstLicense mstLicense);
    public void delete(MstLicense mstLicense);
    public List<MstLicense> getAllMstLicense();
    public List<MstLicense> getByMstLicenseRequestMap(HashMap<String, Object> hashMap);
    public List<MstLicense> getMstLicensePaging(HashMap<String, Object> hashMap);
    public int getCountMstLicenses();
    
    /*- Membership +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void save(MstMembership mstMembership);
    public void update(MstMembership mstMembership);
    public void saveOrUpdate(MstMembership mstMembership);
    public void delete(MstMembership mstMembership);
    public List<MstMembership> getAllMstMembership();
    public List<MstMembership> getByMstMembershipRequestMap(HashMap<String, Object> hashMap);
    public List<MstMembership> getMstMembershipPaging(HashMap<String, Object> hashMap);
    public int getCountMstMemberships();
}