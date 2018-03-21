package org.app.portofolio.webui.hr.transaction.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.transaction.employee.model.EmployeeStatusListItemRenderer;
import org.app.portofolio.webui.hr.transaction.employee.model.JobCategoryListItemRenderer;
import org.app.portofolio.webui.hr.transaction.employee.model.JobTitleListItemRenderer;
import org.app.portofolio.webui.hr.transaction.employee.model.LocationListItemRenderer;
import org.app.portofolio.webui.hr.transaction.employee.model.SubUnitListItemRenderer;
import org.app.portofolio.webui.hr.transaction.employee.validator.TrsEmployeeJobFormValidator;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstLocation;
import org.module.hr.model.MstSubUnit;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.EmployeeService;
import org.module.hr.service.JobService;
import org.module.hr.service.OrganizationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

/**
*
* @author formulateko@admin.com
*/
public class Job {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#windowJob")
	private Window windowJob;
	
	@Wire("#bandBoxJobTitle")
	private Bandbox bandBoxJobTitle;
	
	@Wire("#listBoxJobTitle")
	private Listbox listBoxJobTitle;
	
	@Wire("#bandBoxEmploymentStatus")
	private Bandbox bandBoxEmploymentStatus;
	
	@Wire("#listBoxEmploymentStatus")
	private Listbox listBoxEmploymentStatus;
	
	@Wire("#bandBoxJobCategory")
	private Bandbox bandBoxJobCategory;
	
	@Wire("#listBoxJobCategory")
	private Listbox listBoxJobCategory;
	
	@Wire("#bandBoxSubUnit")
	private Bandbox bandBoxSubUnit;
	
	@Wire("#listBoxSubUnit")
	private Listbox listBoxSubUnit;
	
	@Wire("#bandBoxLocation")
	private Bandbox bandBoxLocation;
	
	@Wire("#listBoxLocation")
	private Listbox listBoxLocation;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonSave")
	private Button buttonSave;
	
	@Wire("#buttonTerminateEmployment")
	private Button buttonTerminateEmployment;
	
	@Wire("#dateBoxJoinedDate")
	private Datebox dateBoxJoinedDate;
	
	/*@Wire("#dateBoxStartDate")
	private Datebox dateBoxStartDate;
	
	@Wire("#dateBoxEndDate")
	private Datebox dateBoxEndDate;*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@WireVariable
	private EmployeeService employeeService;
	
	@WireVariable
	private JobService jobService;
	
	@WireVariable
	private OrganizationService organizationService;

	private TrsEmployee trsEmployee;
	private TrsEmployeeJobFormValidator formValidator = new TrsEmployeeJobFormValidator();

	private ListitemRenderer<MstJobtitle> listitemRendererJobTitle;
	private String jobTitleKeySearch;
	private List<MstJobtitle> mstJobtitles;
	private MstJobtitle selectedMstJobtitle;
	
	private ListitemRenderer<MstEmployementStatus> listitemRendererEmploymentStatus;
	private String employmentStatusKeySearch;
	private List<MstEmployementStatus> listMstEmployementStatus;
	private MstEmployementStatus selectedMstEmployementStatus;
	
	private ListitemRenderer<MstJobCategory> listitemRendererJobCategory;
	private String jobCategoryKeySearch;
	private List<MstJobCategory> mstJobCategories;
	private MstJobCategory selectedMstJobCategory;
	
	private ListitemRenderer<MstSubUnit> listitemRendererSubUnit;
	private String subUnitKeySearch;
	private List<MstSubUnit> mstSubUnits;
	private MstSubUnit selectedMstSubUnit;
	
	private ListitemRenderer<MstLocation> listitemRendererLocation;
	private String locationKeySearch;
	private List<MstLocation> mstLocations;
	private MstLocation selectedMstLocation;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private void formEditCondition() {
		ComponentConditionUtil.visibleButton(buttonSave, buttonTerminateEmployment);
		ComponentConditionUtil.invisibleButton(buttonEdit);
		ComponentConditionUtil.enableBandBox(bandBoxEmploymentStatus, bandBoxJobCategory, bandBoxJobTitle, bandBoxLocation);
		ComponentConditionUtil.enableDateBox(dateBoxJoinedDate);
	}

	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSave, buttonTerminateEmployment);
		ComponentConditionUtil.visibleButton(buttonEdit);
		ComponentConditionUtil.disableBandBox(bandBoxEmploymentStatus, bandBoxJobCategory, bandBoxJobTitle, bandBoxLocation, bandBoxSubUnit);
		ComponentConditionUtil.disableDateBox(dateBoxJoinedDate);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object, @ExecutionArgParam("type") TrsEmployee trsEmployee) {
		
		Selectors.wireComponents(component, this, false);
		
		this.trsEmployee = trsEmployee;
		
		formDetailCondition();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void searchJobTitle() {
		mstJobtitles.clear();
		List<MstJobtitle> cacheMstJobtitles = jobService.getAllMstJobtitles();
		
		if (jobTitleKeySearch == null || "".equals(jobTitleKeySearch)){
			mstJobtitles.addAll(cacheMstJobtitles);
		} else {
			for (MstJobtitle mstJobtitle : cacheMstJobtitles) {
				if (mstJobtitle.getJobName().toUpperCase().contains(jobTitleKeySearch.toUpperCase())) {
					mstJobtitles.clear();
					mstJobtitles.add(mstJobtitle);
					
					break;
				}
			}
		}
		
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>(mstJobtitles));
	}
	
	@Command
	public void openBandBoxJobTitle(){
		mstJobtitles = jobService.getAllMstJobtitles();
		
		listitemRendererJobTitle = new JobTitleListItemRenderer();
		
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>(mstJobtitles));
		listBoxJobTitle.setItemRenderer(listitemRendererJobTitle);
	}
	
	@Command
	public void searchEmploymentStatus() {
		listMstEmployementStatus.clear();
		
		if (employmentStatusKeySearch == null || "".equals(employmentStatusKeySearch)){
			listMstEmployementStatus = jobService.getAllMstEmployementStatus();
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("employementStatusName", employmentStatusKeySearch);
			listMstEmployementStatus = jobService.getByMstEmployementStatusRequestMap(hashMap);
		}
		
		listBoxEmploymentStatus.setModel(new ListModelList<MstEmployementStatus>(listMstEmployementStatus));
	}
	
	@Command
	public void openBandBoxEmploymentStatus(){
		listMstEmployementStatus = jobService.getAllMstEmployementStatus();
		
		listitemRendererEmploymentStatus = new EmployeeStatusListItemRenderer();
		
		listBoxEmploymentStatus.setModel(new ListModelList<MstEmployementStatus>(listMstEmployementStatus));
		listBoxEmploymentStatus.setItemRenderer(listitemRendererEmploymentStatus);
	}
	
	@Command
	public void searchJobCategory() {
		mstJobCategories.clear();
		
		List<MstJobCategory> cacheMstJobCategories = jobService.getAllMstJobCategories();
		
		if (jobCategoryKeySearch == null || "".equals(jobCategoryKeySearch)){
			mstJobCategories.addAll(cacheMstJobCategories);
		} else {
			for (MstJobCategory mstJobCategory: cacheMstJobCategories) {
				if (mstJobCategory.getJobCategoryName().contains(jobCategoryKeySearch)) {
					mstJobCategories.clear();
					mstJobCategories.add(mstJobCategory);
					break;
				}
			}
		}
		
		listBoxJobCategory.setModel(new ListModelList<MstJobCategory>(mstJobCategories));
	}
	
	@Command
	public void openBandBoxJobCategory(){
		mstJobCategories = jobService.getAllMstJobCategories();
		
		listitemRendererJobCategory = new JobCategoryListItemRenderer();
		
		listBoxJobCategory.setModel(new ListModelList<MstJobCategory>(mstJobCategories));
		listBoxJobCategory.setItemRenderer(listitemRendererJobCategory);
	}
	
	@Command
	public void searchSubUnit() {
		mstSubUnits.clear();
		
		// get all sub unit by service
		List<MstSubUnit> cacheMstSubUnits = new ArrayList<>();
		
		if (subUnitKeySearch == null || "".equals(subUnitKeySearch)){
			mstSubUnits.addAll(cacheMstSubUnits);
		} else {
			for (MstSubUnit mstSubUnit: cacheMstSubUnits) {
				if (mstSubUnit.getNameSubUnit().contains(subUnitKeySearch)) {
					mstSubUnits.clear();
					mstSubUnits.add(mstSubUnit);
					
					break;
				}
			}
		}
		
		listBoxSubUnit.setModel(new ListModelList<MstSubUnit>(mstSubUnits));
	}
	
	@Command
	public void openBandBoxSubUnit(){
		// get all sub unit by service
		listitemRendererSubUnit= new SubUnitListItemRenderer();
		 
		listBoxSubUnit.setModel(new ListModelList<MstSubUnit>(mstSubUnits));
		listBoxSubUnit.setItemRenderer(listitemRendererSubUnit);
	}
	
	@Command
	public void searchLocation() {
		mstLocations.clear();
		
		// get all location by service
		List<MstLocation> cacheMstLocations = new ArrayList<>();
		
		if (locationKeySearch == null || "".equals(locationKeySearch)){
			mstLocations.addAll(cacheMstLocations);
		} else {
			for (MstLocation mstLocation: cacheMstLocations) {
				if (mstLocation.getName().contains(locationKeySearch)) {
					mstLocations.clear();
					mstLocations.add(mstLocation);
					
					break;
				}
			}
		}
		
		listBoxLocation.setModel(new ListModelList<MstLocation>(mstLocations));
	}
	
	@Command
	public void openBandBoxLocation(){
		// get all location by service
		mstLocations = organizationService.getAllMstLocation();
		
		listitemRendererLocation= new LocationListItemRenderer(); 
		
		listBoxLocation.setModel(new ListModelList<MstLocation>(mstLocations));
		listBoxLocation.setItemRenderer(listitemRendererLocation);
	}
	
	@Command
	public void doEditJob(){
		formEditCondition();
	}
	
	@Command
	public void doSaveJob(){
		trsEmployee.setIdJobTitle(selectedMstJobtitle);
		trsEmployee.setIdEmployementStatus(selectedMstEmployementStatus);
		trsEmployee.setIdJobCategory(selectedMstJobCategory);
		trsEmployee.setIdSubUnit(selectedMstSubUnit);
		trsEmployee.setIdLocation(selectedMstLocation);
		employeeService.update(trsEmployee);
		formDetailCondition();
	}
	
	@Command
	public void doTerminateJob(){
		System.out.println("kuda");
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public TrsEmployeeJobFormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(TrsEmployeeJobFormValidator formValidator) {
		this.formValidator = formValidator;
	}

	public MstJobtitle getSelectedMstJobtitle() {
		return selectedMstJobtitle;
	}

	public void setSelectedMstJobtitle(MstJobtitle selectedMstJobtitle) {
		this.selectedMstJobtitle = selectedMstJobtitle;
		bandBoxJobTitle.setValue(selectedMstJobtitle.getJobName());
		bandBoxJobTitle.close();
	}

	public MstEmployementStatus getSelectedMstEmployementStatus() {
		return selectedMstEmployementStatus;
	}

	public void setSelectedMstEmployementStatus(MstEmployementStatus selectedMstEmployementStatus) {
		this.selectedMstEmployementStatus = selectedMstEmployementStatus;
		bandBoxEmploymentStatus.setValue(selectedMstEmployementStatus.getEmployementStatusName());
		bandBoxEmploymentStatus.close();
	}

	public MstJobCategory getSelectedMstJobCategory() {
		return selectedMstJobCategory;
	}

	public void setSelectedMstJobCategory(MstJobCategory selectedMstJobCategory) {
		this.selectedMstJobCategory = selectedMstJobCategory;
		bandBoxJobCategory.setValue(selectedMstJobCategory.getJobCategoryName());
		bandBoxJobCategory.close();
	}

	public String getSubUnitKeySearch() {
		return subUnitKeySearch;
	}

	public void setSubUnitKeySearch(String subUnitKeySearch) {
		this.subUnitKeySearch = subUnitKeySearch;
	}

	public MstSubUnit getSelectedMstSubUnit() {
		return selectedMstSubUnit;
	}

	public void setSelectedMstSubUnit(MstSubUnit selectedMstSubUnit) {
		this.selectedMstSubUnit = selectedMstSubUnit;
		bandBoxSubUnit.setValue(selectedMstSubUnit.getNameSubUnit());
		bandBoxSubUnit.close();
	}

	public MstLocation getSelectedMstLocation() {
		return selectedMstLocation;
	}

	public void setSelectedMstLocation(MstLocation selectedMstLocation) {
		this.selectedMstLocation = selectedMstLocation;
		bandBoxLocation.setValue(selectedMstLocation.getName());
		bandBoxLocation.close();
	}
	
	public String getJobTitleKeySearch() {
		return jobTitleKeySearch;
	}

	public void setJobTitleKeySearch(String jobTitleKeySearch) {
		this.jobTitleKeySearch = jobTitleKeySearch;
	}

	public String getEmploymentStatusKeySearch() {
		return employmentStatusKeySearch;
	}

	public void setEmploymentStatusKeySearch(String employmentStatusKeySearch) {
		this.employmentStatusKeySearch = employmentStatusKeySearch;
	}

	public String getJobCategoryKeySearch() {
		return jobCategoryKeySearch;
	}

	public void setJobCategoryKeySearch(String jobCategoryKeySearch) {
		this.jobCategoryKeySearch = jobCategoryKeySearch;
	}

	public String getLocationKeySearch() {
		return locationKeySearch;
	}

	public void setLocationKeySearch(String locationKeySearch) {
		this.locationKeySearch = locationKeySearch;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}
}