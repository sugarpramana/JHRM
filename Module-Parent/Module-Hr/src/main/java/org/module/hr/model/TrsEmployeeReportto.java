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
@Table(name = "trs_employee_reportto", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeReportto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_reportto")
    private Integer idReportto;
    
    @Column(name = "methode_diret")
    private Character methodeDiret;
    
    @JoinColumn(name = "id_employee_supervisor", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployeeSupervisor;
    
    @JoinColumn(name = "id_employee_sub", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployeeSub;

    public Integer getIdReportto() {
        return idReportto;
    }

    public void setIdReportto(Integer idReportto) {
        this.idReportto = idReportto;
    }

    public Character getMethodeDiret() {
        return methodeDiret;
    }

    public void setMethodeDiret(Character methodeDiret) {
        this.methodeDiret = methodeDiret;
    }

    public TrsEmployee getIdEmployeeSupervisor() {
        return idEmployeeSupervisor;
    }

    public void setIdEmployeeSupervisor(TrsEmployee idEmployeeSupervisor) {
        this.idEmployeeSupervisor = idEmployeeSupervisor;
    }

    public TrsEmployee getIdEmployeeSub() {
        return idEmployeeSub;
    }

    public void setIdEmployeeSub(TrsEmployee idEmployeeSub) {
        this.idEmployeeSub = idEmployeeSub;
    }
}