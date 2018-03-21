package org.app.portofolio.webui.hr.transaction.employee;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.employee.model.MembershipListItemRenderer;
import org.module.hr.model.MstMembership;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
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

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Membership {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listBoxMembership")
	private Listbox listBoxMembership;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployee trsEmployee;
	
	private MembershipListItemRenderer membershipListItemRenderer;
	private List<TrsEmployeeMembership> employeeMemberships;
	private TrsEmployeeMembership selectedEmployeeMembership;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listBoxMembership.setCheckmark(true);
		listBoxMembership.setMultiple(true);
		listBoxMembership.setRows(15);
		listBoxMembership.setStyle("border-style: none;");
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
		employeeMemberships = employeeService.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
		membershipListItemRenderer = new MembershipListItemRenderer();
		
		listBoxMembership.setModel(new ListModelList<TrsEmployeeMembership>());
		listBoxMembership.setItemRenderer(membershipListItemRenderer);
		
		doPrepareList();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxMembership.getModel();
		TrsEmployeeMembership trsEmployeeMembership = new TrsEmployeeMembership();
		trsEmployeeMembership.setIdEmployee(trsEmployee);
		listModelList.add(0, trsEmployeeMembership);
	}
	
	@GlobalCommand
	public void updateMembership(@BindingParam("mstMembership") MstMembership mstMembership,
		@BindingParam("employeeMembershipID") Integer employeeMembershipID){
		
		ListModelList<TrsEmployeeMembership> listModelList = (ListModelList) listBoxMembership.getModel();
		//ListitemRenderer<TrsEmployeeMembership> listitemRenderer = listBoxMembership.getItemRenderer();
		
		for(TrsEmployeeMembership trsEmployeeMembership:listModelList){
			System.out.println(trsEmployeeMembership.getIdMembership());
		}
		
		/*if (employeeMembershipID == null){
			TrsEmployeeMembership trsEmployeeMembership = listModelList.get(0);
			trsEmployeeMembership.setIdMembership(mstMembership);
		} else {
			for (TrsEmployeeMembership trsEmployeeMembership : listModelList) {
				if (trsEmployeeMembership.getIdEmployeeMembership().equals(employeeMembershipID)) {
					trsEmployeeMembership.setIdMembership(mstMembership);
				}
			}
		}*/
	}
	
	@GlobalCommand
	@NotifyChange({"employeeEmergencyContacts"})
	public void refreshAfterSaveOrUpdate(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeMemberships = employeeService.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
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

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public MembershipListItemRenderer getMembershipListItemRenderer() {
		return membershipListItemRenderer;
	}

	public void setMembershipListItemRenderer(MembershipListItemRenderer membershipListItemRenderer) {
		this.membershipListItemRenderer = membershipListItemRenderer;
	}

	public List<TrsEmployeeMembership> getEmployeeMemberships() {
		return employeeMemberships;
	}

	public void setEmployeeMemberships(List<TrsEmployeeMembership> employeeMemberships) {
		this.employeeMemberships = employeeMemberships;
	}

	public TrsEmployeeMembership getSelectedEmployeeMembership() {
		return selectedEmployeeMembership;
	}

	public void setSelectedEmployeeMembership(TrsEmployeeMembership selectedEmployeeMembership) {
		this.selectedEmployeeMembership = selectedEmployeeMembership;
	}
}