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
@Table(name = "trs_employee_exprience", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeExprience implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeExprience_idEmployeeExprience_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeExprience_idEmployeeExprience_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeExprience_idEmployeeExprience_GENERATOR")
    @Column(name = "id_exprience")
    private Integer idExprience;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "job_title")
    private String jobTitle;
    
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date from;
    
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date to;
    
    @Column(name = "comment")
    private String comment;

    public Integer getIdExprience() {
        return idExprience;
    }

    public void setIdExprience(Integer idExprience) {
        this.idExprience = idExprience;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}