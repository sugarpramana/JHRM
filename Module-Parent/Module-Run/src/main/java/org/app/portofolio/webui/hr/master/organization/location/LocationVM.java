package org.app.portofolio.webui.hr.master.organization.location;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.module.hr.model.MstLocation;
import org.module.hr.service.OrganizationService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LocationVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxLocation")
	private Listbox listboxLocation;
	
	@Wire("#pagingLocation")
	private Paging pagingLocation;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstLocation mstLocation;
	private List<MstLocation> mstLocations;
	@WireVariable
	private OrganizationService organizationService;
	
	private HashMap<String, Object> hashMapLocation;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxLocation.setCheckmark(true);
		listboxLocation.setMultiple(true);
		listboxLocation.setStyle("border-style: none;");
		listboxLocation.setMold("paging");
		
		int count = organizationService.getCountMstLocations();
		
		pagingLocation.setTotalSize(count);
		pagingLocation.setDetailed(true);
		pagingLocation.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingLocation.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapLocation = new HashMap<String, Object>();
		hashMapLocation.put("firstResult", refreshActivePage);
		hashMapLocation.put("maxResults", pagingLocation.getPageSize());
		
		mstLocations = organizationService.getMstLocationPaging(hashMapLocation);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstLocation") MstLocation mstLocation) {
		
		Selectors.wireComponents(component, this, false);

		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("mstLocations")
	public void doFilter(){
		mstLocations.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("name", getName);
			mstLocations = organizationService.getByMstLocationRequestMap(hashMap);
		}
	}
	
	@Command
	@NotifyChange("mstLocations")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}

	@Command
	public void doNew(){
		Executions.createComponents("/WEB-INF/pages/module_hr/master/organization/location/locationDialog.zul", null, null);
	}

	@Command
	public void doDelete(){
		final ListModelList<MstLocation> listModelListLocation = (ListModelList) listboxLocation.getModel();
		
		if(listboxLocation.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstLocation mstLocation: listModelListLocation){
			 				if(listModelListLocation.isSelected(mstLocation)){
			 					organizationService.delete(mstLocation);
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
	@NotifyChange("mstLocations")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@Command
	public void doDetail(){
		/*HashMap<K, V> K = Key, V = Value*/
		HashMap<String, Object> arg = new HashMap<String, Object>();
		arg.put("mstLocation", mstLocation);
		Executions.createComponents("/WEB-INF/pages/module_hr/master/organization/location/locationDialog.zul", null, arg);
	}
	
	@GlobalCommand
	@NotifyChange("mstLocations")
	public void refreshAfterSaveOrUpdate(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstLocation getMstLocation() {
		return mstLocation;
	}

	public void setMstLocation(MstLocation mstLocation) {
		this.mstLocation = mstLocation;
	}

	public List<MstLocation> getMstLocations() {
		return mstLocations;
	}

	public void setMstLocations(List<MstLocation> mstLocations) {
		this.mstLocations = mstLocations;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
}