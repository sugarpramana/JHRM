package org.app.portofolio.webui.hr.transaction.employee;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.module.hr.model.TrsEmployee;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;

public class EmployeeDetailDialogVM {
	private Boolean isVisiblesFormPerssonalDetails;
	private Boolean isVisibleFormContactDetails;
	private Boolean isVisibleFormEmergencyContacts;
	private Boolean isVisibleFormDependents;
	private Boolean isVisibleFormImmigration;
	private Boolean isVisibleFormJob;
	private Boolean isVisibleFormSalary;
	private Boolean isVisibleFormReportTo;
	private Boolean isVisibleFormQualification;
	private Boolean isVisibleFormMemberships;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private Boolean test;
	
	private TrsEmployee trsEmployee;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void setVisibleFalseForAll() {
		isVisiblesFormPerssonalDetails = Boolean.FALSE;
		isVisibleFormContactDetails = Boolean.FALSE;
		isVisibleFormEmergencyContacts = Boolean.FALSE;
		isVisibleFormDependents = Boolean.FALSE;
		isVisibleFormImmigration = Boolean.FALSE;
		isVisibleFormJob = Boolean.FALSE;
		isVisibleFormSalary = Boolean.FALSE;
		isVisibleFormReportTo = Boolean.FALSE;
		isVisibleFormQualification = Boolean.FALSE;
		isVisibleFormMemberships = Boolean.FALSE;
		test = Boolean.FALSE;
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object,
			@ExecutionArgParam("trsEmployee") TrsEmployee trsEmployee) {

		Selectors.wireComponents(component, this, false);
		
		if (trsEmployee == null){
			this.trsEmployee = new TrsEmployee();
		}
		else {
			this.trsEmployee = trsEmployee;
		}
		
		selectPersonalDetails();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange({ "*" })
	public void selectPersonalDetails() {
		setVisibleFalseForAll();
		isVisiblesFormPerssonalDetails = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormContactDetails() {
		setVisibleFalseForAll();
		isVisibleFormContactDetails = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormEmergencyContacts() {
		setVisibleFalseForAll();
		isVisibleFormEmergencyContacts = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormDependents() {
		setVisibleFalseForAll();
		isVisibleFormDependents = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormImmigration() {
		setVisibleFalseForAll();
		isVisibleFormImmigration = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormJob() {
		setVisibleFalseForAll();
		isVisibleFormJob = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormSalary() {
		setVisibleFalseForAll();
		isVisibleFormSalary = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormReportTo() {
		setVisibleFalseForAll();
		isVisibleFormReportTo = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormQualification() {
		setVisibleFalseForAll();
		isVisibleFormQualification = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void selectFormMembership() {
		setVisibleFalseForAll();
		isVisibleFormMemberships = Boolean.TRUE;
	}

	@Command
	@NotifyChange({ "*" })
	public void test() {
		setVisibleFalseForAll();
		test = Boolean.TRUE;
	}

	@Command
	public void doNew() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Skills.ADD_FORM, null, null);
	}

	@Command
	public void doDetail() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Skills.DETAIL_FORM, null, null);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public Boolean getIsVisiblesFormPerssonalDetails() {
		return isVisiblesFormPerssonalDetails;
	}

	public void setIsVisiblesFormPerssonalDetails(Boolean isVisiblesFormPerssonalDetails) {
		this.isVisiblesFormPerssonalDetails = isVisiblesFormPerssonalDetails;
	}

	public Boolean getIsVisibleFormContactDetails() {
		return isVisibleFormContactDetails;
	}

	public void setIsVisibleFormContactDetails(Boolean isVisibleFormContactDetails) {
		this.isVisibleFormContactDetails = isVisibleFormContactDetails;
	}

	public Boolean getIsVisibleFormEmergencyContacts() {
		return isVisibleFormEmergencyContacts;
	}

	public void setIsVisibleFormEmergencyContacts(Boolean isVisibleFormEmergencyContacts) {
		this.isVisibleFormEmergencyContacts = isVisibleFormEmergencyContacts;
	}

	public Boolean getIsVisibleFormDependents() {
		return isVisibleFormDependents;
	}

	public void setIsVisibleFormDependents(Boolean isVisibleFormDependents) {
		this.isVisibleFormDependents = isVisibleFormDependents;
	}

	public Boolean getIsVisibleFormImmigration() {
		return isVisibleFormImmigration;
	}

	public void setIsVisibleFormImmigration(Boolean isVisibleFormImmigration) {
		this.isVisibleFormImmigration = isVisibleFormImmigration;
	}

	public Boolean getIsVisibleFormJob() {
		return isVisibleFormJob;
	}

	public void setIsVisibleFormJob(Boolean isVisibleFormJob) {
		this.isVisibleFormJob = isVisibleFormJob;
	}

	public Boolean getIsVisibleFormSalary() {
		return isVisibleFormSalary;
	}

	public void setIsVisibleFormSalary(Boolean isVisibleFormSalary) {
		this.isVisibleFormSalary = isVisibleFormSalary;
	}

	public Boolean getIsVisibleFormReportTo() {
		return isVisibleFormReportTo;
	}

	public void setIsVisibleFormReportTo(Boolean isVisibleFormReportTo) {
		this.isVisibleFormReportTo = isVisibleFormReportTo;
	}

	public Boolean getIsVisibleFormQualification() {
		return isVisibleFormQualification;
	}

	public void setIsVisibleFormQualification(Boolean isVisibleFormQualification) {
		this.isVisibleFormQualification = isVisibleFormQualification;
	}

	public Boolean getIsVisibleFormMemberships() {
		return isVisibleFormMemberships;
	}

	public void setIsVisibleFormMemberships(Boolean isVisibleFormMemberships) {
		this.isVisibleFormMemberships = isVisibleFormMemberships;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}
}