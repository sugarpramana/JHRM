package org.module.hr.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_leave_period", catalog = "dbhr", schema = "schema_hr")
public class MstLeavePeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_period")
    @SequenceGenerator(name="MstLeavePeriod_idLeavePeriod_GENERATOR", sequenceName="SCHEMA_HR.MstLeavePeriod_idLeavePeriod_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MstLeavePeriod_idLeavePeriod_GENERATOR")
    private Integer idLeavePeriod;
    
    @Column(name = "from_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fromDate;
    
    @Column(name = "to_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toDate;
    
    @Column(name = "options_from_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date optionsFromDate;
    
    @OneToMany(mappedBy = "idLeavePeriod")
    private List<TrsEntitlement> trsEntitlementList;

    @Transient
    Calendar cal = Calendar.getInstance();
    
    public MstLeavePeriod() {
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        this.setOptionsFromDate(cal.getTime());
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        this.setToDate(cal.getTime());
    }
    
    public MstLeavePeriod(Integer idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public Integer getIdLeavePeriod() {
        return idLeavePeriod;
    }

    public void setIdLeavePeriod(Integer idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getOptionsFromDate() {
        return optionsFromDate;
    }

    public void setOptionsFromDate(Date optionsFromDate) {
        this.optionsFromDate = optionsFromDate;
    }

    @XmlTransient
    public List<TrsEntitlement> getTrsEntitlementList() {
        return trsEntitlementList;
    }

    public void setTrsEntitlementList(List<TrsEntitlement> trsEntitlementList) {
        this.trsEntitlementList = trsEntitlementList;
    }

    //For UI
    
    public Integer getSelectedFromDateMonth() {
        cal.setTime(this.optionsFromDate);
        return cal.get(Calendar.MONTH);
    }

    public void setSelectedFromDateMonth(Integer selectedFromDateMonth) {
        cal.setTime(this.optionsFromDate);
        cal.set(Calendar.MONTH, selectedFromDateMonth);
        this.optionsFromDate = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        this.toDate = cal.getTime();
    }

    public Integer getSelectedFromDateDate() {
        cal.setTime(this.optionsFromDate);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public void setSelectedFromDateDate(Integer selectedFromDateDate) {
        cal.setTime(this.optionsFromDate);
        cal.set(Calendar.DAY_OF_MONTH, selectedFromDateDate);
        this.optionsFromDate = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        this.toDate = cal.getTime();
    }

    public String getSelectedToDate() { 
        cal.setTime(this.toDate);
        String strToDate = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
                + " " 
                + cal.get(Calendar.DATE);
        if(cal.get(Calendar.YEAR) > Calendar.getInstance().get(Calendar.YEAR)){
            strToDate += " (Following Year)";
        }
        return strToDate;
    }
   
}