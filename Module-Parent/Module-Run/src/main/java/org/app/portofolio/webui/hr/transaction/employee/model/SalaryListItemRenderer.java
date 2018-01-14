package org.app.portofolio.webui.hr.transaction.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.license.model.LicenseListItemRenderer;
import org.module.hr.model.TrsEmployeeSalary;
import org.module.hr.model.dto.RelationshipType;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class SalaryListItemRenderer implements ListitemRenderer<TrsEmployeeSalary>{
	
	private EmployeeService employeeService = (EmployeeService) SpringUtil.getBean("employeeService");
	
	@SuppressWarnings("unchecked")
	@Override
	public void render(Listitem item, final TrsEmployeeSalary trsEmployeeSalary, int index) throws Exception{
		
		Listcell listcell;

		final Button buttonSave = new Button();
		buttonSave.setImage("/images/icons/btn_save.gif");

		final Button buttonEdit = new Button();
		buttonEdit.setImage("/images/icons/btn_edit.gif");

		final Button buttonDelete = new Button();
		buttonDelete.setImage("/images/icons/btn_delete.gif");

		final Button buttonCancel = new Button();
		buttonCancel.setImage("/images/icons/btn_cancel.gif");
		
		
		final Label labelPayGrade = new Label();
		final Label labelSalaryComponent = new Label();
		final Label labelPayFrequency = new Label();
		final Label labelCurrency = new Label();
		final Label labelAmount = new Label();
		final Label labelComment = new Label();
	
		final Combobox comboboxPayGrade = new Combobox();
		final Textbox textboxSalaryComponent = new Textbox();
		final Combobox comboboxPayFrequency = new Combobox();
		final Combobox comboboxCurrency = new Combobox();
		final Textbox textboxAmount = new Textbox();
		final Textbox textboxComment = new Textbox();
		
		listcell = new Listcell();
		buttonEdit.setParent(listcell);
		buttonSave.setParent(listcell);
		buttonCancel.setParent(listcell);
		buttonDelete.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		comboboxPayGrade.setParent(listcell);
		labelPayGrade.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxSalaryComponent.setParent(listcell);
		labelSalaryComponent.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		comboboxPayFrequency.setParent(listcell);
		labelPayFrequency.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		comboboxCurrency.setParent(listcell);
		labelCurrency.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxAmount.setParent(listcell);
		labelAmount.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxComment.setParent(listcell);
		textboxComment.setMultiline(true);
		textboxComment.setHeight("75px");
		labelComment.setParent(listcell);
		listcell.setParent(item);
		
		if (trsEmployeeSalary.getIdSalary() == null) {
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);

			comboboxCurrency.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//			comboboxCurrency.setItemRenderer(new RelationshipListItemRenderer());

			comboboxPayFrequency.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//			comboboxPayFrequency.setItemRenderer(new RelationshipListItemRenderer());
			
			comboboxPayGrade.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//			comboboxPayGrade.setItemRenderer(new RelationshipListItemRenderer());

		} else {
			buttonSave.setVisible(false);
			buttonCancel.setVisible(false);
			buttonDelete.setVisible(false);

//			RelationshipType dummyCurrency = employeeService
//					.getRelationshipTypeById(trsEmployeeSalary.getCurrency());
//			RelationshipType dummyPayFrequency = employeeService
//					.getRelationshipTypeById(Integer.parseInt(trsEmployeeSalary.getPayFrequency()));
//			RelationshipType dummyPayGrade = employeeService
//					.getRelationshipTypeById(Integer.parseInt(trsEmployeeSalary.getPayGrade()));
			
			labelAmount.setValue(trsEmployeeSalary.getAmount());
			labelComment.setValue(trsEmployeeSalary.getComment());
//			labelCurrency.setValue(dummyCurrency.getStpTypname());
//			labelPayFrequency.setValue(dummyPayFrequency.getStpTypname());
//			labelPayGrade.setValue(dummyPayGrade.getStpTypname());
			labelSalaryComponent.setValue(trsEmployeeSalary.getSalaryComponent());
			
			textboxAmount.setVisible(false);
			textboxComment.setVisible(false);
			comboboxCurrency.setVisible(false);
			comboboxPayFrequency.setVisible(false);
			comboboxPayGrade.setVisible(false);
			textboxSalaryComponent.setVisible(false);
			
		}
		
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				trsEmployeeSalary.setAmount(textboxAmount.getValue());
				trsEmployeeSalary.setComment(textboxComment.getValue());
				//trsEmployeeSalary.setCurrency(String.valueOf(comboboxCurrency.getSelectedIndex()));
				trsEmployeeSalary.setPayFrequency(String.valueOf(comboboxPayFrequency.getSelectedIndex()));
				//trsEmployeeSalary.setPayGrade(String.valueOf(comboboxPayGrade.getSelectedIndex()));
				trsEmployeeSalary.setSalaryComponent(textboxSalaryComponent.getValue());
				
				if (trsEmployeeSalary.getIdSalary() == null) {
//					employeeService.save(trsEmployeeImmigration);
					BindUtils.postGlobalCommand(null, null, "trsEmployeeDependents", null);
				} else {
//					employeeService.update(trsEmployeeImmigration);
					BindUtils.postGlobalCommand(null, null, "trsEmployeeDependents", null);
				}
			}
		});

		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);

				textboxAmount.setVisible(true);
				textboxComment.setVisible(true);
				comboboxCurrency.setVisible(true);
				comboboxPayFrequency.setVisible(true);
				comboboxPayGrade.setVisible(true);
				textboxSalaryComponent.setVisible(true);

				labelAmount.setVisible(false);
				labelComment.setVisible(false);
				labelCurrency.setVisible(false);
				labelPayFrequency.setVisible(false);
				labelPayGrade.setVisible(false);
				labelSalaryComponent.setVisible(false);

//				RelationshipType dummyCurrency = employeeService
//						.getRelationshipTypeById(Integer.parseInt(trsEmployeeSalary.getCurrency()));
//				RelationshipType dummyPayFrequency = employeeService
//						.getRelationshipTypeById(Integer.parseInt(trsEmployeeSalary.getPayFrequency()));
//				RelationshipType dummyPayGrade = employeeService
//						.getRelationshipTypeById(Integer.parseInt(trsEmployeeSalary.getPayGrade()));
//
//				comboboxCurrency.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//				comboboxCurrency.setItemRenderer(new RelationshipListItemRenderer());
//
//				comboboxPayFrequency.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//				comboboxPayFrequency.setItemRenderer(new RelationshipListItemRenderer());
//				
//				comboboxPayGrade.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
//				comboboxPayGrade.setItemRenderer(new RelationshipListItemRenderer());
				
				textboxAmount.setValue(trsEmployeeSalary.getAmount());
				textboxComment.setValue(trsEmployeeSalary.getComment());
//				comboboxCurrency.setValue(dummyCurrency.getStpTypname());
//				comboboxPayFrequency.setValue(dummyPayFrequency.getStpTypname());
//				comboboxPayGrade.setValue(dummyPayGrade.getStpTypname());
				textboxSalaryComponent.setValue(trsEmployeeSalary.getSalaryComponent());

			}
		});

		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL,
						Messagebox.EXCLAMATION, new EventListener() {
							public void onEvent(Event event) throws Exception {
								if (((Integer) event.getData()).intValue() == Messagebox.OK) {

//									employeeService.delete(trsEmployeeImmigration);

									BindUtils.postGlobalCommand(null, null, "b", null);
								} else {
									return;
								}
							}
						});
			}
		});

		buttonCancel.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				BindUtils.postGlobalCommand(null, null, "b", null);
			}
		});
	}
}
