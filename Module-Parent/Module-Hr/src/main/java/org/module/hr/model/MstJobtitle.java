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
@Table(name = "mst_jobtitle", catalog = "dbhr", schema = "schema_hr")
public class MstJobtitle implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstJobtitle_idJobTitle_GENERATOR", sequenceName="SCHEMA_HR.MstJobtitle_idJobTitle_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstJobtitle_idJobTitle_GENERATOR")
    @Column(name = "id_job_title")
    private Integer idJobTitle;
    
    @Column(name = "job_name")
    private String jobName;
    
    @Column(name = "job_description")
    private String jobDescription;
    
    @Column(name = "job_note")
    private String jobNote;

    @OneToMany(mappedBy = "idJobTitle")
    private List<TrsJobVacancy> trsJobVacancyList;

    public Integer getIdJobTitle() {
		return idJobTitle;
	}

	public void setIdJobTitle(Integer idJobTitle) {
		this.idJobTitle = idJobTitle;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobNote() {
		return jobNote;
	}

	public void setJobNote(String jobNote) {
		this.jobNote = jobNote;
	}

	@XmlTransient
    public List<TrsJobVacancy> getTrsJobVacancyList() {
        return trsJobVacancyList;
    }

    public void setTrsJobVacancyList(List<TrsJobVacancy> trsJobVacancyList) {
        this.trsJobVacancyList = trsJobVacancyList;
    }   
}