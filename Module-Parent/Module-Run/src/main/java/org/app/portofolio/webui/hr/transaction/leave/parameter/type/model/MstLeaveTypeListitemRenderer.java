package org.app.portofolio.webui.hr.transaction.leave.parameter.type.model;

import org.module.hr.model.MstLeaveType;
import org.module.hr.service.LeaveService;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MstLeaveTypeListitemRenderer implements ListitemRenderer<MstLeaveType>{
	
	private LeaveService leaveService = (LeaveService) SpringUtil.getBean("leaveService");		
	
	@Override
	public void render(Listitem item, final MstLeaveType mstLeaveType, int index) throws Exception {
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
        final Label labelIsSituational = new Label();		
        
        final Textbox textboxName = new Textbox();
        final Checkbox checkboxIsSituational = new Checkbox();
        	
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
			checkboxIsSituational.setParent(listcell); 
			labelIsSituational.setParent(listcell);
		listcell.setParent(item);
		
		if(mstLeaveType.getIdLeaveType() == null){
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);
		}else{
        	buttonSave.setVisible(false);
        	buttonCancel.setVisible(false);
        	buttonDelete.setVisible(false);
        	
        	labelName.setValue(mstLeaveType.getLeaveTypeName());
        	labelIsSituational.setValue(String.valueOf(mstLeaveType.getIsSituational()));
        	
        	textboxName.setVisible(false);
        	checkboxIsSituational.setVisible(false);
		}
		
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if(mstLeaveType.getIdLeaveType() == null){
					mstLeaveType.setLeaveTypeName(textboxName.getValue());
					mstLeaveType.setIsSituational(checkboxIsSituational.isChecked());

					leaveService.save(mstLeaveType);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}else{
					mstLeaveType.setLeaveTypeName(textboxName.getValue());
					mstLeaveType.setIsSituational(checkboxIsSituational.isChecked());

					leaveService.update(mstLeaveType);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}
			}
		});
		
		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {		
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);
				
				textboxName.setVisible(true);
				checkboxIsSituational.setVisible(true);
				
				labelName.setVisible(false);
				labelIsSituational.setVisible(false);
				
				textboxName.setValue(mstLeaveType.getLeaveTypeName());
				checkboxIsSituational.setValue(mstLeaveType.getIsSituational());
			}					
		});
		
		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
				    public void onEvent(Event event) throws Exception {    	
				 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {

				 			leaveService.delete(mstLeaveType);
				 			
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