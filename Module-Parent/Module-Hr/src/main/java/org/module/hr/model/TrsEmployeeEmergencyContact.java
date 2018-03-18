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
@Table(name = "trs_employee_emergency_contact", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeEmergencyContact implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeEmergencyContact_idEmployeeEmergencyContact_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeEmergencyContact_idEmployeeEmergencyContact_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeEmergencyContact_idEmployeeEmergencyContact_GENERATOR")
    @Column(name = "id_employee_emergency_contact")
    private Integer idEmployeeEmergencyContact;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "relationship")
    private String relationship;
    
    @Column(name = "home_telephone")
    private String homeTelephone;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "work_telephone")
    private String workTelephone;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public Integer getIdEmployeeEmergencyContact() {
        return idEmployeeEmergencyContact;
    }

    public void setIdEmployeeEmergencyContact(Integer idEmployeeEmergencyContact) {
        this.idEmployeeEmergencyContact = idEmployeeEmergencyContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getHomeTelephone() {
        return homeTelephone;
    }

    public void setHomeTelephone(String homeTelephone) {
        this.homeTelephone = homeTelephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }

    public void setWorkTelephone(String workTelephone) {
        this.workTelephone = workTelephone;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
}