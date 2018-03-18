package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_employement_status", catalog = "dbhr", schema = "schema_hr")
public class MstEmployementStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstEmployementStatus_idLicense_GENERATOR", sequenceName="SCHEMA_HR.MstEmployementStatus_idLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstEmployementStatus_idLicense_GENERATOR")
    @Column(name = "id_employement_status")
    private Integer idEmployementStatus;
    
    @Column(name = "employement_status_name")
    private String employementStatusName;

    public Integer getIdEmployementStatus() {
        return idEmployementStatus;
    }

    public void setIdEmployementStatus(Integer idEmployementStatus) {
        this.idEmployementStatus = idEmployementStatus;
    }

    public String getEmployementStatusName() {
        return employementStatusName;
    }

    public void setEmployementStatusName(String employementStatusName) {
        this.employementStatusName = employementStatusName;
    }    
}