package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;
import org.module.api.common.Identifiable;
import org.module.api.common.utilities.BusinessCaseUtilities;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_job_candidate", catalog = "dbhr", schema = "schema_hr")
public class TrsJobCandidate implements Identifiable<Serializable> {
	
    @Id
    @Basic(optional = false)
    @GenericGenerator(name = "TrsJobCandidate_assigned_sequence",
        strategy = "org.module.api.common.JHRMSequenceGenerator",
        parameters = {
        		@org.hibernate.annotations.Parameter(name = "sequence_name", value = "SCHEMA_HR.trsjobcandidate_idjobcandidate_seq"),
        		@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = "IDC"),
        }
    )
    @GeneratedValue(generator = "TrsJobCandidate_assigned_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_trs_job_candidate")
    private String id;
    
    @Column(name = "contact_no")
    private String contactNo;
    
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "resume")
    private String resume;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @OneToMany(mappedBy = "idTrsJobCandidate")
    private List<MstUploadFile> mstUploadFileList;
    
    @JoinColumn(name = "id_trs_job_vacancy", referencedColumnName = "id_trs_job_vacancy")
    @ManyToOne
    private TrsJobVacancy idTrsJobVacancy;

    public TrsJobCandidate() {
    	
    }

    public TrsJobCandidate(String id) {
        this.id = id;
    }

    public TrsJobCandidate(String id, Date createdAt, String firstName) {
        this.id = id;
        this.createdAt = createdAt;
        this.firstName = firstName;
    }

    public String getId() {
		return id;
	}
    
    public void setId(String id) {
		this.id = id;
	}
    
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<MstUploadFile> getMstUploadFileList() {
        return mstUploadFileList;
    }

    public void setMstUploadFileList(List<MstUploadFile> mstUploadFileList) {
        this.mstUploadFileList = mstUploadFileList;
    }

    public TrsJobVacancy getIdTrsJobVacancy() {
        return idTrsJobVacancy;
    }

    public void setIdTrsJobVacancy(TrsJobVacancy idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }
    
    @Transient
    public String getFullName() {
    	return BusinessCaseUtilities.composeFullName(firstName, middleName, lastName);
    }
}