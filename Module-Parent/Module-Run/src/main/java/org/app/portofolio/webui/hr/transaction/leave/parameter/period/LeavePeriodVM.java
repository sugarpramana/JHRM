package org.app.portofolio.webui.hr.transaction.leave.parameter.period;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.SerializationUtils;
import org.module.hr.model.MstLeavePeriod;
import org.module.hr.service.LeaveService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class LeavePeriodVM {

    private List<MstLeavePeriod> mstLeavePeriodList, mstLeavePeriodAfterList = new ArrayList<>();
    private MstLeavePeriod mstLeavePeriod, mstLeavePeriodTemp, mstLeavePeriodBefore, mstLeavePeriodAfter;
    private String currentLeavePeriod;
    private Map<String, Integer> monthList;
    private Map<String, Integer> dateList;
    private Boolean readOnly;
    private Calendar cal;

    // service
    @WireVariable
    private LeaveService leaveService;

    @AfterCompose
    public void setupComponents(@ContextParam(ContextType.VIEW) Component component) throws Exception {

        Selectors.wireComponents(component, this, false);

        doInit();
    }

    @NotifyChange("*")
    private void doInit() throws Exception {

        mstLeavePeriodList = null;// = leaveService.getAllLeavePeriod();
        if (mstLeavePeriodList != null
                && mstLeavePeriodList.size() > 0) {
            //karena dia insertnya yg current dan juga tahun kedepannya 
            for (MstLeavePeriod obj : mstLeavePeriodList) {
                Calendar fromDate = Calendar.getInstance(), toDate = Calendar.getInstance();
                fromDate.setTime(obj.getFromDate());
                toDate.setTime(obj.getToDate());
                if (Calendar.getInstance().getTime().after(fromDate.getTime())
                        && Calendar.getInstance().getTime().before(toDate.getTime())) {
                    mstLeavePeriod = obj;
                } else if (Calendar.getInstance().getTime().before(fromDate.getTime())
                        && Calendar.getInstance().getTime().before(toDate.getTime())) {
                    mstLeavePeriodAfterList.add(obj);
                } else if (Calendar.getInstance().getTime().after(fromDate.getTime())
                        && Calendar.getInstance().getTime().after(toDate.getTime())) {
                    if (mstLeavePeriodBefore != null) {
                        if (obj.getToDate().after(mstLeavePeriodBefore.getToDate())) {
                            mstLeavePeriodBefore = obj;
                        }
                    } else {
                        mstLeavePeriodBefore = obj;
                    }
                }
            }
            if(mstLeavePeriod != null){
                if(mstLeavePeriodAfterList.size() == 1){
                    mstLeavePeriodAfter = mstLeavePeriodAfterList.get(0);
                }
            } else {
                for(MstLeavePeriod obj : mstLeavePeriodAfterList){
                    if(mstLeavePeriod != null){
                        if(obj.getFromDate().before(mstLeavePeriod.getFromDate())){
                            mstLeavePeriod = obj;
                        }
                    } else {
                        mstLeavePeriod = obj;
                    }
                }
                for(MstLeavePeriod obj : mstLeavePeriodAfterList){
                    if(obj.getFromDate().after(mstLeavePeriod.getFromDate())){
                        mstLeavePeriodAfter = obj;
                    }
                }
            }
            currentLeavePeriod = getStrLeavePeriod(mstLeavePeriod);
        } else {
            mstLeavePeriod = new MstLeavePeriod();
            currentLeavePeriod = "-";
        }

        mstLeavePeriodTemp = (MstLeavePeriod) SerializationUtils.clone(mstLeavePeriod);
        cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mstLeavePeriod.getSelectedFromDateMonth());
        monthList = cal.getDisplayNames(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        dateList = createDateList(cal);
        monthList = sortMap(monthList);
        readOnly = true;

    }

    @Command
    @NotifyChange({"readOnly"})
    public void doEdit() {
        readOnly = false;
    }

    @Command
    @NotifyChange({"*"})
    public void doSave() throws Exception {
        if(mstLeavePeriodBefore != null){
            cal = Calendar.getInstance();
            cal.setTime(mstLeavePeriodBefore.getToDate());
            cal.add(Calendar.DATE, 1);
            mstLeavePeriod.setFromDate(cal.getTime());
        } else {
            mstLeavePeriod.setFromDate(mstLeavePeriod.getOptionsFromDate());
        }
        if(mstLeavePeriodList.isEmpty()){
            mstLeavePeriodList.add(mstLeavePeriod);
        }
        if(mstLeavePeriodAfter != null){
            makePeriodAfterSyncWithCurrent(mstLeavePeriodAfter);
        } else {
            mstLeavePeriodList.add(makeNewPeriodForAfter());
        }
        //leaveService.saveAllLeavePeriod(mstLeavePeriodList);
        doInit();
    }

    @Command
    @NotifyChange({"*"})
    public void doReset() {
        mstLeavePeriod = mstLeavePeriodTemp;
        readOnly = true;
    }

    @Command
    @NotifyChange("*")
    public void changedFromDate() {
        cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mstLeavePeriod.getSelectedFromDateMonth());
        dateList = createDateList(cal);
        currentLeavePeriod = getStrLeavePeriod(mstLeavePeriod);
    }

    public MstLeavePeriod makeNewPeriodForAfter(){
        MstLeavePeriod obj = new MstLeavePeriod();
        makePeriodAfterSyncWithCurrent(obj);
        return obj;
    }
    
    public void makePeriodAfterSyncWithCurrent(MstLeavePeriod obj){
        cal = Calendar.getInstance();
        cal.setTime(mstLeavePeriod.getToDate());
        cal.add(Calendar.DATE, 1);
        obj.setFromDate(cal.getTime());
        cal = Calendar.getInstance();
        cal.setTime(mstLeavePeriod.getOptionsFromDate());
        cal.add(Calendar.YEAR, 1);
        obj.setOptionsFromDate(cal.getTime());
        cal = Calendar.getInstance();
        cal.setTime(mstLeavePeriod.getToDate());
        cal.add(Calendar.YEAR, 1);
        obj.setToDate(cal.getTime());
    }
    
    private String getStrLeavePeriod(MstLeavePeriod mstLeavePeriod) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");       
        String strFromDate = formatter.format(mstLeavePeriod.getFromDate() != null ? mstLeavePeriod.getFromDate() : mstLeavePeriod.getOptionsFromDate());
        String strToDate = formatter.format(mstLeavePeriod.getToDate());
        return strFromDate + " to " + strToDate;
    }

    private Map<String, Integer> createDateList(Calendar cal) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            map.put(String.valueOf(i), i);
        }
        return map;
    }

    private Map<String, Integer> sortMap(Map<String, Integer> map) {
        Map<String, Integer> tempMap = new LinkedHashMap<>();
        int temp = 0;
        for (Integer o : map.values()) {
            if (o > temp) {
                temp = o;
            }
        }
        for (int i = 0; i <= 11; i++) {
            for (String value : map.keySet()) {
                if (map.get(value) != null
                        && map.get(value) == i) {
                    tempMap.put(value, i);
                    break;
                }
            }
        }
        return tempMap;
    }

    
    
    
    ////// setter getter ///////
    
    public MstLeavePeriod getMstLeavePeriod() {
        return mstLeavePeriod;
    }

    public void setMstLeavePeriod(MstLeavePeriod mstLeavePeriod) {
        this.mstLeavePeriod = mstLeavePeriod;
    }

    public List<MstLeavePeriod> getMstLeavePeriodList() {
        return mstLeavePeriodList;
    }

    public void setMstLeavePeriodList(List<MstLeavePeriod> mstLeavePeriodList) {
        this.mstLeavePeriodList = mstLeavePeriodList;
    }

    public String getCurrentLeavePeriod() {
        return currentLeavePeriod;
    }

    public void setCurrentLeavePeriod(String currentLeavePeriod) {
        this.currentLeavePeriod = currentLeavePeriod;
    }

    public LeaveService getLeaveService() {
        return leaveService;
    }

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    public Map<String, Integer> getMonthList() {
        return monthList;
    }

    public void setMonthList(Map<String, Integer> monthList) {
        this.monthList = monthList;
    }

    public Map<String, Integer> getDateList() {
        return dateList;
    }

    public void setDateList(Map<String, Integer> dateList) {
        this.dateList = dateList;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

}
