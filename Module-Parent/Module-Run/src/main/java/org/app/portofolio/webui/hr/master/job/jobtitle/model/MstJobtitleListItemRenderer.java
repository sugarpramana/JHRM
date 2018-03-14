package org.app.portofolio.webui.hr.master.job.jobtitle.model;

import org.module.hr.model.MstJobtitle;
import org.module.hr.service.JobService;
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

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MstJobtitleListItemRenderer implements ListitemRenderer<MstJobtitle>{
	
	private JobService jobService = (JobService) SpringUtil.getBean("jobService");		
	
	@Override
	public void render(Listitem item, final MstJobtitle mstJobtitle, int index) throws Exception {
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
        final Label labelNote = new Label();		
        final Label labelDescription = new Label();
        
        final Textbox textboxName = new Textbox();
        final Textbox textboxDescription = new Textbox();
        final Textbox textboxNote = new Textbox();
        	
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
			textboxDescription.setParent(listcell); 
			labelDescription.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
			textboxNote.setParent(listcell); 
			labelNote.setParent(listcell);
		listcell.setParent(item);
		
		if(mstJobtitle.getIdJobTitle() == null){
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);
		}else{
        	buttonSave.setVisible(false);
        	buttonCancel.setVisible(false);
        	buttonDelete.setVisible(false);
        	
        	labelName.setValue(mstJobtitle.getJobName());
        	labelDescription.setValue(mstJobtitle.getJobDescription());
        	labelNote.setValue(mstJobtitle.getJobNote());
        	
        	textboxName.setVisible(false);
        	textboxDescription.setVisible(false);
        	textboxNote.setVisible(false);
		}
		
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if(mstJobtitle.getIdJobTitle() == null){
					mstJobtitle.setJobName(textboxName.getValue());
					mstJobtitle.setJobDescription(textboxDescription.getValue());
					mstJobtitle.setJobNote(textboxNote.getValue());

					jobService.save(mstJobtitle);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}else{
					mstJobtitle.setJobName(textboxName.getValue());
					mstJobtitle.setJobDescription(textboxDescription.getValue());
					mstJobtitle.setJobNote(textboxNote.getValue());
					
					jobService.update(mstJobtitle);
					
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
				textboxDescription.setVisible(true);
				textboxNote.setVisible(true);
				
				labelName.setVisible(false);
				labelDescription.setVisible(false);
				labelNote.setVisible(false);
				
				textboxName.setValue(mstJobtitle.getJobName());
				textboxDescription.setValue(mstJobtitle.getJobDescription());
				textboxNote.setValue(mstJobtitle.getJobNote());
			}					
		});
		
		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
				    public void onEvent(Event event) throws Exception {    	
				 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {

				 			jobService.delete(mstJobtitle);
				 			
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