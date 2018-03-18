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
@Table(name = "mst_education", catalog = "dbhr", schema = "schema_hr")
public class MstEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstEducation_idEducation_GENERATOR", sequenceName="SCHEMA_HR.MstEducation_idEducation_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstEducation_idEducation_GENERATOR")
    @Column(name = "id_education")
    private Integer idEducation;
    
    @Column(name = "education_name")
    private String educationName;
    
    @OneToMany(mappedBy = "idEducation")
    private List<TrsEmployeeEducation> trsEmployeeEducationList;

    public Integer getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    @XmlTransient
    public List<TrsEmployeeEducation> getTrsEmployeeEducationList() {
        return trsEmployeeEducationList;
    }

    public void setTrsEmployeeEducationList(List<TrsEmployeeEducation> trsEmployeeEducationList) {
        this.trsEmployeeEducationList = trsEmployeeEducationList;
    }
}