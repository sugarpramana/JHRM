package org.app.portofolio.webui.hr.transaction.leave.parameter.holiday;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.transaction.leave.parameter.holiday.model.MstHolidayListitemRenderer;
import org.module.hr.model.MstHoliday;
import org.module.hr.service.LeaveService;
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
public class HolidayVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxHoliday")
	private Listbox listboxHoliday;
	
	@Wire("#pagingHoliday")
	private Paging pagingHoliday;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstHoliday mstHoliday;
	private List<MstHoliday> mstHolidays;
	@WireVariable
	private LeaveService leaveService;
	private ListitemRenderer<MstHoliday> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstHoliday;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxHoliday.setCheckmark(true);
		listboxHoliday.setMultiple(true);
		listboxHoliday.setStyle("border-style: none;");
		listboxHoliday.setMold("paging");
		
		int count = leaveService.getCountMstHolidays();

		pagingHoliday.setTotalSize(count);
		pagingHoliday.setDetailed(true);
		pagingHoliday.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingHoliday.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstHoliday = new HashMap<String, Object>();
		hashMapMstHoliday.put("firstResult", refreshActivePage);
		hashMapMstHoliday.put("maxResults", pagingHoliday.getPageSize());
		
		mstHolidays = leaveService.getMstHolidayPaging(hashMapMstHoliday);
		listitemRenderer = new MstHolidayListitemRenderer();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstHoliday") MstHoliday mstHoliday) {
		
		Selectors.wireComponents(component, this, false);

		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("mstHolidays")
	public void doFilter(){
		mstHolidays.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("holidayName", getName);
			mstHolidays = leaveService.getByMstHolidayRequestMap(hashMap);
			listitemRenderer = new MstHolidayListitemRenderer();
		}
	}
	
	@Command
	@NotifyChange("mstHolidays")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}

	@Command
	public void doNew(){
		final ListModelList<MstHoliday> listModelListMstHoliday = (ListModelList) listboxHoliday.getModel();
		listModelListMstHoliday.add(0, new MstHoliday());
	}
	
	@Command
	public void doDelete(){
		final ListModelList<MstHoliday> listModelListMstHoliday = (ListModelList) listboxHoliday.getModel();
		
		if(listboxHoliday.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstHoliday mstHoliday: listModelListMstHoliday){
			 				if(listModelListMstHoliday.isSelected(mstHoliday)){
			 					leaveService.delete(mstHoliday);
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
	@NotifyChange("mstHolidays")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("mstHolidays")
	public void refreshAfterSaveOrUpdate(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstHoliday getMstHoliday() {
		return mstHoliday;
	}

	public void setMstHoliday(MstHoliday mstHoliday) {
		this.mstHoliday = mstHoliday;
	}

	public List<MstHoliday> getMstHolidays() {
		return mstHolidays;
	}

	public void setMstHolidays(List<MstHoliday> mstHolidays) {
		this.mstHolidays = mstHolidays;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public ListitemRenderer<MstHoliday> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstHoliday> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}