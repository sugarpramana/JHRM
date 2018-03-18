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
@Table(name = "trs_employee_language", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeLanguage_idEmployeeLanguage_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeLanguage_idEmployeeLanguage_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeLanguage_idEmployeeLanguage_GENERATOR")
    @Column(name = "id_employee_language")
    private Integer idEmployeeLanguage;
    
    @JoinColumn(name = "id_language", referencedColumnName = "id_language")
    @ManyToOne
    private MstLanguage idLanguage;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "fluency")
    private Integer fluency;
    
    @Column(name = "competency")
    private Integer competency;
    
    @Column(name = "comment")
    private String comment;

    public Integer getIdEmployeeLanguage() {
        return idEmployeeLanguage;
    }

    public void setIdEmployeeLanguage(Integer idEmployeeLanguage) {
        this.idEmployeeLanguage = idEmployeeLanguage;
    }

    public MstLanguage getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(MstLanguage idLanguage) {
        this.idLanguage = idLanguage;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    public Integer getFluency() {
		return fluency;
	}

	public void setFluency(Integer fluency) {
		this.fluency = fluency;
	}

	public Integer getCompetency() {
		return competency;
	}

	public void setCompetency(Integer competency) {
		this.competency = competency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}   
}