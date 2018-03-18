package org.app.portofolio.webui.hr.transaction.recruitment.vacancy;

import java.util.List;

import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.transaction.recruitment.vacancy.validator.TrsJobVacancyFormValidator;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.EmployeeService;
import org.module.hr.service.JobService;
import org.module.hr.service.RecruitmentService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class RecruitmentVacancyDialogVM {
	
	/*----------- zul ----------*/
	@Wire("#windowVacancyDialog")
	private Window windowVacancyDialog;
	
	@Wire("#comboboxJobTitle")
	private Combobox comboboxJobTitle;
	
	@Wire("#textboxVacancyName")
	private Textbox textboxVacancyName;
	
	@Wire("#comboboxHiringManager")
	private Combobox comboboxHiringManager;
	
	@Wire("#textboxNumberOfPositions")
	private Textbox textboxNumberOfPositions;
	
	@Wire("#textboxDescription")
	private Textbox textboxDescription;
	
	@Wire("#buttonSaveVacancy")
	private Button buttonSaveVacancy;
	
	@Wire("#buttonSaveAndNewVacancy")
	private Button buttonSaveAndNewVacancy;
	
	@Wire("#buttonEditVacancy")
	private Button buttonEditVacancy;
	
	/*----------- Services -----------*/
	@WireVariable
	private JobService jobService;
	
	@WireVariable
	private RecruitmentService recruitmentService;
	
	@WireVariable
	private EmployeeService employeeService;
	
	/*----------- Bean -----------*/
	private TrsJobVacancyFormValidator formValidator = new TrsJobVacancyFormValidator();
	private List<MstJobtitle> listJobtitle;
	private TrsJobVacancy trsJobVacancy;
	private List<TrsEmployee> hiringManagerList;
	private ModalAction action;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
			@ExecutionArgParam("object") Object object,
			@ExecutionArgParam(ArgKey.MODAL_ACTION_KEY) ModalAction action,
			@ExecutionArgParam(ArgKey.SELECTED_TRANSACTION_JOB_VACANCY) TrsJobVacancy selectedJobVacancy) {
		Selectors.wireComponents(component, this, false);
		
		this.action = action;
		switch(action) {
			case NEW : 
				this.formAddCondition();
			break;
			case DETAIL : 
				this.formDetailCondition();
				trsJobVacancy = selectedJobVacancy;
			break;
		}
		
		listJobtitle = jobService.getAllMstJobtitles();
		hiringManagerList = employeeService.getAllTrsEmployees();		
	}

	/**
	 * 
	 */
	private void formAddCondition() {
		ComponentConditionUtil.visibleButton(buttonEditVacancy, buttonSaveAndNewVacancy);
		ComponentConditionUtil.invisibleButton(buttonEditVacancy);
		trsJobVacancy = new TrsJobVacancy();
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSaveVacancy, buttonSaveAndNewVacancy);
		ComponentConditionUtil.visibleButton(buttonEditVacancy);
		ComponentConditionUtil.disableCombobox(comboboxJobTitle,comboboxHiringManager);
		ComponentConditionUtil.disableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxDescription);
	}
	
	@Command
	public void doEdit() {
		ComponentConditionUtil.invisibleButton(buttonEditVacancy);
		ComponentConditionUtil.visibleButton(buttonSaveVacancy);
		ComponentConditionUtil.enableCombobox(comboboxJobTitle, comboboxHiringManager);
		ComponentConditionUtil.enableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxDescription);
	}
	
	@Command
	public void doSave(){
		switch(action) {
			case NEW : 
				recruitmentService.save(trsJobVacancy);
			break;
			case DETAIL : 
				recruitmentService.update(trsJobVacancy);
			break;
		}
		BindUtils.postGlobalCommand(null, null, "refreshTrsJobVacancyList", null);
		Messagebox.show("Success !");
		windowVacancyDialog.detach();
	}
	
	@Command
	@NotifyChange("trsJobVacancy")
	public void doSaveAndNew() {
		recruitmentService.save(trsJobVacancy);
		
		BindUtils.postGlobalCommand(null, null, "refreshTrsJobVacancyList", null);
		trsJobVacancy = new TrsJobVacancy();
		Messagebox.show("Success !");
	}
	
	
	
	/* ---------- GETTER-SETTER --------------*/
	public List<MstJobtitle> getListJobtitle() {
		return listJobtitle;
	}
	
	public void setListJobtitle(List<MstJobtitle> listJobtitle) {
		this.listJobtitle = listJobtitle;
	}
		
	public TrsJobVacancy getTrsJobVacancy() {
		return trsJobVacancy;
	}
	
	public void setTrsJobVacancy(TrsJobVacancy trsJobVacancy) {
		this.trsJobVacancy = trsJobVacancy;
	}
	
	public List<TrsEmployee> getHiringManagerList() {
		return hiringManagerList;
	}
	
	public void setHiringManagerList(List<TrsEmployee> hiringManagerList) {
		this.hiringManagerList = hiringManagerList;
	}
	
	public TrsJobVacancyFormValidator getFormValidator(){
		return formValidator;
	}
}
