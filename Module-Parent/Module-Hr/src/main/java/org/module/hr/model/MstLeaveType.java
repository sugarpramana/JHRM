package org.module.hr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_leave_type", catalog = "dbhr", schema = "schema_hr")
public class MstLeaveType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_type")
    @SequenceGenerator(name="MstLeaveType_idLeaveType_GENERATOR", sequenceName="SCHEMA_HR.MstLeaveType_idLeaveType_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MstLeaveType_idLeaveType_GENERATOR")
    private Integer idLeaveType;
    
    @Column(name = "leave_type_name")
    private String leaveTypeName;
    
    @Column(name = "isSituational")
    private Boolean isSituational;
    
    @OneToMany(mappedBy = "idLeaveType")
    private List<TrsLeave> trsLeaveList;
    
    @OneToMany(mappedBy = "idLeaveType")
    private List<TrsEntitlement> trsEntitlementList;

    public MstLeaveType() {
    }

    public MstLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public Integer getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public Boolean getIsSituational() {
        return isSituational;
    }

    public void setIsSituational(Boolean isSituational) {
        this.isSituational = isSituational;
    }
    
    @XmlTransient
    public List<TrsLeave> getTrsLeaveList() {
        return trsLeaveList;
    }

    public void setTrsLeaveList(List<TrsLeave> trsLeaveList) {
        this.trsLeaveList = trsLeaveList;
    }

    @XmlTransient
    public List<TrsEntitlement> getTrsEntitlementList() {
        return trsEntitlementList;
    }

    public void setTrsEntitlementList(List<TrsEntitlement> trsEntitlementList) {
        this.trsEntitlementList = trsEntitlementList;
    }
}