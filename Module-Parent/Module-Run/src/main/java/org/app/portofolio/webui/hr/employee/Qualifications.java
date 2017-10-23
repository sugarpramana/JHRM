package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.EmployeeEducationListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeExperienceListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeLanguageListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeLicenseListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeSkillListItemRenderer;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstSkill;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEducation;
import org.module.hr.model.TrsEmployeeExprience;
import org.module.hr.model.TrsEmployeeLanguage;
import org.module.hr.model.TrsEmployeeLicense;
import org.module.hr.model.TrsEmployeeSkill;
import org.module.hr.service.EmployeeService;
import org.module.sysadmin.model.SecRight;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class Qualifications {
	
	@Wire("#ListBoxEmployeeExperience")
	private Listbox listEmployeeExperience;
	
	@Wire("#ListBoxEmployeeEducation")
	private Listbox listEmployeeEducation;
	
	@Wire("#ListBoxEmployeeSkill")
	private Listbox listEmployeeSkill;
	
	@Wire("#ListBoxEmployeeLanguage")
	private Listbox listEmployeeLanguage;
	
	@Wire("#ListBoxEmployeeLicense")
	private Listbox listEmployeeLicense;
	
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployee trsEmployee;
	
	private EmployeeExperienceListItemRenderer employeeExperienceListItemRenderer;
	private List<TrsEmployeeExprience> employeeExpriences;
	private TrsEmployeeExprience selectedEmployeeExprience;
	
	private EmployeeEducationListItemRenderer employeeEducationListItemRenderer;
	private List<TrsEmployeeEducation> employeeEducations;
	private TrsEmployeeEducation selectedEmployeeEducation;
	
	private EmployeeSkillListItemRenderer employeeSkillListItemRenderer;
	private List<TrsEmployeeSkill> employeeSkills;
	private TrsEmployeeSkill selectedEmployeeSkill;
	
	private EmployeeLanguageListItemRenderer employeeLanguageListItemRenderer;
	private List<TrsEmployeeLanguage> employeeLanguages;
	private TrsEmployeeLanguage selectedEmployeeLanguage;
	
	private EmployeeLicenseListItemRenderer employeeLicenseListItemRenderer;
	private List<TrsEmployeeLicense> employeeLicenses;
	private TrsEmployeeLicense selectedEmployeeLicense;
	
	public void doPrepareList(){
		
		listEmployeeExperience.setCheckmark(true);
		listEmployeeExperience.setMultiple(true);
		listEmployeeExperience.setRows(15);
		listEmployeeExperience.setStyle("border-style: none;");
		
		listEmployeeEducation.setCheckmark(true);
		listEmployeeEducation.setMultiple(true);
		listEmployeeEducation.setRows(15);
		listEmployeeEducation.setStyle("border-style: none;");
		
		listEmployeeSkill.setCheckmark(true);
		listEmployeeSkill.setMultiple(true);
		listEmployeeSkill.setRows(15);
		listEmployeeSkill.setStyle("border-style: none;");
		
		
		listEmployeeLanguage.setCheckmark(true);
		listEmployeeLanguage.setMultiple(true);
		listEmployeeLanguage.setRows(15);
		listEmployeeLanguage.setStyle("border-style: none;");
		
		listEmployeeLicense.setCheckmark(true);
		listEmployeeLicense.setMultiple(true);
		listEmployeeLicense.setRows(15);
		listEmployeeLicense.setStyle("border-style: none;");
		
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object, 
			@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		this.trsEmployee = trsEmployee;
		
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeExpriences = employeeService.getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(requestMap);
		employeeEducations = employeeService.getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(requestMap);
		employeeSkills = employeeService.getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(requestMap);
		employeeLanguages = employeeService.getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(requestMap);
		employeeLicenses= employeeService.getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(requestMap);
		
		employeeExperienceListItemRenderer = new EmployeeExperienceListItemRenderer();
		employeeEducationListItemRenderer = new EmployeeEducationListItemRenderer();
		employeeSkillListItemRenderer = new EmployeeSkillListItemRenderer();
		employeeLanguageListItemRenderer = new EmployeeLanguageListItemRenderer();
		employeeLicenseListItemRenderer = new EmployeeLicenseListItemRenderer();
		
		listEmployeeExperience.setModel(new ListModelList<TrsEmployeeExprience>());
		listEmployeeExperience.setItemRenderer(employeeExperienceListItemRenderer);
		
		listEmployeeEducation.setModel(new ListModelList<TrsEmployeeEducation>());
		listEmployeeEducation.setItemRenderer(employeeEducationListItemRenderer);
		
		listEmployeeSkill.setModel(new ListModelList<TrsEmployeeSkill>());
		listEmployeeSkill.setItemRenderer(employeeSkillListItemRenderer);
		
		listEmployeeLanguage.setModel(new ListModelList<TrsEmployeeLanguage>());
		listEmployeeLanguage.setItemRenderer(employeeLanguageListItemRenderer);
		
		listEmployeeLicense.setModel(new ListModelList<TrsEmployeeLicense>());
		listEmployeeLicense.setItemRenderer(employeeLicenseListItemRenderer);
		
		doPrepareList();
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNewExperience(){
		ListModelList listModelList = (ListModelList) listEmployeeExperience.getModel();
		TrsEmployeeExprience trsEmployeeExprience = new TrsEmployeeExprience();
		trsEmployeeExprience.setIdEmployee(trsEmployee);
		listModelList.add(0,  trsEmployeeExprience);
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNewEducation(){
		ListModelList listModelList = (ListModelList) listEmployeeEducation.getModel();
		TrsEmployeeEducation trsEmployeeEducation = new TrsEmployeeEducation();
		trsEmployeeEducation.setIdEmployee(trsEmployee);
		listModelList.add(0, trsEmployeeEducation);
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNewSkill(){
		ListModelList listModelList = (ListModelList) listEmployeeSkill.getModel();
		TrsEmployeeSkill trsEmployeeSkill = new TrsEmployeeSkill();
		trsEmployeeSkill.setIdEmployee(trsEmployee);
		listModelList.add(0, trsEmployeeSkill);
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNewLanguage(){
		ListModelList listModelList = (ListModelList) listEmployeeLanguage.getModel();
		TrsEmployeeLanguage trsEmployeeLanguage = new TrsEmployeeLanguage();
		trsEmployeeLanguage.setIdEmployee(trsEmployee);
		listModelList.add(0,  new TrsEmployeeLanguage());
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNewLicense(){
		ListModelList listModelList = (ListModelList) listEmployeeLicense.getModel();
		TrsEmployeeLicense trsEmployeeLicense = new TrsEmployeeLicense();
		trsEmployeeLicense.setIdEmployee(trsEmployee);
		listModelList.add(0, trsEmployeeLicense);
	}
	
	@GlobalCommand
	@NotifyChange("employeeExpriences")
	public void updateTrsEmployeeExprience(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeExpriences = employeeService.getTrsEmployeeExprienceByTrsEmployeeExprienceRequestMap(requestMap);
	}
	
	@GlobalCommand
	@NotifyChange("employeeEducations")
	public void updateTrsEmployeeEducation(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeEducations = employeeService.getTrsEmployeeEducationByTrsEmployeeEducationRequestMap(requestMap);
	}
	
	@GlobalCommand
	@NotifyChange("employeeSkills")
	public void updateTrsEmployeeSkill(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeSkills = employeeService.getTrsEmployeeSkillByTrsEmployeeSkillRequestMap(requestMap);
	}
	
	@GlobalCommand
	@NotifyChange("employeeLanguages")
	public void updateTrsEmployeeLanguage(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeLanguages = employeeService.getTrsEmployeeLanguageByTrsEmployeeLanguageRequestMap(requestMap);
	}
	
	@GlobalCommand
	@NotifyChange("employeeLicenses")
	public void updateTrsEmployeeLicense(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeLicenses= employeeService.getTrsEmployeeLicenseByTrsEmployeeLicenseRequestMap(requestMap);
	}

	public Listbox getListEmployeeExperience() {
		return listEmployeeExperience;
	}

	public void setListEmployeeExperience(Listbox listEmployeeExperience) {
		this.listEmployeeExperience = listEmployeeExperience;
	}

	public Listbox getListEmployeeEducation() {
		return listEmployeeEducation;
	}

	public void setListEmployeeEducation(Listbox listEmployeeEducation) {
		this.listEmployeeEducation = listEmployeeEducation;
	}

	public Listbox getListEmployeeSkill() {
		return listEmployeeSkill;
	}

	public void setListEmployeeSkill(Listbox listEmployeeSkill) {
		this.listEmployeeSkill = listEmployeeSkill;
	}

	public Listbox getListEmployeeLanguage() {
		return listEmployeeLanguage;
	}

	public void setListEmployeeLanguage(Listbox listEmployeeLanguage) {
		this.listEmployeeLanguage = listEmployeeLanguage;
	}

	public Listbox getListEmployeeLicense() {
		return listEmployeeLicense;
	}

	public void setListEmployeeLicense(Listbox listEmployeeLicense) {
		this.listEmployeeLicense = listEmployeeLicense;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public EmployeeExperienceListItemRenderer getEmployeeExperienceListItemRenderer() {
		return employeeExperienceListItemRenderer;
	}

	public void setEmployeeExperienceListItemRenderer(
			EmployeeExperienceListItemRenderer employeeExperienceListItemRenderer) {
		this.employeeExperienceListItemRenderer = employeeExperienceListItemRenderer;
	}

	public List<TrsEmployeeExprience> getEmployeeExpriences() {
		return employeeExpriences;
	}

	public void setEmployeeExpriences(List<TrsEmployeeExprience> employeeExpriences) {
		this.employeeExpriences = employeeExpriences;
	}

	public TrsEmployeeExprience getSelectedEmployeeExprience() {
		return selectedEmployeeExprience;
	}

	public void setSelectedEmployeeExprience(TrsEmployeeExprience selectedEmployeeExprience) {
		this.selectedEmployeeExprience = selectedEmployeeExprience;
	}

	public EmployeeEducationListItemRenderer getEmployeeEducationListItemRenderer() {
		return employeeEducationListItemRenderer;
	}

	public void setEmployeeEducationListItemRenderer(EmployeeEducationListItemRenderer employeeEducationListItemRenderer) {
		this.employeeEducationListItemRenderer = employeeEducationListItemRenderer;
	}

	public List<TrsEmployeeEducation> getEmployeeEducations() {
		return employeeEducations;
	}

	public void setEmployeeEducations(List<TrsEmployeeEducation> employeeEducations) {
		this.employeeEducations = employeeEducations;
	}

	public TrsEmployeeEducation getSelectedEmployeeEducation() {
		return selectedEmployeeEducation;
	}

	public void setSelectedEmployeeEducation(TrsEmployeeEducation selectedEmployeeEducation) {
		this.selectedEmployeeEducation = selectedEmployeeEducation;
	}

	public EmployeeSkillListItemRenderer getEmployeeSkillListItemRenderer() {
		return employeeSkillListItemRenderer;
	}

	public void setEmployeeSkillListItemRenderer(EmployeeSkillListItemRenderer employeeSkillListItemRenderer) {
		this.employeeSkillListItemRenderer = employeeSkillListItemRenderer;
	}

	public List<TrsEmployeeSkill> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<TrsEmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public TrsEmployeeSkill getSelectedEmployeeSkill() {
		return selectedEmployeeSkill;
	}

	public void setSelectedEmployeeSkill(TrsEmployeeSkill selectedEmployeeSkill) {
		this.selectedEmployeeSkill = selectedEmployeeSkill;
	}

	public EmployeeLanguageListItemRenderer getEmployeeLanguageListItemRenderer() {
		return employeeLanguageListItemRenderer;
	}

	public void setEmployeeLanguageListItemRenderer(EmployeeLanguageListItemRenderer employeeLanguageListItemRenderer) {
		this.employeeLanguageListItemRenderer = employeeLanguageListItemRenderer;
	}

	public List<TrsEmployeeLanguage> getEmployeeLanguages() {
		return employeeLanguages;
	}

	public void setEmployeeLanguages(List<TrsEmployeeLanguage> employeeLanguages) {
		this.employeeLanguages = employeeLanguages;
	}

	public TrsEmployeeLanguage getSelectedEmployeeLanguage() {
		return selectedEmployeeLanguage;
	}

	public void setSelectedEmployeeLanguage(TrsEmployeeLanguage selectedEmployeeLanguage) {
		this.selectedEmployeeLanguage = selectedEmployeeLanguage;
	}

	public EmployeeLicenseListItemRenderer getEmployeeLicenseListItemRenderer() {
		return employeeLicenseListItemRenderer;
	}

	public void setEmployeeLicenseListItemRenderer(EmployeeLicenseListItemRenderer employeeLicenseListItemRenderer) {
		this.employeeLicenseListItemRenderer = employeeLicenseListItemRenderer;
	}

	public List<TrsEmployeeLicense> getEmployeeLicenses() {
		return employeeLicenses;
	}

	public void setEmployeeLicenses(List<TrsEmployeeLicense> employeeLicenses) {
		this.employeeLicenses = employeeLicenses;
	}

	public TrsEmployeeLicense getSelectedEmployeeLicense() {
		return selectedEmployeeLicense;
	}

	public void setSelectedEmployeeLicense(TrsEmployeeLicense selectedEmployeeLicense) {
		this.selectedEmployeeLicense = selectedEmployeeLicense;
	}
	
}
