package org.app.portofolio.webui.hr.master.qualification.license;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.qualification.license.model.LicenseListItemRenderer;
import org.module.hr.model.MstLicense;
import org.module.hr.service.QualificationService;
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
public class LicenseVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxLicense")
	private Listbox listboxLicense;
	
	@Wire("#pagingLicense")
	private Paging pagingLicense;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstLicense mstLicense;
	private List<MstLicense> licenses;
	@WireVariable
	private QualificationService qualificationService;
	private ListitemRenderer<MstLicense> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstEducation;
	
	private int startPageNumber = 0;
	private int pageSize = 10;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxLicense.setCheckmark(true);
		listboxLicense.setMultiple(true);
		listboxLicense.setStyle("border-style: none;");
		listboxLicense.setMold("paging");
		
		int count = qualificationService.getCountMstLicenses();
		
		pagingLicense.setTotalSize(count);
		pagingLicense.setDetailed(true);
		pagingLicense.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingLicense.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstEducation = new HashMap<String, Object>();
		hashMapMstEducation.put("firstResult", refreshActivePage);
		hashMapMstEducation.put("maxResults", pagingLicense.getPageSize());
		
		licenses = qualificationService.getMstLicensePaging(hashMapMstEducation);
		listitemRenderer = new LicenseListItemRenderer();
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
	@NotifyChange("licenses")
	public void doFilter(){
		licenses.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("nameLicense", getName);
			licenses = qualificationService.getByMstLicenseRequestMap(hashMap);
			listitemRenderer = new LicenseListItemRenderer();
		}
	}
	
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listboxLicense.getModel();
		listModelList.add(0, new MstLicense());
	}

	@Command
	public void doDelete(){
		final ListModelList<MstLicense> listModelListLicenses = (ListModelList) listboxLicense.getModel();
		
		if(listboxLicense.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstLicense license : listModelListLicenses){
			 				if(listModelListLicenses.isSelected(license)){
			 					qualificationService.delete(license);
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
	@NotifyChange("licenses")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("licenses")
	public void refreshAfterSaveOrUpdate(){
		licenses = qualificationService.getAllMstLicense();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstLicense getMstLicense() {
		return mstLicense;
	}

	public void setMstLicense(MstLicense mstLicense) {
		this.mstLicense = mstLicense;
	}

	public List<MstLicense> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<MstLicense> licenses) {
		this.licenses = licenses;
	}

	public QualificationService getQualificationService() {
		return qualificationService;
	}

	public void setQualificationService(QualificationService qualificationService) {
		this.qualificationService = qualificationService;
	}

	public ListitemRenderer<MstLicense> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstLicense> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}