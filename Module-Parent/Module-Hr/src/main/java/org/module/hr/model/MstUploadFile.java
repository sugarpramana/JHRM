package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "mst_upload_file", catalog = "dbhr", schema = "schema_hr")
public class MstUploadFile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstUploadFile_idUploadFile_GENERATOR", sequenceName="SCHEMA_HR.MstUploadFile_idUploadFile_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstUploadFile_idUploadFile_GENERATOR")
    @Column(name = "id_upload_file")
    private Integer idUploadFile;
    
    @Column(name = "type_file")
    private String typeFile;
    
    @Column(name = "path_file")
    private String pathFile;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @JoinColumn(name = "id_trs_job_candidate", referencedColumnName = "id_trs_job_candidate")
    @ManyToOne(cascade=CascadeType.ALL)
    private TrsJobCandidate idTrsJobCandidate;

    public MstUploadFile() {
    	
    }

    public MstUploadFile(Integer idUploadFile) {
        this.idUploadFile = idUploadFile;
    }

    public Integer getIdUploadFile() {
        return idUploadFile;
    }

    public void setIdUploadFile(Integer idUploadFile) {
        this.idUploadFile = idUploadFile;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public TrsJobCandidate getIdTrsJobCandidate() {
        return idTrsJobCandidate;
    }

    public void setIdTrsJobCandidate(TrsJobCandidate idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }
}