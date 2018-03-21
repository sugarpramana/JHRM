package org.app.portofolio.webui.hr.transaction.employee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class EmployeeDialog {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#buttonSave")
	private Button buttonSave;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonNew")
	private Button buttonNew;
	
	@Wire("#textBoxFirstName")
	private Textbox textboxFirstName;
	
	@Wire("#textBoxMiddleName")
	private Textbox textBoxMiddleName;
	
	@Wire("#textBoxLastName")
	private Textbox textBoxLastName;
	
	@Wire("#textBoxIdEmployee")
	private Textbox textBoxIdEmployee;
	
	@Wire("#buttonUpload")
	private Button buttonUpload;
	
	private Media media;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private String labelUploadFoto;
	
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private void formEditCondition() {
		ComponentConditionUtil.enableButton(buttonSave, buttonUpload);
		ComponentConditionUtil.disableButton(buttonEdit, buttonNew);
		ComponentConditionUtil.enableTextbox(textboxFirstName, textBoxIdEmployee, textBoxLastName, textBoxMiddleName);
	}
	
	private void formSaveCondition() {
		ComponentConditionUtil.disableButton(buttonSave, buttonUpload);
		ComponentConditionUtil.enableButton(buttonEdit, buttonNew);
		ComponentConditionUtil.disableTextbox(textboxFirstName, textBoxIdEmployee, textBoxLastName, textBoxMiddleName);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		this.trsEmployee = new TrsEmployee();
		labelUploadFoto = "Select Foto";
		
		formEditCondition();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command("upload")
	@NotifyChange("labelUploadFoto")
	public void upload(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) {
		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
		
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
		}
		
		if (upEvent != null) {
			this.media = upEvent.getMedia();
			int lengthofImage = media.getByteData().length;
			
			if (media instanceof AImage) {
				if (lengthofImage > 500 * 1024) {
					Messagebox.show("Please Select a Image of size less than 500Kb.");
					return;
				} else {
					labelUploadFoto = this.media.getName();
				}
			} else {
				Messagebox.show("The selected File is not an image.");
			}
		} else {
			Messagebox.show("Upload Event Is not Coming");
		}
	}
	
	@Command
	public void doEdit() {
		formEditCondition();
	}
	
	@Command
	@NotifyChange("trsEmployee")
	public void doNew() {
		formEditCondition();
		this.trsEmployee = new TrsEmployee();
	}

	@Command
	public void doSave() {
		if (this.media == null) {
			Messagebox.show("Fotonya mana coy");
		} else {
			String type = this.media.getContentType().split("/")[0];
			if (type.equals("image")) {
				saveFile(this.media);
			}
		}
		
		if (trsEmployee.getIdEmployee() == null){
			employeeService.save(this.trsEmployee);
		} else {
			employeeService.saveOrUpdate(trsEmployee);
		}
		
		formSaveCondition();
	}

	private void saveFile(Media media) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			InputStream fin = media.getStreamData();
			in = new BufferedInputStream(fin);
			String source = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/images/employee");

			File file = new File(source + media.getName());

			OutputStream fout = new FileOutputStream(file);
			out = new BufferedOutputStream(fout);
			
			byte buffer[] = new byte[1024];
			int ch = in.read(buffer);
			
			while (ch != -1) {
				out.write(buffer, 0, ch);
				ch = in.read(buffer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getLabelUploadFoto() {
		return labelUploadFoto;
	}

	public void setLabelUploadFoto(String labelUploadFoto) {
		this.labelUploadFoto = labelUploadFoto;
	}
}