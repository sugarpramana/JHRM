package org.app.portofolio.webui.hr.master.qualification.skill;

import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.app.portofolio.webui.hr.master.qualification.skill.model.SkillListItemRenderer;
import org.module.hr.model.MstSkill;
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
public class SkillVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxSkill")
	private Listbox listboxSkill;
	
	@Wire("#pagingSkill")
	private Paging pagingSkill;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstSkill mstSkill;
	private List<MstSkill> skills;
	@WireVariable
	private QualificationService qualificationService;
	private ListitemRenderer<MstSkill> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstSkill;
	
	private int startPageNumber = 0;
	private int pageSize = 10;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxSkill.setCheckmark(true);
		listboxSkill.setMultiple(true);
		listboxSkill.setStyle("border-style: none;");
		listboxSkill.setMold("paging");
		
		int count = qualificationService.getCountMstEducations();
		
		pagingSkill.setTotalSize(count);
		pagingSkill.setDetailed(true);
		pagingSkill.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingSkill.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstSkill = new HashMap<String, Object>();
		hashMapMstSkill.put("firstResult", refreshActivePage);
		hashMapMstSkill.put("maxResults", pagingSkill.getPageSize());
		
		skills = qualificationService.getMstSkillPaging(hashMapMstSkill);
		listitemRenderer = new SkillListItemRenderer();
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
	@NotifyChange("skills")
	public void doFilter(){
		skills.clear();
        
		String getName = textboxFilter.getValue();
		
		if(getName == null || "".equals(getName)) {
			doPrepareList();
			refreshPageList(startPageNumber);
		} else {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("nameSkill", getName);
			skills = qualificationService.getByMstSkillRequestMap(hashMap);
			listitemRenderer = new SkillListItemRenderer();
		}
	}
	
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listboxSkill.getModel();
		listModelList.add(0,  new MstSkill());
	}

	@Command
	public void doDelete(){
		final ListModelList<MstSkill> listModelListSkills = (ListModelList) listboxSkill.getModel();
		
		if(listboxSkill.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstSkill skill : listModelListSkills){
			 				if(listModelListSkills.isSelected(skill)){
			 					qualificationService.delete(skill);
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
	@NotifyChange("skills")
	public void doRefresh(){
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	@Command
	public void doPrint() throws JRException{

	}
	
	@GlobalCommand
	@NotifyChange("skills")
	public void refreshAfterSaveOrUpdate(){
		skills = qualificationService.getAllMstSkill();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstSkill getMstSkill() {
		return mstSkill;
	}

	public void setMstSkill(MstSkill mstSkill) {
		this.mstSkill = mstSkill;
	}

	public List<MstSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<MstSkill> skills) {
		this.skills = skills;
	}

	public QualificationService getQualificationService() {
		return qualificationService;
	}

	public void setQualificationService(QualificationService qualificationService) {
		this.qualificationService = qualificationService;
	}

	public ListitemRenderer<MstSkill> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstSkill> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}
}