package org.module.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeDependent;
import org.module.hr.model.TrsEmployeeEducation;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.model.TrsEmployeeExprience;
import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.model.TrsEmployeeLanguage;
import org.module.hr.model.TrsEmployeeLicense;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.model.TrsEmployeeSalary;
import org.module.hr.model.TrsEmployeeSkill;
import org.module.hr.model.dto.MaritalStatusType;
import org.module.hr.model.dto.RelationshipType;

/**
*
* @author formulateko@admin.com
*/
public interface EmployeeService {
	/*- Employee Detail +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployee trsEmployee);
	public void update(TrsEmployee trsEmployee);
	public void saveOrUpdate(TrsEmployee trsEmployee);
	public void delete(TrsEmployee trsEmployee);
	public List<TrsEmployee> getAllTrsEmployees();
	public List<TrsEmployee> getByTrsEmployeeRequestMap(HashMap<String, Object> hashMap);
	public List<TrsEmployee> getMstTrsEmployeePaging(HashMap<String, Object> hashMap);
    public int getCountTrsEmployees();
	
	/*- Employee Emergency Contact +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Dependent +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeDependent trsEmployeeDependent);
	public void update(TrsEmployeeDependent trsEmployeeDependent);
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent);
	public void delete(TrsEmployeeDependent trsEmployeeDependent);
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent();
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Immigration +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeImmigration trsEmployeeImmigration);
	public void update(TrsEmployeeImmigration trsEmployeeImmigration);
	public void saveOrUpdate(TrsEmployeeImmigration trsEmployeeImmigration);
	public void delete(TrsEmployeeImmigration trsEmployeeImmigration);
	public List<TrsEmployeeImmigration> getAllTrsEmployeeImmigration();
	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Membership +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeMembership trsEmployeeMembership);
	public void update(TrsEmployeeMembership trsEmployeeMembership);
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership);
	public void delete(TrsEmployeeMembership trsEmployeeMembership);
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership();
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Exprience +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeExprience trsEmployeeExprience);
	public void update(TrsEmployeeExprience trsEmployeeExprience);
	public void saveOrUpdate(TrsEmployeeExprience trsEmployeeExprience);
	public void delete(TrsEmployeeExprience trsEmployeeExprience);
	public List<TrsEmployeeExprience> getAllTrsEmployeeExprience();
	public List<TrsEmployeeExprience> getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Education +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeEducation trsEmployeeEducation);
	public void update(TrsEmployeeEducation trsEmployeeEducation);
	public void saveOrUpdate(TrsEmployeeEducation trsEmployeeEducation);
	public void delete(TrsEmployeeEducation trsEmployeeEducation);
	public List<TrsEmployeeEducation> getAllTrsEmployeeEducation();
	public List<TrsEmployeeEducation> getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Language +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeLanguage trsEmployeeLanguage);
	public void update(TrsEmployeeLanguage trsEmployeeLanguage);
	public void saveOrUpdate(TrsEmployeeLanguage trsEmployeeLanguage);
	public void delete(TrsEmployeeLanguage trsEmployeeLanguage);
	public List<TrsEmployeeLanguage> getAllTrsEmployeeLanguage();
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Skill +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeSkill trsEmployeeSkill);
	public void update(TrsEmployeeSkill trsEmployeeSkill);
	public void saveOrUpdate(TrsEmployeeSkill trsEmployeeSkill);
	public void delete(TrsEmployeeSkill trsEmployeeSkill);
	public List<TrsEmployeeSkill> getAllTrsEmployeeSkill();
	public List<TrsEmployeeSkill> getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(Map<String, Object> requestMap);
	
	/*- Employee Salary +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeSalary trsEmployeeSkill);
	public void update(TrsEmployeeSalary trsEmployeeSkill);
	public void saveOrUpdate(TrsEmployeeSalary trsEmployeeSkill);
	public void delete(TrsEmployeeSalary trsEmployeeSkill);
	public List<TrsEmployeeSalary> getAllTrsEmployeeSalary();
	public List<TrsEmployeeSalary> getTrsEmployeeSalaryByTrsEmployeeSalaryRequestMap(Map<String, Object> requestMap);
	
	/*- Employee License +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(TrsEmployeeLicense trsEmployeeLicense);
	public void update(TrsEmployeeLicense trsEmployeeLicense);
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense);
	public void delete(TrsEmployeeLicense trsEmployeeLicense);
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense();
	public List<TrsEmployeeLicense> getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(Map<String, Object> requestMap);
	
	/*- Relation Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public List<RelationshipType> getAllRelationshipType();
	public RelationshipType getRelationshipTypeById(Character id);

	/*- Marital Status Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public List<MaritalStatusType> getAllMaritalStatusType();
	public MaritalStatusType getMaritalStatusTypeTypeById(Character id);
}