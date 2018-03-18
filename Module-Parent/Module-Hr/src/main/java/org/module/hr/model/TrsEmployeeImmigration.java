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
@Table(name = "trs_employee_immigration", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeImmigration implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeImmigration_idEmployeeImmigration_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeImmigration_idEmployeeImmigration_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeImmigration_idEmployeeImmigration_GENERATOR")
    @Column(name = "id_immigration")
    private Integer idImmigration;
    
    @Column(name = "document")
    private String document;
    
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    
    @Column(name = "expired_date")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    
    @Column(name = "eligible_status")
    private String eligibleStatus;
    
    @JoinColumn(name = "id_nationality", referencedColumnName = "id_nationality")
    @ManyToOne
    private MstNationality idNationality;
    
    @Column(name = "eligible_review")
    @Temporal(TemporalType.DATE)
    private Date eligibleReview;
    
    @Column(name = "comment")
    private String comment;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeImmigration() {
    	
    }

    public TrsEmployeeImmigration(Integer idImmigration) {
        this.idImmigration = idImmigration;
    }

    public Integer getIdImmigration() {
        return idImmigration;
    }

    public void setIdImmigration(Integer idImmigration) {
        this.idImmigration = idImmigration;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getEligibleStatus() {
        return eligibleStatus;
    }

    public void setEligibleStatus(String eligibleStatus) {
        this.eligibleStatus = eligibleStatus;
    }

    public MstNationality getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(MstNationality idNationality) {
        this.idNationality = idNationality;
    }

    public Date getEligibleReview() {
        return eligibleReview;
    }

    public void setEligibleReview(Date eligibleReview) {
        this.eligibleReview = eligibleReview;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
}