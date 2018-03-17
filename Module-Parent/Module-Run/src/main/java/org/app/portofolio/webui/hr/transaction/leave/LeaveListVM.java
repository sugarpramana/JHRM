package org.app.portofolio.webui.hr.transaction.leave;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsLeave;
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

public class LeaveListVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listboxLeave")
	private Listbox listboxLeave;
	
	@Wire("#pagingLeave")
	private Paging pagingLeave;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsLeave trsLeave;
	private List<TrsLeave> trsLeaves;
	@WireVariable
	private LeaveService leaveService;
	
	private HashMap<String, Object> hashMapTrsLeave;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxLeave.setCheckmark(true);
		listboxLeave.setMultiple(true);
		listboxLeave.setRows(5);
		listboxLeave.setStyle("border-style: none;");
		listboxLeave.setMold("paging");
		
		int count = leaveService.getCountTrsLeaves();

		pagingLeave.setTotalSize(count);
		pagingLeave.setDetailed(true);
		pagingLeave.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingLeave.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapTrsLeave = new HashMap<String, Object>();
		hashMapTrsLeave.put("firstResult", refreshActivePage);
		hashMapTrsLeave.put("maxResults", pagingLeave.getPageSize());
		
		trsLeaves = leaveService.getTrsLeavePaging(hashMapTrsLeave);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("trsLeave") TrsLeave trsLeave) {
		
		Selectors.wireComponents(component, this, false);
		
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew(){
		Executions.createComponents("/WEB-INF/pages/module_hr/transaction/leave/leave/leaveDialog.zul", null, null);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public TrsLeave getTrsLeave() {
		return trsLeave;
	}

	public void setTrsLeave(TrsLeave trsLeave) {
		this.trsLeave = trsLeave;
	}

	public List<TrsLeave> getTrsLeaves() {
		return trsLeaves;
	}

	public void setTrsLeaves(List<TrsLeave> trsLeaves) {
		this.trsLeaves = trsLeaves;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
}