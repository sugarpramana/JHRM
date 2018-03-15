package org.app.portofolio.webui.hr.transaction.leave.parameter.workweek;

import java.util.LinkedHashMap;
import java.util.Map;
import org.app.portofolio.common.zul.util.Enum.DayType;
import org.module.hr.model.MstWorkWeek;
import org.module.hr.service.LeaveService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class WorkWeekVM {

    private Map<String,Integer> workWeekList;
    private Boolean isEdit;
    private DayType[] dayType;
    
    @WireVariable
    private LeaveService leaveService;
    
    @AfterCompose
    public void setupComponents(@ContextParam(ContextType.VIEW) Component component) throws Exception {

        Selectors.wireComponents(component, this, false);
        
        workWeekList = new LinkedHashMap<>();
        isEdit = false;
        //dayType = DayType.values();
        
        initLoadWorkWeekData();
    }

    public void initLoadWorkWeekData() throws Exception{
       /* for(MstWorkWeek obj : leaveService.getAllWorkWeek()){
            workWeekList.put(obj.getWorkdayName(), obj.getDayType());
        }*/
    }
    
    @Command
    @NotifyChange("isEdit")
    public void doEdit(){
        isEdit = true;
    }
    
    @Command
    @NotifyChange("isEdit")
    public void doSave() throws Exception{
        //leaveService.updateAllWorkWeek(workWeekList);
        isEdit = false;
        initLoadWorkWeekData();
    }
    
    public Map<String, Integer> getWorkWeekList() {
        return workWeekList;
    }

    public void setWorkWeekList(Map<String, Integer> workWeekList) {
        this.workWeekList = workWeekList;
    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }

    public DayType[] getDayType() {
        return dayType;
    }
    
    
}
