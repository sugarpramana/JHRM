package org.app.portofolio.webui.hr.transaction.employee;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.employee.model.DependentListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeDependent;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Dependent {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#ListBoxDependent")
	private Listbox ListBoxDependent;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployeeDependent selectedEmployeeDependent;
	private List<TrsEmployeeDependent> trsEmployeeDependents;
	private DependentListItemRenderer dependentListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		ListBoxDependent.setCheckmark(true);
		ListBoxDependent.setMultiple(true);
		ListBoxDependent.setRows(15);
		ListBoxDependent.setStyle("border-style: none;");
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object, 
		@ExecutionArgParam("type") TrsEmployee trsEmployee) {
	
		Selectors.wireComponents(component, this, false);
		
		this.trsEmployee = trsEmployee;
		
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		trsEmployeeDependents = employeeService.getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(requestMap);
		dependentListItemRenderer = new DependentListItemRenderer();
		
		ListBoxDependent.setModel(new ListModelList<TrsEmployeeEmergencyContact>());
		ListBoxDependent.setItemRenderer(dependentListItemRenderer);
		
		doPrepareList();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) ListBoxDependent.getModel();
		TrsEmployeeDependent trsEmployeeDependent = new TrsEmployeeDependent();
		trsEmployeeDependent.setIdEmployee(trsEmployee);
		listModelList.add(0,  trsEmployeeDependent);		
	}
	
	@Command
	public void doDelete(){
		final ListModelList<TrsEmployeeDependent> listModelListEmployeeDependent = (ListModelList) ListBoxDependent.getModel();
		
		if (ListBoxDependent.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		} else {
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener<Event>() {
				
				@Override
				public void onEvent(Event event) throws Exception {
					if (((Integer)event.getData()).intValue() == Messagebox.OK){
						for (TrsEmployeeDependent trsEmployeeDependent : listModelListEmployeeDependent) {
							if (listModelListEmployeeDependent.isSelected(trsEmployeeDependent)){
								employeeService.delete(trsEmployeeDependent);
							}
						}
						
						BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmployeeDependent", null);
					} else {
						return;
					}
				}
			});
		}
	}
	
	@GlobalCommand
	@NotifyChange("trsEmployeeDependents")
	public void refreshAfterSaveOrUpdateEmployeeDependent(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		trsEmployeeDependents = employeeService.getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(requestMap);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public DependentListItemRenderer getDependentListItemRenderer() {
		return dependentListItemRenderer;
	}

	public void setDependentListItemRenderer(DependentListItemRenderer dependentListItemRenderer) {
		this.dependentListItemRenderer = dependentListItemRenderer;
	}

	public List<TrsEmployeeDependent> getTrsEmployeeDependents() {
		return trsEmployeeDependents;
	}

	public void setTrsEmployeeDependents(List<TrsEmployeeDependent> trsEmployeeDependents) {
		this.trsEmployeeDependents = trsEmployeeDependents;
	}

	public TrsEmployeeDependent getSelectedEmployeeDependent() {
		return selectedEmployeeDependent;
	}

	public void setSelectedEmployeeDependent(TrsEmployeeDependent selectedEmployeeDependent) {
		this.selectedEmployeeDependent = selectedEmployeeDependent;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}
}