package org.app.portofolio.webui.hr.transaction.leave.parameter.type;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.transaction.leave.parameter.type.model.MstLeaveTypeListitemRenderer;
import org.module.hr.model.MstLeaveType;
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
public class LeaveTypeVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxLeaveType")
	private Listbox listboxLeaveType;
	
	@Wire("#pagingLeaveType")
	private Paging pagingLeaveType;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstLeaveType mstLeaveType;
	private List<MstLeaveType> leaveTypes;
	@WireVariable
	private LeaveService leaveService;
	private ListitemRenderer<MstLeaveType> listitemRenderer;
	
	private HashMap<String, Object> hashMapLeaveType;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxLeaveType.setCheckmark(true);
		listboxLeaveType.setMultiple(true);
		listboxLeaveType.setStyle("border-style: none;");
		listboxLeaveType.setMold("paging");
		
		int count = leaveService.getCountMstLeaveTypes();

		pagingLeaveType.setTotalSize(count);
		pagingLeaveType.setDetailed(true);
		pagingLeaveType.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingLeaveType.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapLeaveType = new HashMap<String, Object>();
		hashMapLeaveType.put("firstResult", refreshActivePage);
		hashMapLeaveType.put("maxResults", pagingLeaveType.getPageSize());
		
		leaveTypes = leaveService.getMstLeaveTypePaging(hashMapLeaveType);
		listitemRenderer = new MstLeaveTypeListitemRenderer();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstLeaveType") MstLeaveType mstLeaveType) {
		
		Selectors.wireComponents(component, this, false);

		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("leaveTypes")
	public void doFilter(){
		leaveTypes.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("leaveTypeName", getName);
			leaveTypes = leaveService.getByMstLeaveTypeRequestMap(hashMap);
			listitemRenderer = new MstLeaveTypeListitemRenderer();
		}
	}
	
	@Command
	@NotifyChange("leaveTypes")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}

	@Command
	public void doNew(){
		final ListModelList<MstLeaveType> listModelListLeaveType = (ListModelList) listboxLeaveType.getModel();
		listModelListLeaveType.add(0, new MstLeaveType());
	}
	
	@Command
	public void doDelete(){
		final ListModelList<MstLeaveType> listModelListMstLeaveType = (ListModelList) listboxLeaveType.getModel();
		
		if(listboxLeaveType.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstLeaveType mstLeaveType: listModelListMstLeaveType){
			 				if(listModelListMstLeaveType.isSelected(mstLeaveType)){
			 					leaveService.delete(mstLeaveType);
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
	@NotifyChange("leaveTypes")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("leaveTypes")
	public void refreshAfterSaveOrUpdate(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstLeaveType getMstLeaveType() {
		return mstLeaveType;
	}

	public void setMstLeaveType(MstLeaveType mstLeaveType) {
		this.mstLeaveType = mstLeaveType;
	}

	public List<MstLeaveType> getLeaveTypes() {
		return leaveTypes;
	}

	public void setLeaveTypes(List<MstLeaveType> leaveTypes) {
		this.leaveTypes = leaveTypes;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public ListitemRenderer<MstLeaveType> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstLeaveType> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}