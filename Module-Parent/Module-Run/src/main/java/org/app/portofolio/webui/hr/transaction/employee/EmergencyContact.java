package org.app.portofolio.webui.hr.transaction.employee;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.employee.model.EmergencyContactListItemRenderer;
import org.module.hr.model.TrsEmployee;
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
public class EmergencyContact {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listBoxEmergencyContact")
	private Listbox listBoxEmergencyContact;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact;
	private List<TrsEmployeeEmergencyContact> employeeEmergencyContacts;
	private EmergencyContactListItemRenderer emergencyContactListItemRenderer;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listBoxEmergencyContact.setCheckmark(true);
		listBoxEmergencyContact.setMultiple(true);
		listBoxEmergencyContact.setRows(15);
		listBoxEmergencyContact.setStyle("border-style: none;");
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
		employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(requestMap);
		emergencyContactListItemRenderer = new EmergencyContactListItemRenderer();
		
		listBoxEmergencyContact.setModel(new ListModelList<TrsEmployeeEmergencyContact>());
		listBoxEmergencyContact.setItemRenderer(emergencyContactListItemRenderer);
		
		doPrepareList();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxEmergencyContact.getModel();
		TrsEmployeeEmergencyContact trsEmployeeEmergencyContact = new TrsEmployeeEmergencyContact();
		trsEmployeeEmergencyContact.setIdEmployee(trsEmployee);
		listModelList.add(0,  trsEmployeeEmergencyContact);		
	}
	
	@Command
	public void doDelete(){
		final ListModelList<TrsEmployeeEmergencyContact> listModelListEmployeeEmergencyContact = (ListModelList)listBoxEmergencyContact.getModel();
		
		if (listBoxEmergencyContact.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		} else {
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					if (((Integer)event.getData()).intValue() == Messagebox.OK){
						for (TrsEmployeeEmergencyContact trsEmployeeEmergencyContact : listModelListEmployeeEmergencyContact) {
							if (listModelListEmployeeEmergencyContact.isSelected(trsEmployeeEmergencyContact)){
								employeeService.delete(trsEmployeeEmergencyContact);
							}
						}
						
						BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmergencyContact", null);
					} else {
						return;
					}
				}
			});
		}
	}
	
	@GlobalCommand
	@NotifyChange({"employeeEmergencyContacts"})
	public void refreshAfterSaveOrUpdateEmergencyContact(){
		HashMap<String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(requestMap);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public Listbox getListBoxEmergencyContact() {
		return listBoxEmergencyContact;
	}

	public void setListBoxEmergencyContact(Listbox listBoxEmergencyContact) {
		this.listBoxEmergencyContact = listBoxEmergencyContact;
	}

	public EmergencyContactListItemRenderer getEmergencyContactListItemRenderer() {
		return emergencyContactListItemRenderer;
	}

	public void setEmergencyContactListItemRenderer(EmergencyContactListItemRenderer emergencyContactListItemRenderer) {
		this.emergencyContactListItemRenderer = emergencyContactListItemRenderer;
	}

	public List<TrsEmployeeEmergencyContact> getEmployeeEmergencyContacts() {
		return employeeEmergencyContacts;
	}

	public void setEmployeeEmergencyContacts(List<TrsEmployeeEmergencyContact> employeeEmergencyContacts) {
		this.employeeEmergencyContacts = employeeEmergencyContacts;
	}

	public TrsEmployeeEmergencyContact getSelectedEmployeeEmergencyContact() {
		return selectedEmployeeEmergencyContact;
	}

	public void setSelectedEmployeeEmergencyContact(TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact) {
		this.selectedEmployeeEmergencyContact = selectedEmployeeEmergencyContact;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}