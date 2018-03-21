package org.app.portofolio.webui.hr.transaction.employee;

import java.util.List;

import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.transaction.employee.validator.TrsEmployeePersonalDetailFormValidator;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.dto.MaritalStatusType;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.ImmutableFields;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
*
* @author formulateko@admin.com
*/
public class PersonalDetail {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#windowPersonalDetail")
	private Window windowPersonalDetail;
	
	@Wire("#textBoxFirstName")
	private Textbox textBoxFirstName;
	
	@Wire("#textBoxMiddleName")
	private Textbox textBoxMiddleName;
	
	@Wire("#textBoxLastName")
	private Textbox textBoxLastName;
	
	@Wire("#textBoxIdEmployee")
	private Textbox textBoxIdEmployee;
	
	@Wire("#textBoxOtherLicense")
	private Textbox textBoxOtherLicense;
	
	@Wire("#textBoxDriverLicense")
	private Textbox textBoxDriverLicense;
	
	@Wire("#dateBoxExpiredLicense")
	private Datebox dateBoxExpiredLicense;
	
	@Wire("#radioMale")
	private Radio radioMale;
	
	@Wire("#radioFemale")
	private Radio radioFemale;
	
	@Wire("#dateBoxDateOfBirth")
	private Datebox dateBoxDateOfBirth;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonSave")
	private Button buttonSave;
	
	@Wire("#comboBoxMaritalStatus")
	private Combobox comboBoxMaritalStatus;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;
	
	private MaritalStatusType maritalStatusType;
	private MaritalStatusType selectedMaritalStatus;
	private List<MaritalStatusType> maritalStatusTypes;
	
	private TrsEmployeePersonalDetailFormValidator formValidator = new TrsEmployeePersonalDetailFormValidator();

	private Boolean isEdit;
	private ModalAction action;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private void formEditCondition() {
		ComponentConditionUtil.visibleButton(buttonSave);
		ComponentConditionUtil.invisibleButton(buttonEdit);
		ComponentConditionUtil.enableCombobox(comboBoxMaritalStatus);
		ComponentConditionUtil.enableTextbox(textBoxDriverLicense, textBoxFirstName, textBoxIdEmployee, textBoxLastName, textBoxMiddleName, textBoxOtherLicense);
		ComponentConditionUtil.enableDateBox(dateBoxDateOfBirth, dateBoxExpiredLicense);
		ComponentConditionUtil.enableRadio(radioFemale, radioMale);
	}
	
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSave);
		ComponentConditionUtil.visibleButton(buttonEdit);
		ComponentConditionUtil.disableCombobox(comboBoxMaritalStatus);
		ComponentConditionUtil.disableTextbox(textBoxDriverLicense, textBoxFirstName, textBoxIdEmployee, textBoxLastName, textBoxMiddleName, textBoxOtherLicense);
		ComponentConditionUtil.disableDateBox(dateBoxDateOfBirth, dateBoxExpiredLicense);
		ComponentConditionUtil.disableRadio(radioFemale, radioMale);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		
		Selectors.wireComponents(component, this, false);
			
		this.trsEmployee = trsEmployee;
		
		maritalStatusTypes = employeeService.getAllMaritalStatusType();
		maritalStatusType = employeeService.getMaritalStatusTypeTypeById(trsEmployee.getMaritalStatus());
		
		formDetailCondition();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doEdit(){
		formEditCondition();
	}
	
	@Command
	public void doSave(){
		if (maritalStatusType != null){
			trsEmployee.setMaritalStatus(maritalStatusType.getStpId());
		}
		
		employeeService.update(trsEmployee);
		
		formDetailCondition();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@ImmutableFields
	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public MaritalStatusType getSelectedMaritalStatus() {
		return selectedMaritalStatus;
	}

	public void setSelectedMaritalStatus(MaritalStatusType selectedMaritalStatus) {
		this.selectedMaritalStatus = selectedMaritalStatus;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public List<MaritalStatusType> getMaritalStatusTypes() {
		return maritalStatusTypes;
	}

	public void setMaritalStatusTypes(List<MaritalStatusType> maritalStatusTypes) {
		this.maritalStatusTypes = maritalStatusTypes;
	}

	public ModalAction getAction() {
		return action;
	}

	public void setAction(ModalAction action) {
		this.action = action;
	}

	public TrsEmployeePersonalDetailFormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(TrsEmployeePersonalDetailFormValidator formValidator) {
		this.formValidator = formValidator;
	}

	public MaritalStatusType getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(MaritalStatusType maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}
}