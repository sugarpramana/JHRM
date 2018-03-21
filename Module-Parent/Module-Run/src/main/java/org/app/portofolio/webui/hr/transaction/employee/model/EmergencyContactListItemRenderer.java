package org.app.portofolio.webui.hr.transaction.employee.model;

import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
*
* @author formulateko@admin.com
*/
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EmergencyContactListItemRenderer implements ListitemRenderer<TrsEmployeeEmergencyContact> {

	private EmployeeService employeeService = (EmployeeService) SpringUtil.getBean("employeeService");

	@Override
	public void render(Listitem item, final TrsEmployeeEmergencyContact trsEmployeeEmergencyContact, int index) throws Exception {
		Listcell listcell;

		final Button buttonSave = new Button();
		buttonSave.setImage("/images/icons/btn_save.gif");

		final Button buttonEdit = new Button();
		buttonEdit.setImage("/images/icons/btn_edit.gif");

		final Button buttonDelete = new Button();
		buttonDelete.setImage("/images/icons/btn_delete.gif");

		final Button buttonCancel = new Button();
		buttonCancel.setImage("/images/icons/btn_cancel.gif");
		
		final Label labelName = new Label();
		final Label labelRelationship = new Label();
		final Label labelHomeTelephone = new Label();
		final Label labelMobile = new Label();
		final Label labelWorkTelephone = new Label();
		
		final Textbox textboxName = new Textbox();
		final Textbox textboxRelationship = new Textbox();
		final Textbox textboxHomeTelephone = new Textbox();
		final Textbox textboxMobile = new Textbox();
		final Textbox textboxWorkTelephone = new Textbox();
		
		listcell = new Listcell();
			buttonEdit.setParent(listcell);
			buttonSave.setParent(listcell);
			buttonCancel.setParent(listcell);
			buttonDelete.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxName.setParent(listcell);
			labelName.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxRelationship.setParent(listcell);
			labelRelationship.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxHomeTelephone.setParent(listcell);
			labelHomeTelephone.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxMobile.setParent(listcell);
			labelMobile.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxWorkTelephone.setParent(listcell);
			labelWorkTelephone.setParent(listcell);
		listcell.setParent(item);
		
		if (trsEmployeeEmergencyContact.getIdEmployeeEmergencyContact() == null){
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);
		} else {
			buttonSave.setVisible(false);
			buttonCancel.setVisible(false);
			buttonDelete.setVisible(false);
			
			labelName.setValue(trsEmployeeEmergencyContact.getName());
			labelRelationship.setValue(trsEmployeeEmergencyContact.getRelationship());
			labelHomeTelephone.setValue(trsEmployeeEmergencyContact.getHomeTelephone());;
			labelMobile.setValue(trsEmployeeEmergencyContact.getMobile());
			labelWorkTelephone.setValue(trsEmployeeEmergencyContact.getWorkTelephone());
			
			textboxName.setVisible(false);
			textboxRelationship.setVisible(false);
			textboxHomeTelephone.setVisible(false);
			textboxMobile.setVisible(false);
			textboxWorkTelephone.setVisible(false);
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * Function CRUD Event
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if(trsEmployeeEmergencyContact.getIdEmployeeEmergencyContact() == null){
					trsEmployeeEmergencyContact.setName(textboxName.getValue());
					trsEmployeeEmergencyContact.setRelationship(textboxRelationship.getValue());
					trsEmployeeEmergencyContact.setHomeTelephone(textboxHomeTelephone.getValue());
					trsEmployeeEmergencyContact.setMobile(textboxMobile.getValue());
					trsEmployeeEmergencyContact.setWorkTelephone(textboxWorkTelephone.getValue());
	
					employeeService.save(trsEmployeeEmergencyContact);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmergencyContact", null);
				}else{
					trsEmployeeEmergencyContact.setName(textboxName.getValue());
					trsEmployeeEmergencyContact.setRelationship(textboxRelationship.getValue());
					trsEmployeeEmergencyContact.setHomeTelephone(textboxHomeTelephone.getValue());
					trsEmployeeEmergencyContact.setMobile(textboxMobile.getValue());
					trsEmployeeEmergencyContact.setWorkTelephone(textboxWorkTelephone.getValue());;
	
					employeeService.update(trsEmployeeEmergencyContact);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmergencyContact", null);
				}
			}
		});
		
		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {		
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);
				
				textboxName.setVisible(true);
				textboxRelationship.setVisible(true);
				textboxHomeTelephone.setVisible(true);
				textboxMobile.setVisible(true);
				textboxWorkTelephone.setVisible(true);
				
				labelName.setVisible(false);
				labelRelationship.setVisible(false);
				labelHomeTelephone.setVisible(false);
				labelMobile.setVisible(false);
				labelWorkTelephone.setVisible(false);
				
				textboxName.setValue(trsEmployeeEmergencyContact.getName());
				textboxRelationship.setValue(trsEmployeeEmergencyContact.getRelationship());
				textboxHomeTelephone.setValue(trsEmployeeEmergencyContact.getHomeTelephone());
				textboxMobile.setValue(trsEmployeeEmergencyContact.getMobile());
				textboxWorkTelephone.setValue(trsEmployeeEmergencyContact.getWorkTelephone());
			}					
		});
		
		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
				    public void onEvent(Event event) throws Exception {    	
				 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
	
				 			employeeService.delete(trsEmployeeEmergencyContact);
				 			
				 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmergencyContact", null);
				 		}else{
				 			return;
				 		}
				 	}
				});
			}
		});
		
		buttonCancel.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdateEmergencyContact", null);
			}
		});
	}
}