package org.app.portofolio.webui.hr.master.organization.location;

import java.util.List;

import org.module.hr.model.MstLocation;
import org.module.hr.service.OrganizationService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

public class LocationDialogVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstLocation mstLocation;
	private List<MstLocation> mstLocations;
	
	@WireVariable
	private OrganizationService organizationService;
	
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstLocation") MstLocation mstLocation) {
		
		Selectors.wireComponents(component, this, false);
		
		if(mstLocation == null){
			this.mstLocation = new MstLocation();
		}else{
			/*Jika Dalam Posisi Edit*/
			this.mstLocation = mstLocation; 
		}
	}
	
	@Command
	public void doClose(){
		System.out.println("doClose");
		BindUtils.postGlobalCommand(null, null, "refreshAfterClose", null);
	}
	
	@Command
	public void doSave(){
		/*Tidak Perlu Menginisialisasikan New Object, Karena sudah dilakukan di AfterCompose*/
		if(mstLocation.getIdLocation() == null){
			System.out.println("doSave");
			
			organizationService.save(mstLocation);
			Messagebox.show("doSave");
			
			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
		}else{
			System.out.println("doUpdate");
			
			organizationService.saveOrUpdate(mstLocation);
			Messagebox.show("doUpdate");
			
			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
		}
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