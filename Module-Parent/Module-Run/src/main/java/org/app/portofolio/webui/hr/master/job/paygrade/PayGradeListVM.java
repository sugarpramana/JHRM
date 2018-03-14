package org.app.portofolio.webui.hr.master.job.paygrade;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstPaygrade;
import org.module.hr.service.JobService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;

public class PayGradeListVM {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listboxPayGrade")
	private Listbox listboxPayGrade;
	
	@Wire("#pagingPayGrade")
	private Paging pagingPayGrade;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstPaygrade mstPaygrade;
	private List<MstPaygrade> mstPaygrades;
	@WireVariable
	private JobService jobService;
	
	private HashMap<String, Object> hashMapPayGrade;
	
	private int startPageNumber = 0;
	private int pageSize = 10;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxPayGrade.setCheckmark(true);
		listboxPayGrade.setMultiple(true);
		listboxPayGrade.setRows(5);
		listboxPayGrade.setStyle("border-style: none;");
		listboxPayGrade.setMold("paging");
		
		int count = jobService.getCountMstPaygrades();

		pagingPayGrade.setTotalSize(count);
		pagingPayGrade.setDetailed(true);
		pagingPayGrade.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingPayGrade.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapPayGrade = new HashMap<String, Object>();
		hashMapPayGrade.put("firstResult", refreshActivePage);
		hashMapPayGrade.put("maxResults", pagingPayGrade.getPageSize());
		
		mstPaygrades = jobService.getMstPaygradePaging(hashMapPayGrade);
		System.out.println("List Size >>>"+mstPaygrades.size());
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstPaygrade") MstPaygrade mstPaygrade) {
		
		Selectors.wireComponents(component, this, false);
		
		doPrepareList();
		refreshPageList(startPageNumber);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void doNew(){
		Executions.createComponents("/WEB-INF/pages/module_hr/master/job/paygrade/payGradeDialog.zul", null, null);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstPaygrade getMstPaygrade() {
		return mstPaygrade;
	}

	public void setMstPaygrade(MstPaygrade mstPaygrade) {
		this.mstPaygrade = mstPaygrade;
	}

	public List<MstPaygrade> getMstPaygrades() {
		return mstPaygrades;
	}

	public void setMstPaygrades(List<MstPaygrade> mstPaygrades) {
		this.mstPaygrades = mstPaygrades;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
}