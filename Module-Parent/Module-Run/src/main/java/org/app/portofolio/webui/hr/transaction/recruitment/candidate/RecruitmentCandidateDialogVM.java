package org.app.portofolio.webui.hr.transaction.recruitment.candidate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.transaction.recruitment.candidate.validator.TrsJobCandidateFormValidator;
//import org.module.api.common.ParameterKey;
import org.module.hr.model.TrsJobCandidate;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.EmployeeService;
import org.module.hr.service.RecruitmentService;
import org.module.hr.service.UploadFileService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class RecruitmentCandidateDialogVM {

	/*----------- zul ----------*/
	@Wire("#windowCandidateDialog")
	private Window windowCandidateDialog;
	
	@Wire("#buttonSaveCandidate")
	private Button buttonSaveCandidate;
	
	@Wire("#buttonSaveAndNewCandidate")
	private Button buttonSaveAndNewCandidate;
	
	@Wire("#buttonEditCandidate")
	private Button buttonEditCandidate;
	
	@Wire("#textboxResume")
	private Textbox textboxResume;
	
	/*----------- Services -----------*/
	@WireVariable
	private RecruitmentService recruitmentService;
	
	@WireVariable
	private EmployeeService employeeService;
	
	@WireVariable
	private UploadFileService uploadFileService;
	
	/*----------- Bean -----------*/
	private List<TrsJobVacancy> trsJobVacancies;
	private TrsJobCandidateFormValidator formValidator;
	private TrsJobCandidate trsJobCandidate;
	private ModalAction action;
	private HashMap<String, Object> settings;
	private File uploadFile;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
			@ExecutionArgParam("object") Object object,
			@ExecutionArgParam(ArgKey.MODAL_ACTION_KEY) ModalAction action) {
		Selectors.wireComponents(component, this, false);
		
		this.action = action;
		switch(action) {
			case NEW : this.formAddCondition();
			break;
			case DETAIL : this.formDetailCondition();
			break;
		}
		
		initComponents();
	}
	
	/**
	 * Initialisasi bean yang digunakan di dalam ViewModel
	 */
	private void initComponents() {
		trsJobCandidate = new TrsJobCandidate();
		trsJobVacancies = recruitmentService.getAllTrsJobVacancy();
		formValidator = new TrsJobCandidateFormValidator();
		this.settings = (HashMap<String, Object>) Sessions.getCurrent().getAttribute("setting");
	}

	/**
	 * 
	 */
	private void formAddCondition() {
		ComponentConditionUtil.visibleButton(buttonEditCandidate, buttonSaveAndNewCandidate);
		ComponentConditionUtil.invisibleButton(buttonEditCandidate);
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSaveCandidate, buttonSaveAndNewCandidate);
		ComponentConditionUtil.visibleButton(buttonEditCandidate);
	}
	
	@Command
	public void doSave() throws Exception{
		switch(action) {
			case NEW : 
				recruitmentService.save(trsJobCandidate);
			break;
			case DETAIL : 
				recruitmentService.update(trsJobCandidate);
			break;
		}
		
		FileInputStream fileInputStream = new FileInputStream(uploadFile);
		//uploadFileService.uploadResume(fileInputStream, settings.get(ParameterKey.KEY_SETTING_ROOT_PATH).toString(), trsJobCandidate);
		
		BindUtils.postGlobalCommand(null, null, "refreshAfterSaveCandidate", null);
		Messagebox.show("Success !");
		windowCandidateDialog.detach();
	}
	
	@Command
	public void doSaveNew() {
		
	}
	
	@Command
	public void doEdit() {
		ComponentConditionUtil.invisibleButton(buttonEditCandidate);
		ComponentConditionUtil.visibleButton(buttonSaveCandidate);
	}
	
	@Command
	public void doUpload(@ContextParam(ContextType.TRIGGER_EVENT) UploadEvent uploadEvent) throws FileNotFoundException, IOException {
		Media media = uploadEvent.getMedia(); 
		File file = new File(media.getName());
		
		if (media != null) {
			this.uploadFile = new File(file.getAbsolutePath());
			Files.copy(uploadFile, media.getStreamData());
			textboxResume.setValue(media.getName());
		}
	}
	
	
	/* ---------- GETTER-SETTER --------------*/
	public List<TrsJobVacancy> getTrsJobVacancies() {
		return trsJobVacancies;
	}
	
	public TrsJobCandidate getTrsJobCandidate() {
		return trsJobCandidate;
	}

	public void setTrsJobCandidate(TrsJobCandidate trsJobCandidate) {
		this.trsJobCandidate = trsJobCandidate;
	}

	public void setTrsJobVacancies(List<TrsJobVacancy> trsJobVacancies) {
		this.trsJobVacancies = trsJobVacancies;
	}
	
	public TrsJobCandidateFormValidator getFormValidator() {
		return formValidator;
	}
	
	public void setFormValidator(TrsJobCandidateFormValidator formValidator) {
		this.formValidator = formValidator;
	}
}
