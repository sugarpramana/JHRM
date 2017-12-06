package org.module.hr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "mst_leave_period", catalog = "dbhr", schema = "schema_hr")
public class MstLeavePeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_period")
    private Integer idLeavePeriod;
    
    @Column(name = "start_month")
    private Integer startMonth;
    
    @Column(name = "start_day")
    private Integer startDay;
    
    @OneToMany(mappedBy = "idLeavePeriod")
    private List<TrsEntitlement> trsEntitlementList;

    public MstLeavePeriod() {
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

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    @XmlTransient
    public List<TrsEntitlement> getTrsEntitlementList() {
        return trsEntitlementList;
    }

    public void setTrsEntitlementList(List<TrsEntitlement> trsEntitlementList) {
        this.trsEntitlementList = trsEntitlementList;
    }
}