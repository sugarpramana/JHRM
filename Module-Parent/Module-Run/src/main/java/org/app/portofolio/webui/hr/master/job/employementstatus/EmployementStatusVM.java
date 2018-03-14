package org.app.portofolio.webui.hr.master.job.employementstatus;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.job.employementstatus.model.MstEmployementStatusListItemRenderer;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.service.JobService;
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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class EmployementStatusVM {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxEmployementStatus")
	private Listbox listboxEmployementStatus;
	
	@Wire("#pagingEmployementStatus")
	private Paging pagingEmployementStatus;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstEmployementStatus mstEmployementStatus;
	private List<MstEmployementStatus> employementStatus;
	@WireVariable
	private JobService jobService;
	private ListitemRenderer<MstEmployementStatus> listitemRenderer;
	
	private HashMap<String, Object> hashMapJobTitle;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxEmployementStatus.setCheckmark(true);
		listboxEmployementStatus.setMultiple(true);
		listboxEmployementStatus.setStyle("border-style: none;");
		listboxEmployementStatus.setMold("paging");
		
		int count = jobService.getCountAllMstEmployementStatus();
		
		pagingEmployementStatus.setTotalSize(count);
		pagingEmployementStatus.setDetailed(true);
		pagingEmployementStatus.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingEmployementStatus.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapJobTitle = new HashMap<String, Object>();
		hashMapJobTitle.put("firstResult", refreshActivePage);
		hashMapJobTitle.put("maxResults", pagingEmployementStatus.getPageSize());
		
		employementStatus = jobService.getMstEmployementStatusPaging(hashMapJobTitle);
		listitemRenderer = new MstEmployementStatusListItemRenderer();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		doPrepareList();
		refreshPageList(startPageNumber);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("employementStatus")
	public void doFilter(){
		employementStatus.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("employementStatusName", getName);
			employementStatus = jobService.getByMstEmployementStatusRequestMap(hashMap);
			listitemRenderer = new MstEmployementStatusListItemRenderer();
		}
	}
	
	@Command
	@NotifyChange("employementStatus")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listboxEmployementStatus.getModel();
		listModelList.add(0, new MstEmployementStatus());
	}
	
	@Command
	public void doDelete(){
		final ListModelList<MstEmployementStatus> listModelListEmploymentStatus = (ListModelList) listboxEmployementStatus.getModel();
		
		if(listboxEmployementStatus.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstEmployementStatus employmentStatus: listModelListEmploymentStatus){
			 				if(listModelListEmploymentStatus.isSelected(employmentStatus)){
			 					jobService.delete(employmentStatus);
			 				}
			 			}
			 			
			 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
			 		}else{
			 			return;
			 		}
			 	}
			});
		}
	}

	@Command
	@NotifyChange("employementStatus")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("employementStatus")
	public void refreshAfterSaveOrUpdate(){
		employementStatus = jobService.getAllMstEmployementStatus();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstEmployementStatus getMstEmployementStatus() {
		return mstEmployementStatus;
	}

	public void setMstEmployementStatus(MstEmployementStatus mstEmployementStatus) {
		this.mstEmployementStatus = mstEmployementStatus;
	}

	public List<MstEmployementStatus> getEmployementStatus() {
		return employementStatus;
	}

	public void setEmployementStatus(List<MstEmployementStatus> employementStatus) {
		this.employementStatus = employementStatus;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public ListitemRenderer<MstEmployementStatus> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstEmployementStatus> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}