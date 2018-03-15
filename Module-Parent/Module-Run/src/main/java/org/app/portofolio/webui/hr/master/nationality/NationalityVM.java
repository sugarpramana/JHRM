package org.app.portofolio.webui.hr.master.nationality;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.nationality.model.NationalityListItemRenderer;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstNationality;
import org.module.hr.service.NationalityService;
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
public class NationalityVM {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxnNationality")
	private Listbox listboxNationality;
	
	@Wire("#pagingNationality")
	private Paging pagingNationality;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstNationality mstNationality;
	private List<MstNationality> mstNationalities;
	@WireVariable
	private NationalityService nationalityService;
	private ListitemRenderer<MstNationality> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstNationality;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxNationality.setCheckmark(true);
		listboxNationality.setMultiple(true);
		listboxNationality.setStyle("border-style: none;");
		listboxNationality.setMold("paging");
		
		int count = nationalityService.getCountMstNationalities();

		pagingNationality.setTotalSize(count);
		pagingNationality.setDetailed(true);
		pagingNationality.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingNationality.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstNationality = new HashMap<String, Object>();
		hashMapMstNationality.put("firstResult", refreshActivePage);
		hashMapMstNationality.put("maxResults", pagingNationality.getPageSize());
		
		mstNationalities = nationalityService.getMstNationalityPaging(hashMapMstNationality);
		listitemRenderer = new NationalityListItemRenderer();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstNationality") MstNationality mstNationality) {
		
		Selectors.wireComponents(component, this, false);

		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("mstNationalities")
	public void doFilter(){
		mstNationalities.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("nameNationality", getName);
			mstNationalities = nationalityService.getByRequestMap(hashMap);
			listitemRenderer = new NationalityListItemRenderer();
		}
	}
	
	@Command
	@NotifyChange("mstNationalities")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}

	@Command
	public void doNew(){
		final ListModelList<MstJobtitle> listModelListJobtitle = (ListModelList) listboxNationality.getModel();
		listModelListJobtitle.add(0, new MstJobtitle());
	}

	@Command
	public void doDelete(){
		final ListModelList<MstNationality> listModelListJobtitle = (ListModelList) listboxNationality.getModel();
		
		if(listboxNationality.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstNationality mstNationality: listModelListJobtitle){
			 				if(listModelListJobtitle.isSelected(mstNationality)){
			 					nationalityService.delete(mstNationality);
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
	@NotifyChange({"mstNationalities", "mstJobtitleListItemRenderer"})
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("mstNationalities")
	public void refreshAfterSaveOrUpdate(){
		mstNationalities = nationalityService.getAllMstNationality();
	}
	

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstNationality getMstNationality() {
		return mstNationality;
	}

	public void setMstNationality(MstNationality mstNationality) {
		this.mstNationality = mstNationality;
	}

	public List<MstNationality> getMstNationalities() {
		return mstNationalities;
	}

	public void setMstNationalities(List<MstNationality> mstNationalities) {
		this.mstNationalities = mstNationalities;
	}

	public NationalityService getNationalityService() {
		return nationalityService;
	}

	public void setNationalityService(NationalityService nationalityService) {
		this.nationalityService = nationalityService;
	}

	public ListitemRenderer<MstNationality> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(
			ListitemRenderer<MstNationality> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}