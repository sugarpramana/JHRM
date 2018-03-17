package org.app.portofolio.webui.hr.transaction.leave.parameter.period;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.module.hr.model.MstLeavePeriod;
import org.module.hr.service.LeaveService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

public class LeavePeriodVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#dateboxStart")
	private Datebox dateboxStart;
	
	@Wire("#dateboxEnd")
	private Datebox dateboxEnd;
	
	@Wire("#labelCurrent")
	private Label labelCurrent;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstLeavePeriod mstLeavePeriod;
	private List<MstLeavePeriod> mstLeavePeriods;
	@WireVariable
	private LeaveService leaveService;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstLeavePeriod") MstLeavePeriod mstLeavePeriod) {
		
		Selectors.wireComponents(component, this, false);
		
		mstLeavePeriods = leaveService.getAllMstLeavePeriods();
		
		for(MstLeavePeriod period : mstLeavePeriods){
			this.mstLeavePeriod = period;
		}
	}
    
    @Command
    public void doOK(@ContextParam(ContextType.TRIGGER_EVENT) InputEvent event){
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateboxStart.getValue();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, -1);

        Date dateConvert = calendar.getTime();

        dateboxEnd.setText(dateFormat.format(dateConvert));
        labelCurrent.setValue(dateFormat.format(date)+" to "+dateFormat.format(dateboxEnd.getValue()));
    }
    
    @Command
	public void doSave(){
		if(mstLeavePeriod.getIdLeavePeriod() == null){
			System.out.println("doSave");
			
			leaveService.save(mstLeavePeriod);
			Messagebox.show("doSave");
		}else{
			System.out.println("doUpdate");
			
			leaveService.saveOrUpdate(mstLeavePeriod);
			Messagebox.show("doUpdate");
		}
	}

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstLeavePeriod getMstLeavePeriod() {
		return mstLeavePeriod;
	}

	public void setMstLeavePeriod(MstLeavePeriod mstLeavePeriod) {
		this.mstLeavePeriod = mstLeavePeriod;
	}

	public List<MstLeavePeriod> getMstLeavePeriods() {
		return mstLeavePeriods;
	}

	public void setMstLeavePeriods(List<MstLeavePeriod> mstLeavePeriods) {
		this.mstLeavePeriods = mstLeavePeriods;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
}