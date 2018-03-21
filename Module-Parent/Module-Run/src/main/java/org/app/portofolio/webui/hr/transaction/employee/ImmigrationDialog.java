package org.app.portofolio.webui.hr.transaction.employee;

import org.app.portofolio.webui.hr.transaction.employee.validator.TrsEmployeeImmigrationFormValidator;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindUtils;
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
import org.zkoss.zul.Window;

/**
*
* @author formulateko@admin.com
*/
public class ImmigrationDialog {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#windowImmigrationDialog")
	private Window windowImmigrationDialog;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	private TrsEmployeeImmigration trsEmployeeImmigration;
	
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployeeImmigrationFormValidator formValidator = new TrsEmployeeImmigrationFormValidator();
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("trsEmployeeImmigration") TrsEmployeeImmigration trsEmployeeImmigration,
		@ExecutionArgParam("trsEmployee") TrsEmployee trsEmployee) {
		
		Selectors.wireComponents(component, this, false);
		
		if (trsEmployeeImmigration != null){
			this.trsEmployeeImmigration = trsEmployeeImmigration;
		}
		
		// use for set default value when new condition
		if (this.trsEmployeeImmigration.getIdImmigration() == null){
			this.trsEmployeeImmigration.setDocument("passport");
		}
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doSave(){
		if (this.trsEmployeeImmigration.getIdImmigration() == null){
			employeeService.save(trsEmployeeImmigration);
		} else {
			employeeService.update(trsEmployeeImmigration);
		}
		
		BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmployeeImmigration", null);
		windowImmigrationDialog.onClose();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@ImmutableFields
	public TrsEmployeeImmigration getTrsEmployeeImmigration() {
		return trsEmployeeImmigration;
	}

	public void setTrsEmployeeImmigration(TrsEmployeeImmigration trsEmployeeImmigration) {
		this.trsEmployeeImmigration = trsEmployeeImmigration;
	}

	public TrsEmployeeImmigrationFormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(TrsEmployeeImmigrationFormValidator formValidator) {
		this.formValidator = formValidator;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}
}