package org.app.portofolio.webui.hr.master.organization.structure;

import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.organization.structure.model.StructureTreeitemRenderer;
import org.module.hr.model.MstSubUnit;
import org.module.hr.service.OrganizationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.TreeNode;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.event.PagingEvent;

public class StructureVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstSubUnit mstSubUnit;
	private List<MstSubUnit> subUnits;
	@WireVariable
	private OrganizationService organizationService;
	private TreeitemRenderer<MstSubUnit> listitemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		
	}
	
	private void refreshPageList(int refreshActivePage) {
		
	}

	TreeModel<TreeNode<MstSubUnit>> treeModel;
	public TreeModel<TreeNode<MstSubUnit>> getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(TreeModel<TreeNode<MstSubUnit>> treeModel) {
		this.treeModel = treeModel;
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstSubUnit") MstSubUnit mstSubUnit) {
		
		Selectors.wireComponents(component, this, false);
		
		/*subUnits = organizationService.getAllMstSubUnitts();
		listitemRenderer = new StructureTreeitemRenderer();
		
		System.out.println(subUnits.size());
		System.out.println(listitemRenderer);*/
		
		//subUnits = organizationService.getAllMstSubUnitts();
		this.mstSubUnit = new MstSubUnit();
		this.mstSubUnit.setIdSubUnit(1);
		TreeNode<MstSubUnit> treeNode = new DefaultTreeNode<MstSubUnit>(this.mstSubUnit);
		treeModel = new DefaultTreeModel<MstSubUnit>(treeNode);
		
		System.out.println(treeNode);
		System.out.println(treeModel);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doFilter(){
		
	}
	
	@Command
	@NotifyChange("mstNationalities")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){

	}

	@Command
	public void doNew(){
		
	}

	@GlobalCommand
	public void refreshAfterSaveOrUpdate(){
		
	}
	
	@Command
	public void doDelete(){

	}
	
	@Command
	public void doRefresh(){
		
	}
	
	@Command
	public void doPrint() throws JRException{

	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstSubUnit getMstSubUnit() {
		return mstSubUnit;
	}

	public void setMstSubUnit(MstSubUnit mstSubUnit) {
		this.mstSubUnit = mstSubUnit;
	}
	
	public List<MstSubUnit> getSubUnits() {
		return subUnits;
	}

	public void setSubUnits(List<MstSubUnit> subUnits) {
		this.subUnits = subUnits;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public TreeitemRenderer<MstSubUnit> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(TreeitemRenderer<MstSubUnit> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}