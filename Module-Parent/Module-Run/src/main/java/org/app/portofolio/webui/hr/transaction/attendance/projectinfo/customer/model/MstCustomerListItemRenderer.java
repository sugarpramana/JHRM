package org.app.portofolio.webui.hr.transaction.attendance.projectinfo.customer.model;

import org.module.hr.model.MstCustomer;
import org.module.hr.service.AttendanceService;
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

public class MstCustomerListItemRenderer implements ListitemRenderer<MstCustomer>{
	
	private AttendanceService attendanceService = (AttendanceService) SpringUtil.getBean("attendanceService");		
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void render(Listitem item, final MstCustomer mstCustomer, int index) throws Exception {
		Listcell listcell;
		
		final Button buttonSave = new Button();
    		buttonSave.setImage("/images/icons/btn_save.gif");
		
		final Button buttonEdit = new Button();
			buttonEdit.setImage("/images/icons/btn_edit.gif");
			
		final Button buttonDelete = new Button();
        	buttonDelete.setImage("/images/icons/btn_delete.gif");
        
        final Button buttonCancel = new Button();
        	buttonCancel.setImage("/images/icons/btn_cancel.gif");
        	
        final Label labelCustomer = new Label();	
        final Label labelDescription = new Label();
        
        final Textbox textboxCustomer = new Textbox();
        final Textbox textboxDescription = new Textbox();
        	
        listcell = new Listcell();
        	buttonEdit.setParent(listcell); 
        	buttonSave.setParent(listcell); 
        	buttonCancel.setParent(listcell); 
        	buttonDelete.setParent(listcell); 
		listcell.setParent(item);
        
		listcell = new Listcell();
			textboxCustomer.setParent(listcell); 
			labelCustomer.setParent(listcell); 
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxDescription.setParent(listcell); 
			labelDescription.setParent(listcell); 
		listcell.setParent(item);

		if(mstCustomer.getIdCustomer() == null){
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);
		}else{
        	buttonSave.setVisible(false);
        	buttonCancel.setVisible(false);
        	buttonDelete.setVisible(false);
        	
        	labelCustomer.setValue(mstCustomer.getCustomerName());
        	labelDescription.setValue(mstCustomer.getCustomerDescription());
        	
        	textboxCustomer.setVisible(false);
        	textboxDescription.setVisible(false);
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * Function CRUD Event
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if(mstCustomer.getIdCustomer() == null){
					mstCustomer.setCustomerName(textboxCustomer.getValue());
					mstCustomer.setCustomerDescription(textboxDescription.getValue());

					attendanceService.save(mstCustomer);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}else{
					mstCustomer.setCustomerName(textboxCustomer.getValue());
					mstCustomer.setCustomerDescription(textboxDescription.getValue());

					attendanceService.update(mstCustomer);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}
			}
		});
		
		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {		
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);
				
				textboxCustomer.setVisible(true);
				textboxDescription.setVisible(true);
				
				labelCustomer.setVisible(false);
				labelDescription.setVisible(false);
				
				textboxCustomer.setValue(mstCustomer.getCustomerName());
				textboxDescription.setValue(mstCustomer.getCustomerDescription());
			}					
		});
		
		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
				    public void onEvent(Event event) throws Exception {    	
				 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {

				 			attendanceService.delete(mstCustomer);
				 			
				 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
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
				BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
			}
		});
	}
}