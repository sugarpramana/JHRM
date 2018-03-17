package org.app.portofolio.webui.hr.transaction.leave.entitlement;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsEntitlement;
import org.module.hr.service.LeaveService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;

public class LeaveEntitlementListVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listboxLeaveEntitlement")
	private Listbox listboxLeaveEntitlement;
	
	@Wire("#pagingLeaveEntitlement")
	private Paging pagingLeaveEntitlement;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEntitlement trsEntitlement;
	private List<TrsEntitlement> trsEntitlements;
	@WireVariable
	private LeaveService leaveService;
	
	private HashMap<String, Object> hashMapTrsEntitlement;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxLeaveEntitlement.setCheckmark(true);
		listboxLeaveEntitlement.setMultiple(true);
		listboxLeaveEntitlement.setRows(5);
		listboxLeaveEntitlement.setStyle("border-style: none;");
		listboxLeaveEntitlement.setMold("paging");
		
		int count = leaveService.getCountTrsEntitlements();

		pagingLeaveEntitlement.setTotalSize(count);
		pagingLeaveEntitlement.setDetailed(true);
		pagingLeaveEntitlement.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingLeaveEntitlement.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapTrsEntitlement = new HashMap<String, Object>();
		hashMapTrsEntitlement.put("firstResult", refreshActivePage);
		hashMapTrsEntitlement.put("maxResults", pagingLeaveEntitlement.getPageSize());
		
		trsEntitlements = leaveService.getTrsEntitlementPaging(hashMapTrsEntitlement);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("trsEntitlement") TrsEntitlement trsEntitlement) {
		
		Selectors.wireComponents(component, this, false);
		
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew(){
		Executions.createComponents("/WEB-INF/pages/module_hr/transaction/leave/leave_entitlement/leaveEntitlementDialog.zul", null, null);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public TrsEntitlement getTrsEntitlement() {
		return trsEntitlement;
	}

	public void setTrsEntitlement(TrsEntitlement trsEntitlement) {
		this.trsEntitlement = trsEntitlement;
	}

	public List<TrsEntitlement> getTrsEntitlements() {
		return trsEntitlements;
	}

	public void setTrsEntitlements(List<TrsEntitlement> trsEntitlements) {
		this.trsEntitlements = trsEntitlements;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
}