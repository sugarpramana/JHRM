package org.app.portofolio.webui.hr.master.organization.generalinformation;

import java.util.List;

import org.module.hr.model.MstGeneralInformation;
import org.module.hr.service.OrganizationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

public class GeneralInformationVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstGeneralInformation mstGeneralInformation;
	private List<MstGeneralInformation> generalInformations;
	@WireVariable
	private OrganizationService organizationService;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstGeneralInformation") MstGeneralInformation mstGeneralInformation) {
		
		Selectors.wireComponents(component, this, false);

		generalInformations = organizationService.getAllMstGeneralInformations();
		
		for(MstGeneralInformation generalInformation : generalInformations){
			this.mstGeneralInformation = generalInformation;
		}
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doEdit(){
		
	}
	
	@Command
	public void doSave(){
		if(mstGeneralInformation.getIdGeneralInformation()== null){
			System.out.println("doSave");
			
			organizationService.save(mstGeneralInformation);
			Messagebox.show("doSave");
		}else{
			System.out.println("doUpdate");
			
			organizationService.saveOrUpdate(mstGeneralInformation);
			Messagebox.show("doUpdate");
		}
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstGeneralInformation getMstGeneralInformation() {
		return mstGeneralInformation;
	}

	public void setMstGeneralInformation(MstGeneralInformation mstGeneralInformation) {
		this.mstGeneralInformation = mstGeneralInformation;
	}

	public List<MstGeneralInformation> getGeneralInformations() {
		return generalInformations;
	}

	public void setGeneralInformations(
			List<MstGeneralInformation> generalInformations) {
		this.generalInformations = generalInformations;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
}