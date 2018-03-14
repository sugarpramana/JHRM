package org.app.portofolio.webui.hr.master.job.jobcategory;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.job.jobcategory.model.MstJobCategoryListItemRenderer;
import org.module.hr.model.MstJobCategory;
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

@SuppressWarnings({ "rawtypes", "unchecked" })
public class JobCategoryVM {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxJobCategory")
	private Listbox listboxJobCategory;
	
	@Wire("#pagingJobCategory")
	private Paging pagingJobCategory;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstJobCategory mstJobCategory;
	private List<MstJobCategory> mstJobCategories;
	@WireVariable
	private JobService jobService;
	private ListitemRenderer<MstJobCategory> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstJobCategory;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxJobCategory.setCheckmark(true);
		listboxJobCategory.setMultiple(true);
		listboxJobCategory.setStyle("border-style: none;");
		listboxJobCategory.setMold("paging");
		
		int count = jobService.getCountMstJobtitles();

		pagingJobCategory.setTotalSize(count);
		pagingJobCategory.setDetailed(true);
		pagingJobCategory.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingJobCategory.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstJobCategory = new HashMap<String, Object>();
		hashMapMstJobCategory.put("firstResult", refreshActivePage);
		hashMapMstJobCategory.put("maxResults", pagingJobCategory.getPageSize());
		
		mstJobCategories = jobService.getMstJobCategoryPaging(hashMapMstJobCategory);
		listitemRenderer = new MstJobCategoryListItemRenderer();
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
	@NotifyChange("mstJobCategories")
	public void doFilter(){
		mstJobCategories.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("jobCategoryName", getName);
			mstJobCategories = jobService.getByMstJobCategoryRequestMap(hashMap);
			listitemRenderer = new MstJobCategoryListItemRenderer();
		}
	}
	
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listboxJobCategory.getModel();
		listModelList.add(0, new MstJobCategory());
	}

	@Command
	public void doDelete(){
		final ListModelList<MstJobCategory> listModelListLicenses = (ListModelList) listboxJobCategory.getModel();
		
		if(listboxJobCategory.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstJobCategory jobCategory: listModelListLicenses){
			 				if(listModelListLicenses.isSelected(jobCategory)){
			 					jobService.delete(jobCategory);
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
	@NotifyChange("mstJobCategories")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("mstJobCategories")
	public void refreshAfterSaveOrUpdate(){
		mstJobCategories = jobService.getAllMstJobCategories();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstJobCategory getMstJobCategory() {
		return mstJobCategory;
	}

	public void setMstJobCategory(MstJobCategory mstJobCategory) {
		this.mstJobCategory = mstJobCategory;
	}

	public List<MstJobCategory> getMstJobCategories() {
		return mstJobCategories;
	}

	public void setMstJobCategories(List<MstJobCategory> mstJobCategories) {
		this.mstJobCategories = mstJobCategories;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public ListitemRenderer<MstJobCategory> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(
			ListitemRenderer<MstJobCategory> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}