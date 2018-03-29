package org.module.hr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.dao.TrsEmployeeDependentDAO;
import org.module.hr.dao.TrsEmployeeEducationDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.dao.TrsEmployeeExprienceDAO;
import org.module.hr.dao.TrsEmployeeImmigrationDAO;
import org.module.hr.dao.TrsEmployeeLanguageDAO;
import org.module.hr.dao.TrsEmployeeLicenseDAO;
import org.module.hr.dao.TrsEmployeeMembershipDAO;
import org.module.hr.dao.TrsEmployeeSalaryDAO;
import org.module.hr.dao.TrsEmployeeSkillDAO;
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
import org.module.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author formulateko@admin.com
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private TrsEmployeeDAO trsEmployeeDAO;
	
	@Autowired
	private TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO;
	
	@Autowired
	private TrsEmployeeLicenseDAO trsEmployeeLicenseDAO ;
	
	@Autowired
	private TrsEmployeeDependentDAO trsEmployeeDependentDAO;
	
	@Autowired
	private TrsEmployeeMembershipDAO trsEmployeeMembershipDAO;
	
	@Autowired
	private TrsEmployeeImmigrationDAO trsEmployeeImmigrationDAO;
	
	@Autowired
	private TrsEmployeeExprienceDAO trsEmployeeExprienceDAO;
	
	@Autowired
	private TrsEmployeeEducationDAO trsEmployeeEducationDAO;
	
	@Autowired
	private TrsEmployeeLanguageDAO trsEmployeeLanguageDAO;
	
	@Autowired
	private TrsEmployeeSkillDAO trsEmployeeSkillDAO;
	
	@Autowired
	private TrsEmployeeSalaryDAO trsEmployeeSalaryDAO;
	
	/*- Employee Detail +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployee trsEmployee) {
		trsEmployeeDAO.save(trsEmployee);
	}
	
	@Override
	public void update(TrsEmployee trsEmployee) {
		trsEmployeeDAO.update(trsEmployee);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployee trsEmployee) {
		trsEmployeeDAO.saveOrUpdate(trsEmployee);
	}
	
	@Override
	public void delete(TrsEmployee trsEmployee) {
		trsEmployeeDAO.delete(trsEmployee);
	}

	@Override
	public List<TrsEmployee> getAllTrsEmployees() {
		return trsEmployeeDAO.getAllTrsEmployees();
	}

	@Override
	public List<TrsEmployee> getByTrsEmployeeRequestMap(HashMap<String, Object> hashMap) {
		return trsEmployeeDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public List<TrsEmployee> getMstTrsEmployeePaging(HashMap<String, Object> hashMap) {
		return trsEmployeeDAO.getMstTrsEmployeePaging(hashMap);
	}

	@Override
	public int getCountTrsEmployees() {
		return trsEmployeeDAO.getCountTrsEmployees();
	}
	
	/*- Employee Emergency Contant +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.save(trsEmployeeEmergencyContact);
	}

	@Override
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.update(trsEmployeeEmergencyContact);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.saveOrUpdate(trsEmployeeEmergencyContact);
	}

	@Override
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.delete(trsEmployeeEmergencyContact);
	}

	@Override
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact() {
		return trsEmployeeEmergencyContactDAO.getAllTrsEmployeeEmergencyContact();
	}
	
	@Override
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(HashMap<String, Object> hashMap){
		//return trsEmployeeEmergencyContactDAO.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(requestMap);
		return trsEmployeeEmergencyContactDAO.getByRequestMap(hashMap);
	}
	
	@Override
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactPaging(HashMap<String, Object> hashMap) {
		return trsEmployeeEmergencyContactDAO.getTrsEmployeeEmergencyContactPaging(hashMap);
	}

	@Override
	public int getCountTrsEmployeeEmergencyContacts(HashMap<String, Object> hashMap) {
		return trsEmployeeEmergencyContactDAO.getCountTrsEmployeeEmergencyContacts(hashMap);
	}
	
	/*- Employee Dependent +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.save(trsEmployeeDependent);
	}

	@Override
	public void update(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.update(trsEmployeeDependent);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.saveOrUpdate(trsEmployeeDependent);
	}

	@Override
	public void delete(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.delete(trsEmployeeDependent);
	}

	@Override
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent() {
		return trsEmployeeDependentDAO.getAllTrsEmployeeDependent();
	}
	
	@Override
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap){
		return trsEmployeeDependentDAO.getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(requestMap);
	}
	
	/*- Employee Immigration +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeImmigration trsEmployeeImmigration) {
		trsEmployeeImmigrationDAO.save(trsEmployeeImmigration);
	}

	@Override
	public void update(TrsEmployeeImmigration trsEmployeeImmigration) {
		trsEmployeeImmigrationDAO.update(trsEmployeeImmigration);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeImmigration trsEmployeeImmigration) {
		trsEmployeeImmigrationDAO.saveOrUpdate(trsEmployeeImmigration);
	}

	@Override
	public void delete(TrsEmployeeImmigration trsEmployeeImmigration) {
		trsEmployeeImmigrationDAO.delete(trsEmployeeImmigration);
	}

	@Override
	public List<TrsEmployeeImmigration> getAllTrsEmployeeImmigration() {
		return trsEmployeeImmigrationDAO.getAllTrsEmployeeImmigration();
	}
	
	@Override
	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(Map<String, Object> requestMap){
		return trsEmployeeImmigrationDAO.getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(requestMap);
	}
	
	/*- Employee Membership +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.save(trsEmployeeMembership);
	}

	@Override
	public void update(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.update(trsEmployeeMembership);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.saveOrUpdate(trsEmployeeMembership);
	}

	@Override
	public void delete(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.delete(trsEmployeeMembership);
	}	

	@Override
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership() {
		return trsEmployeeMembershipDAO.getAllTrsEmployeeMembership();
	}
	
	@Override
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(Map<String, Object> requestMap){
		return trsEmployeeMembershipDAO.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
	}
	
	/*- Employee Exprience +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeExprience trsEmployeeExprience) {
		trsEmployeeExprienceDAO.save(trsEmployeeExprience);
	}

	@Override
	public void update(TrsEmployeeExprience trsEmployeeExprience) {
		trsEmployeeExprienceDAO.update(trsEmployeeExprience);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeExprience trsEmployeeExprience) {
		trsEmployeeExprienceDAO.saveOrUpdate(trsEmployeeExprience);
	}

	@Override
	public void delete(TrsEmployeeExprience trsEmployeeExprience) {
		trsEmployeeExprienceDAO.delete(trsEmployeeExprience);
	}	

	@Override
	public List<TrsEmployeeExprience> getAllTrsEmployeeExprience() {
		return trsEmployeeExprienceDAO.getAllTrsEmployeeExprience();
	}
	
	@Override
	public List<TrsEmployeeExprience> getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(Map<String, Object> requestMap){
		return trsEmployeeExprienceDAO.getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(requestMap);
	}
	
	/*- Employee Education +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeEducation trsEmployeeEducation) {
		trsEmployeeEducationDAO.save(trsEmployeeEducation);
	}

	@Override
	public void update(TrsEmployeeEducation trsEmployeeEducation) {
		trsEmployeeEducationDAO.update(trsEmployeeEducation);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeEducation trsEmployeeEducation) {
		trsEmployeeEducationDAO.saveOrUpdate(trsEmployeeEducation);
	}

	@Override
	public void delete(TrsEmployeeEducation trsEmployeeEducation) {
		trsEmployeeEducationDAO.delete(trsEmployeeEducation);
	}	

	@Override
	public List<TrsEmployeeEducation> getAllTrsEmployeeEducation() {
		return trsEmployeeEducationDAO.getAllTrsEmployeeEducation();
	}
	
	@Override
	public List<TrsEmployeeEducation> getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(Map<String, Object> requestMap){
		return trsEmployeeEducationDAO.getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(requestMap);
	}
	
	/*- Employee Language +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeLanguage trsEmployeeLanguage) {
		trsEmployeeLanguageDAO.save(trsEmployeeLanguage);
	}

	@Override
	public void update(TrsEmployeeLanguage trsEmployeeLanguage) {
		trsEmployeeLanguageDAO.update(trsEmployeeLanguage);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeLanguage trsEmployeeLanguage) {
		trsEmployeeLanguageDAO.saveOrUpdate(trsEmployeeLanguage);
	}

	@Override
	public void delete(TrsEmployeeLanguage trsEmployeeLanguage) {
		trsEmployeeLanguageDAO.delete(trsEmployeeLanguage);
	}	

	@Override
	public List<TrsEmployeeLanguage> getAllTrsEmployeeLanguage() {
		return trsEmployeeLanguageDAO.getAllTrsEmployeeLanguage();
	}
	
	@Override
	public List<TrsEmployeeLanguage> getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(Map<String, Object> requestMap){
		return trsEmployeeLanguageDAO.getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(requestMap);
	}
	
	/*- Employee Skill +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeSkill trsEmployeeSkill){
		trsEmployeeSkillDAO.save(trsEmployeeSkill);
	}
	
	@Override
	public void update(TrsEmployeeSkill trsEmployeeSkill){
		trsEmployeeSkillDAO.update(trsEmployeeSkill);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployeeSkill trsEmployeeSkill){
		trsEmployeeSkillDAO.saveOrUpdate(trsEmployeeSkill);
	}
	
	@Override
	public void delete(TrsEmployeeSkill trsEmployeeSkill){
		trsEmployeeSkillDAO.delete(trsEmployeeSkill);
	}
	
	@Override
	public List<TrsEmployeeSkill> getAllTrsEmployeeSkill(){
		return trsEmployeeSkillDAO.getAllTrsEmployeeSkill();
	}
	
	@Override
	public List<TrsEmployeeSkill> getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(Map<String, Object> requestMap){
		return trsEmployeeSkillDAO.getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(requestMap);
	}
	
	/*- Employee Salary +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeSalary trsEmployeeSalary){
		trsEmployeeSalaryDAO.save(trsEmployeeSalary);
	}
	
	@Override
	public void update(TrsEmployeeSalary trsEmployeeSalary){
		trsEmployeeSalaryDAO.update(trsEmployeeSalary);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployeeSalary trsEmployeeSalary){
		trsEmployeeSalaryDAO.saveOrUpdate(trsEmployeeSalary);
	}
	
	@Override
	public void delete(TrsEmployeeSalary trsEmployeeSalary){
		trsEmployeeSalaryDAO.delete(trsEmployeeSalary);
	}
	
	@Override
	public List<TrsEmployeeSalary> getAllTrsEmployeeSalary(){
		return trsEmployeeSalaryDAO.getAllTrsEmployeeSalary();
	}
	
	@Override
	public List<TrsEmployeeSalary> getTrsEmployeeSalaryByTrsEmployeeSalaryRequestMap(Map<String, Object> requestMap){
		return trsEmployeeSalaryDAO.getTrsEmployeeSalaryByTrsEmployeeSalaryRequestMap(requestMap);
	}
	
	/*- Employee License +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public void save(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.save(trsEmployeeLicense);
	}
	
	@Override
	public void update(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.update(trsEmployeeLicense);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.saveOrUpdate(trsEmployeeLicense);
	}
	
	@Override
	public void delete(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.delete(trsEmployeeLicense);
	}
	
	@Override
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense(){
		return trsEmployeeLicenseDAO.getAllTrsEmployeeLicense();
	}
	
	@Override
	public List<TrsEmployeeLicense> getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(Map<String, Object> requestMap){
		return trsEmployeeLicenseDAO.getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(requestMap);
	}
	
	/*- Relation Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public List<RelationshipType> getAllRelationshipType(){
		return RelationshipType.getAllTypes();
	}
	
	@Override
	public RelationshipType getRelationshipTypeById(Character id){
		return RelationshipType.getTypById(id);
	}
	
	/*- Marital Status Type +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Override
	public List<MaritalStatusType> getAllMaritalStatusType(){
		return MaritalStatusType.getAllTypes();
	}
	
	@Override
	public MaritalStatusType getMaritalStatusTypeTypeById(Character id){
		return MaritalStatusType.getTypById(id);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void setTrsEmployeeDAO(TrsEmployeeDAO trsEmployeeDAO) {
		this.trsEmployeeDAO = trsEmployeeDAO;
	}

	public void setTrsEmployeeEmergencyContactDAO(TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO) {
		this.trsEmployeeEmergencyContactDAO = trsEmployeeEmergencyContactDAO;
	}

	public void setTrsEmployeeLicenseDAO(TrsEmployeeLicenseDAO trsEmployeeLicenseDAO) {
		this.trsEmployeeLicenseDAO = trsEmployeeLicenseDAO;
	}

	public void setTrsEmployeeDependentDAO(TrsEmployeeDependentDAO trsEmployeeDependentDAO) {
		this.trsEmployeeDependentDAO = trsEmployeeDependentDAO;
	}

	public void setTrsEmployeeMembershipDAO(TrsEmployeeMembershipDAO trsEmployeeMembershipDAO) {
		this.trsEmployeeMembershipDAO = trsEmployeeMembershipDAO;
	}

	public void setTrsEmployeeImmigrationDAO(TrsEmployeeImmigrationDAO trsEmployeeImmigrationDAO) {
		this.trsEmployeeImmigrationDAO = trsEmployeeImmigrationDAO;
	}

	public void setTrsEmployeeExprienceDAO(TrsEmployeeExprienceDAO trsEmployeeExprienceDAO) {
		this.trsEmployeeExprienceDAO = trsEmployeeExprienceDAO;
	}

	public void setTrsEmployeeEducationDAO(TrsEmployeeEducationDAO trsEmployeeEducationDAO) {
		this.trsEmployeeEducationDAO = trsEmployeeEducationDAO;
	}

	public void setTrsEmployeeLanguageDAO(TrsEmployeeLanguageDAO trsEmployeeLanguageDAO) {
		this.trsEmployeeLanguageDAO = trsEmployeeLanguageDAO;
	}

	public void setTrsEmployeeSkillDAO(TrsEmployeeSkillDAO trsEmployeeSkillDAO) {
		this.trsEmployeeSkillDAO = trsEmployeeSkillDAO;
	}

	public void setTrsEmployeeSalaryDAO(TrsEmployeeSalaryDAO trsEmployeeSalaryDAO) {
		this.trsEmployeeSalaryDAO = trsEmployeeSalaryDAO;
	}
}