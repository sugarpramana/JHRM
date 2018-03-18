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
@Table(name = "trs_employee_skill", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeSkill_idEmployeeSkill_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeSkill_idEmployeeSkill_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeSkill_idEmployeeSkill_GENERATOR")
    @Column(name = "id_employee_skill")
    private Integer idEmployeeSkill;
    
    @JoinColumn(name = "id_skill", referencedColumnName = "id_skill")
    @ManyToOne
    private MstSkill idSkill;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "year_of_experience")
    private Integer yearOfExperience;
    
    @Column(name = "comment")
    private String comment;

    public Integer getIdEmployeeSkill() {
        return idEmployeeSkill;
    }

    public void setIdEmployeeSkill(Integer idEmployeeSkill) {
        this.idEmployeeSkill = idEmployeeSkill;
    }

    public MstSkill getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(MstSkill idSkill) {
        this.idSkill = idSkill;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
    
	public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}