/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.portofolio.webui.hr.transaction.leave.model;

import java.util.List;
import org.module.hr.model.MstLeaveType;
import org.module.hr.service.LeaveService;
import org.module.hr.service.NationalityService;
import org.zkoss.bind.BindUtils;
import org.zkoss.util.resource.Labels;
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

/**
 *
 * @author achmadsy
 */
public class LeaveListitemRenderer implements ListitemRenderer<MstLeaveType> {

    LeaveService leaveService = (LeaveService) SpringUtil.getBean("leaveService");

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
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
        labelName.setStyle("text-decoration:underline;");

        final Label labelMandatory = new Label();
        labelMandatory.setValue(" *");
        labelMandatory.setStyle("color:red;");

        final Label labelError = new Label();
        labelError.setStyle("color:red;");

        final Textbox textboxName = new Textbox();

        final Checkbox checkbox = new Checkbox();

        listcell = new Listcell();
        buttonEdit.setParent(listcell);
        buttonSave.setParent(listcell);
        buttonCancel.setParent(listcell);
        buttonDelete.setParent(listcell);
        listcell.setParent(item);

        listcell = new Listcell();
        textboxName.setParent(listcell);
        labelMandatory.setParent(listcell);
        labelError.setParent(listcell);
        labelName.setParent(listcell);
        listcell.setParent(item);

        listcell = new Listcell();
        checkbox.setParent(listcell);
        listcell.setParent(item);

        if (mstLeaveType.getIdLeaveType() == null) {
            buttonEdit.setVisible(false);
            buttonDelete.setVisible(false);
            checkbox.setDisabled(false);
        } else {
            buttonSave.setVisible(false);
            buttonCancel.setVisible(false);
            buttonDelete.setVisible(false);

            labelName.setValue(mstLeaveType.getLeaveTypeName());
            checkbox.setChecked(mstLeaveType.getIsSituational());
            checkbox.setDisabled(true);

            textboxName.setVisible(false);
            labelMandatory.setVisible(false);
            labelError.setVisible(false);
        }

        buttonSave.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                if (textboxName.getValue() != null
                        && !textboxName.getValue().equals("")) {
                    mstLeaveType.setLeaveTypeName(textboxName.getValue());
                    mstLeaveType.setIsSituational(checkbox.isChecked());

                    //leaveService.saveOrUpdateMstLeaveType(mstLeaveType);

                    BindUtils.postGlobalCommand(null, null, "refreshMstLeaveTypeAfterSaveOrUpdate", null);
                } else {
                    labelError.setValue(Labels.getLabel("menu.common.validator.isnotempty"));
                }
            }
        });

        buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
            public void onEvent(Event event) throws Exception {
                buttonEdit.setVisible(false);
                buttonSave.setVisible(true);
                buttonDelete.setVisible(true);

                textboxName.setVisible(true);

                labelMandatory.setVisible(true);
                labelError.setVisible(true);

                labelName.setVisible(false);

                checkbox.setDisabled(false);

                textboxName.setValue(mstLeaveType.getLeaveTypeName());

                checkbox.setChecked(mstLeaveType.getIsSituational());
            }
        });

        buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
            @Override
            public void onEvent(Event event) throws Exception {
                Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
                    public void onEvent(Event event) throws Exception {
                        if (((Integer) event.getData()).intValue() == Messagebox.OK) {

                            //leaveService.deleteMstLeaveType(mstLeaveType);

                            BindUtils.postGlobalCommand(null, null, "refreshMstLeaveTypeAfterSaveOrUpdate", null);
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
                BindUtils.postGlobalCommand(null, null, "refreshMstLeaveTypeAfterSaveOrUpdate", null);
            }
        });
    }

}
