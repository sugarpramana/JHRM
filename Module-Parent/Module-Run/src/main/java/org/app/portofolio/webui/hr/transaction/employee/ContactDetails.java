package org.app.portofolio.webui.hr.transaction.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.transaction.employee.model.DummyNationalityItemRender;
import org.app.portofolio.webui.hr.transaction.employee.validator.TrsEmployeeContactDetailsFormValidator;
import org.module.hr.model.MstNationality;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.ImmutableFields;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;

/**
*
* @author formulateko@admin.com
*/
public class ContactDetails {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listBoxCountry")
	private Listbox listBoxCountry;

	@Wire("#bandBoxNationality")
	private Bandbox bandBoxNationality;
	
	@Wire("#textBoxAddressStreet1")
	private Textbox textBoxAddressStreet1;
	
	@Wire("#textBoxAddressStreet2")
	private Textbox textBoxAddressStreet2;
	
	@Wire("#textBoxCity")
	private Textbox textBoxCity;
	
	@Wire("#textBoxProvince")
	private Textbox textBoxProvince;
	
	@Wire("#textBoxZip")
	private Textbox textBoxZip;
	
	@Wire("#textBoxHomeTelephone")
	private Textbox textBoxHomeTelephone;
	
	@Wire("#textBoxMobile")
	private Textbox textBoxMobile;
	
	@Wire("#textBoxWorkTelephone")
	private Textbox textBoxWorkTelephone;
	
	@Wire("#textBoxWorkEmail")
	private Textbox textBoxWorkEmail;
	
	@Wire("#textBoxOtherEmail")
	private Textbox textBoxOtherEmail;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonSave")
	private Button buttonSave;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private TrsEmployee trsEmployee;
	@WireVariable
	private EmployeeService employeeService;

	private MstNationality selectedNationality;
	private List<MstNationality> nationalities;
	private ListitemRenderer<MstNationality> listitemRenderer;
	
	private TrsEmployeeContactDetailsFormValidator formValidator = new TrsEmployeeContactDetailsFormValidator();

	private String countryKeySearch;
	private Boolean isEdit;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private void formEditCondition() {
		ComponentConditionUtil.visibleButton(buttonSave);
		ComponentConditionUtil.invisibleButton(buttonEdit);
		ComponentConditionUtil.enableBandBox(bandBoxNationality);
		ComponentConditionUtil.enableTextbox(textBoxAddressStreet1, textBoxAddressStreet2, textBoxCity, textBoxHomeTelephone, textBoxMobile, textBoxOtherEmail, textBoxProvince, textBoxWorkEmail, textBoxWorkTelephone, textBoxZip);
	}

	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSave);
		ComponentConditionUtil.visibleButton(buttonEdit);
		ComponentConditionUtil.disableTextbox(textBoxAddressStreet1, textBoxAddressStreet2, textBoxCity, textBoxHomeTelephone, textBoxMobile, textBoxOtherEmail, textBoxProvince, textBoxWorkEmail, textBoxWorkTelephone, textBoxZip);
		ComponentConditionUtil.disableBandBox(bandBoxNationality);
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		
		Selectors.wireComponents(component, this, false);
		
		this.trsEmployee = trsEmployee;
		formDetailCondition();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void search() {
		for (MstNationality mstNationality : nationalities) {
			if (mstNationality.getNameNationality().contains(countryKeySearch)) {
				nationalities.clear();
				nationalities.add(mstNationality);
				break;
			}
		}
		
		listBoxCountry.setModel(new ListModelList<MstNationality>(nationalities));
	}
	
	@Command
	public void doEdit(){
		formEditCondition();
	}
	
	@Command
	@NotifyChange("isEdit")
	public void doSave(){
		employeeService.update(trsEmployee);
		formDetailCondition();
	}

	@Command
	public void openBandBoxNationality() {
		// dummy data Nasionality
		nationalities = new ArrayList<MstNationality>();
		MstNationality nationality;
		
		for (int i = 1; i < 5; i++) {
			nationality = new MstNationality();
			nationality.setIdNationality(i);
			nationality.setNameNationality("Nationality " + i);
			nationalities.add(nationality);
		}
		
		listitemRenderer = new DummyNationalityItemRender();
		listBoxCountry.setModel(new ListModelList<MstNationality>(nationalities));
		listBoxCountry.setItemRenderer(listitemRenderer);
	}
	
	public void setSelectedNationality(MstNationality selectedNationality) {
		this.selectedNationality = selectedNationality;
		trsEmployee.setCountry(selectedNationality.getNameNationality());
		bandBoxNationality.setValue(trsEmployee.getCountry());
		bandBoxNationality.close();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@ImmutableFields
	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public String getCountryKeySearch() {
		return countryKeySearch;
	}

	public void setCountryKeySearch(String countryKeySearch) {
		this.countryKeySearch = countryKeySearch;
	}

	public Listbox getListBoxCountry() {
		return listBoxCountry;
	}

	public void setListBoxCountry(Listbox listBoxCountry) {
		this.listBoxCountry = listBoxCountry;
	}

	public List<MstNationality> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<MstNationality> nationalities) {
		this.nationalities = nationalities;
	}

	public MstNationality getSelectedNationality() {
		return selectedNationality;
	}

	public Bandbox getBandBoxNationality() {
		return bandBoxNationality;
	}

	public void setBandBoxNationality(Bandbox bandBoxNationality) {
		this.bandBoxNationality = bandBoxNationality;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public TrsEmployeeContactDetailsFormValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(TrsEmployeeContactDetailsFormValidator formValidator) {
		this.formValidator = formValidator;
	}
}