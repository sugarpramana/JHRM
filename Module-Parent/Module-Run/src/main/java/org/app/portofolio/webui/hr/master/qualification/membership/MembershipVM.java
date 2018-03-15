package org.app.portofolio.webui.hr.master.qualification.membership;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.qualification.membership.model.MembershipListItemRenderer;
import org.module.hr.model.MstMembership;
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
public class MembershipVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxMembership")
	private Listbox listboxMembership;
	
	@Wire("#pagingMembership")
	private Paging pagingMembership;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstMembership mstMembership;
	private List<MstMembership> memberships;
	@WireVariable
	private QualificationService qualificationService;
	private ListitemRenderer<MstMembership> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstMembership;
	
	private int startPageNumber = 0;
	private int pageSize = 10;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxMembership.setCheckmark(true);
		listboxMembership.setMultiple(true);
		listboxMembership.setStyle("border-style: none;");
		listboxMembership.setMold("paging");
		
		int count = qualificationService.getCountMstEducations();
		
		pagingMembership.setTotalSize(count);
		pagingMembership.setDetailed(true);
		pagingMembership.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingMembership.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstMembership = new HashMap<String, Object>();
		hashMapMstMembership.put("firstResult", refreshActivePage);
		hashMapMstMembership.put("maxResults", pagingMembership.getPageSize());
		
		memberships = qualificationService.getMstMembershipPaging(hashMapMstMembership);
		listitemRenderer = new MembershipListItemRenderer();
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
	@NotifyChange("memberships")
	public void doFilter(){
		memberships.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("nameMembership", getName);
			memberships = qualificationService.getByMstMembershipRequestMap(hashMap);
			listitemRenderer = new MembershipListItemRenderer();
		}
	}
	
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listboxMembership.getModel();
		listModelList.add(0, new MstMembership());
	}

	@Command
	public void doDelete(){
		final ListModelList<MstMembership> listModelListMemberships = (ListModelList) listboxMembership.getModel();
		
		if(listboxMembership.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstMembership membership : listModelListMemberships){
			 				if(listModelListMemberships.isSelected(membership)){
			 					qualificationService.delete(membership);
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
	@NotifyChange("memberships")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("memberships")
	public void refreshAfterSaveOrUpdate(){
		memberships = qualificationService.getAllMstMembership();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstMembership getMstMembership() {
		return mstMembership;
	}

	public void setMstMembership(MstMembership mstMembership) {
		this.mstMembership = mstMembership;
	}

	public List<MstMembership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<MstMembership> memberships) {
		this.memberships = memberships;
	}

	public QualificationService getQualificationService() {
		return qualificationService;
	}

	public void setQualificationService(QualificationService qualificationService) {
		this.qualificationService = qualificationService;
	}

	public ListitemRenderer<MstMembership> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstMembership> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}