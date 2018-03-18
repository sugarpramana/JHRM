package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_entitlement", catalog = "dbhr", schema = "schema_hr")
public class TrsEntitlement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_entitlement")
    private Integer idEntitlement;
    
    @Column(name = "entitlement_balance")
    private Integer entitlementBalance;
    
    @JoinColumn(name = "id_leave_type", referencedColumnName = "id_leave_type")
    @ManyToOne
    private MstLeaveType idLeaveType;
    
    @JoinColumn(name = "id_leave_period", referencedColumnName = "id_leave_period")
    @ManyToOne
    private MstLeavePeriod idLeavePeriod;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "active")
    private Integer status;

    public TrsEntitlement() {
    	
    }

    public TrsEntitlement(Integer idEntitlement) {
        this.idEntitlement = idEntitlement;
    }

    public Integer getIdEntitlement() {
        return idEntitlement;
    }

    public void setIdEntitlement(Integer idEntitlement) {
        this.idEntitlement = idEntitlement;
    }

    public Integer getEntitlementBalance() {
        return entitlementBalance;
    }

    public void setEntitlementBalance(Integer entitlementBalance) {
        this.entitlementBalance = entitlementBalance;
    }

    public MstLeaveType getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(MstLeaveType idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public MstLeavePeriod getIdLeavePeriod() {
        return idLeavePeriod;
    }

    public void setIdLeavePeriod(MstLeavePeriod idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}