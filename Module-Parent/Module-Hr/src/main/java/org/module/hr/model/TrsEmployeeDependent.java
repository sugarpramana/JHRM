package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_employee_dependent", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeDependent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeDependent_idEmployeeDependent_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeDependent_idEmployeeDependent_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeDependent_idEmployeeDependent_GENERATOR")
    @Column(name = "id_dependent")
    private Integer idDependent;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "relationship")
    private Character relationship;
    
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public Integer getIdDependent() {
        return idDependent;
    }

    public void setIdDependent(Integer idDependent) {
        this.idDependent = idDependent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getRelationship() {
		return relationship;
	}

	public void setRelationship(Character relationship) {
		this.relationship = relationship;
	}

	public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
}