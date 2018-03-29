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
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EmergencyContact {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listboxEmergencyContact")
	private Listbox listboxEmergencyContact;
	
	@Wire("#pagingEmergencyContact")
	private Paging pagingEmergencyContact;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact;
	private List<TrsEmployeeEmergencyContact> employeeEmergencyContacts;
	//private List<TrsEmployeeEmergencyContact> casts;
	private ListitemRenderer<TrsEmployeeEmergencyContact> listitemRenderer;
	
	private HashMap<String, Object> hashMapEmployeeEmergencyContact;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxEmergencyContact.setCheckmark(true);
		listboxEmergencyContact.setMultiple(true);
		listboxEmergencyContact.setStyle("border-style: none;");
		listboxEmergencyContact.setMold("paging");
		
		HashMap<String, Object> hashMapEmployee = new HashMap<String, Object>();
		hashMapEmployee.put("count", trsEmployee.getIdEmployee());
		int count = employeeService.getCountTrsEmployeeEmergencyContacts(hashMapEmployee);
		System.out.println("Cout Size >>>"+count);

		pagingEmergencyContact.setTotalSize(count);
		pagingEmergencyContact.setDetailed(true);
		pagingEmergencyContact.setPageSize(pageSize);
	}

	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingEmergencyContact.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapEmployeeEmergencyContact = new HashMap<String, Object>();
		hashMapEmployeeEmergencyContact.put("idEmployee", trsEmployee.getIdEmployee());
		hashMapEmployeeEmergencyContact.put("firstResult", refreshActivePage);
		hashMapEmployeeEmergencyContact.put("maxResults", pagingEmergencyContact.getPageSize());

		employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactPaging(hashMapEmployeeEmergencyContact);
		listitemRenderer = new EmergencyContactListItemRenderer();
		
		/*HashMap<String, Object> hashMapEmployee = new HashMap<String, Object>();
		hashMapEmployee.put("idEmployee", trsEmployee.getIdEmployee());
		employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(hashMapEmployee);
		System.out.println("List Emergency ID Employee Size >>>"+employeeEmergencyContacts.size());

		listitemRenderer = new EmergencyContactListItemRenderer();
	
		hashMapEmployeeEmergencyContact = new HashMap<String, Object>();
		hashMapEmployeeEmergencyContact.put("firstResult", refreshActivePage);
		hashMapEmployeeEmergencyContact.put("maxResults", pagingEmergencyContact.getPageSize());

		employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactPaging(hashMapEmployeeEmergencyContact);
		System.out.println("List Emergency ID Employee Paging Size >>>"+employeeEmergencyContacts.size());*/
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

		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("employeeEmergencyContacts")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listboxEmergencyContact.getModel();
		TrsEmployeeEmergencyContact trsEmployeeEmergencyContact = new TrsEmployeeEmergencyContact();
		trsEmployeeEmergencyContact.setIdEmployee(trsEmployee);
		listModelList.add(0,  trsEmployeeEmergencyContact);		
	}
	
	@Command
	public void doDelete(){
		final ListModelList<TrsEmployeeEmergencyContact> listModelListEmployeeEmergencyContact = (ListModelList)listboxEmergencyContact.getModel();
		
		if (listboxEmergencyContact.getSelectedIndex() == -1){
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
		//employeeEmergencyContacts = employeeService.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(requestMap);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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

	public TrsEmployeeEmergencyContact getSelectedEmployeeEmergencyContact() {
		return selectedEmployeeEmergencyContact;
	}

	public void setSelectedEmployeeEmergencyContact(TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact) {
		this.selectedEmployeeEmergencyContact = selectedEmployeeEmergencyContact;
	}
	
	/*public List<TrsEmployeeEmergencyContact> getCasts() {
		return casts;
	}

	public void setCasts(List<TrsEmployeeEmergencyContact> casts) {
		this.casts = casts;
	}*/

	public List<TrsEmployeeEmergencyContact> getEmployeeEmergencyContacts() {
		return employeeEmergencyContacts;
	}

	public void setEmployeeEmergencyContacts(List<TrsEmployeeEmergencyContact> employeeEmergencyContacts) {
		this.employeeEmergencyContacts = employeeEmergencyContacts;
	}

	public ListitemRenderer<TrsEmployeeEmergencyContact> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<TrsEmployeeEmergencyContact> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}