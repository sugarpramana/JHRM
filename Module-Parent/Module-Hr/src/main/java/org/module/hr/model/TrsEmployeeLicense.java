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
@Table(name = "trs_employee_license", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeLicense implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeLicense_idEmployeeLicense_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeLicense_idEmployeeLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeLicense_idEmployeeLicense_GENERATOR")
    @Column(name = "id_employee_license")
    private Integer idEmployeeLicense;
    
    @JoinColumn(name = "id_license", referencedColumnName = "id_license")
    @ManyToOne
    private MstLicense idLicense;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "license_number")
    private String licenseNumber;
    
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    public Integer getIdEmployeeLicense() {
        return idEmployeeLicense;
    }

    public void setIdEmployeeLicense(Integer idEmployeeLicense) {
        this.idEmployeeLicense = idEmployeeLicense;
    }

    public MstLicense getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(MstLicense idLicense) {
        this.idLicense = idLicense;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}