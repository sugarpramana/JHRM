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
@Table(name = "mst_project", catalog = "dbhr", schema = "schema_hr")
public class MstProject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstProject_idProject_GENERATOR", sequenceName="SCHEMA_HR.MstProject_idProject_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstProject_idProject_GENERATOR")
    @Column(name = "id_project")
    private Integer idProject;
    
    @Column(name = "project_name")
    private String projectName;
    
    @Column(name = "project_description")
    private String projectDescription;
    
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    @ManyToOne
    private MstCustomer idCustomer;

    public MstProject() {
    }

    public MstProject(Integer idProject) {
        this.idProject = idProject;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public MstCustomer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(MstCustomer idCustomer) {
        this.idCustomer = idCustomer;
    }
}