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
@Table(name = "mst_job_category", catalog = "dbhr", schema = "schema_hr")
public class MstJobCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstJobCategory_idLicense_GENERATOR", sequenceName="SCHEMA_HR.MstJobCategory_idLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstJobCategory_idLicense_GENERATOR")
    @Column(name = "id_job_category")
    private Integer idJobCategory;
    
    @Column(name = "job_category_name")
    private String jobCategoryName;

    public Integer getIdJobCategory() {
        return idJobCategory;
    }

    public void setIdJobCategory(Integer idJobCategory) {
        this.idJobCategory = idJobCategory;
    }

    public String getJobCategoryName() {
        return jobCategoryName;
    }

    public void setJobCategoryName(String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }
}