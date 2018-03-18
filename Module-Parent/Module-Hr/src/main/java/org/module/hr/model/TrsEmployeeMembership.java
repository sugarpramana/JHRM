package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_employee_membership", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeMembership implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeMembership_idEmployeeMembership_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeMembership_idEmployeeMembership_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeMembership_idEmployeeMembership_GENERATOR")
    @Column(name = "id_employee_membership")
    private Integer idEmployeeMembership;
    
    @JoinColumn(name = "id_membership", referencedColumnName = "id_membership")
    @ManyToOne
    private MstMembership idMembership;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public Integer getIdEmployeeMembership() {
        return idEmployeeMembership;
    }

    public void setIdEmployeeMembership(Integer idEmployeeMembership) {
        this.idEmployeeMembership = idEmployeeMembership;
    }

    public MstMembership getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(MstMembership idMembership) {
        this.idMembership = idMembership;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
}