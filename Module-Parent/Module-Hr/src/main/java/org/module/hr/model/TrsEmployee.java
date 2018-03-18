package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_employee", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @Column(name = "id_employee")
    private String idEmployee;
	
	@Column(name = "first_name")
    private String firstName;
    
	@Column(name = "middle_name")
    private String middleName;
    
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "driver_license")
    private String driverLicense;
    
	@Column(name = "other_license")
    private String otherLicense;
    
	@Column(name = "expired_license")
    @Temporal(TemporalType.DATE)
    private Date expiredLicense;
    
	@Column(name = "gender")
    private Boolean gender;
    
	@Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
	@Column(name = "address_street1")
    private String addressStreet1;
    
	@Column(name = "address_street2")
    private String addressStreet2;
    
	@Column(name = "city")
    private String city;
    
	@Column(name = "province")
    private String province;
    
	@Column(name = "zip")
    private String zip;
    
	@Column(name = "home_telephone")
    private String homeTelephone;
    
	@Column(name = "mobile")
    private String mobile;
    
	@Column(name = "work_telephone")
    private String workTelephone;
    
	@Column(name = "work_email")
    private String workEmail;
    
	@Column(name = "other_email")
    private String otherEmail;
    
	@Column(name = "marital_status")
    private Character maritalStatus;
    
	@Column(name = "country")
    private String country;
	
	@Column(name = "join_date")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
    
	@OneToMany(mappedBy = "idEmployee")
    private List<TrsJobVacancy> trsJobVacancyList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeMembership> trsEmployeeMembershipList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeDependent> trsEmployeeDependentList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeExprience> trsEmployeeExprienceList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeLanguage> trsEmployeeLanguageList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeEducation> trsEmployeeEducationList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeLicense> trsEmployeeLicenseList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContactList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeSkill> trsEmployeeSkillList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeImmigration> trsEmployeeImmigrationList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeSalary> trsEmployeeSalaryList;
    
    @OneToMany(mappedBy = "idEmployeeSupervisor")
    private List<TrsEmployeeReportto> trsEmployeeReporttoSupervisorList;
    
    @OneToMany(mappedBy = "idEmployeeSub")
    private List<TrsEmployeeReportto> trsEmployeeReporttoSubList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEntitlement> trsEntitlementList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsLeave> trsLeaveList;
    
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsAttendance> trsAttendanceList;
    
    @JoinColumn(name = "id_nationality", referencedColumnName = "id_nationality")
    @ManyToOne
    private MstNationality idNationality;
    
    @JoinColumn(name = "id_job_category", referencedColumnName = "id_job_category")
    @ManyToOne
    private MstJobCategory idJobCategory;
    
    @JoinColumn(name = "id_sub_unit", referencedColumnName = "id_sub_unit")
    @ManyToOne
    private MstSubUnit idSubUnit;

    @JoinColumn(name = "id_employement_status", referencedColumnName = "id_employement_status")
    @ManyToOne
    private MstEmployementStatus idEmployementStatus;
    
    @JoinColumn(name = "id_location", referencedColumnName = "id_location")
    @ManyToOne
    private MstLocation idLocation;
    
    @JoinColumn(name = "id_job_title", referencedColumnName = "id_job_title")
    @ManyToOne
    private MstJobtitle idJobTitle;
    
    public List<TrsEntitlement> getTrsEntitlementList() {
		return trsEntitlementList;
	}

	public void setTrsEntitlementList(List<TrsEntitlement> trsEntitlementList) {
		this.trsEntitlementList = trsEntitlementList;
	}

	public List<TrsLeave> getTrsLeaveList() {
		return trsLeaveList;
	}

	public void setTrsLeaveList(List<TrsLeave> trsLeaveList) {
		this.trsLeaveList = trsLeaveList;
	}

    public TrsEmployee() {
    }

    public TrsEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @XmlTransient
    public List<TrsEmployeeMembership> getTrsEmployeeMembershipList() {
        return trsEmployeeMembershipList;
    }

    public void setTrsEmployeeMembershipList(List<TrsEmployeeMembership> trsEmployeeMembershipList) {
        this.trsEmployeeMembershipList = trsEmployeeMembershipList;
    }

    @XmlTransient
    public List<TrsEmployeeDependent> getTrsEmployeeDependentList() {
        return trsEmployeeDependentList;
    }

    public void setTrsEmployeeDependentList(List<TrsEmployeeDependent> trsEmployeeDependentList) {
        this.trsEmployeeDependentList = trsEmployeeDependentList;
    }

    @XmlTransient
    public List<TrsEmployeeExprience> getTrsEmployeeExprienceList() {
        return trsEmployeeExprienceList;
    }

    public void setTrsEmployeeExprienceList(List<TrsEmployeeExprience> trsEmployeeExprienceList) {
        this.trsEmployeeExprienceList = trsEmployeeExprienceList;
    }

    @XmlTransient
    public List<TrsEmployeeLanguage> getTrsEmployeeLanguageList() {
        return trsEmployeeLanguageList;
    }

    public void setTrsEmployeeLanguageList(List<TrsEmployeeLanguage> trsEmployeeLanguageList) {
        this.trsEmployeeLanguageList = trsEmployeeLanguageList;
    }

    @XmlTransient
    public List<TrsEmployeeEducation> getTrsEmployeeEducationList() {
        return trsEmployeeEducationList;
    }

    public void setTrsEmployeeEducationList(List<TrsEmployeeEducation> trsEmployeeEducationList) {
        this.trsEmployeeEducationList = trsEmployeeEducationList;
    }

    @XmlTransient
    public List<TrsEmployeeLicense> getTrsEmployeeLicenseList() {
        return trsEmployeeLicenseList;
    }

    public void setTrsEmployeeLicenseList(List<TrsEmployeeLicense> trsEmployeeLicenseList) {
        this.trsEmployeeLicenseList = trsEmployeeLicenseList;
    }

    @XmlTransient
    public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactList() {
        return trsEmployeeEmergencyContactList;
    }

    public void setTrsEmployeeEmergencyContactList(List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContactList) {
        this.trsEmployeeEmergencyContactList = trsEmployeeEmergencyContactList;
    }

    @XmlTransient
    public List<TrsEmployeeSkill> getTrsEmployeeSkillList() {
        return trsEmployeeSkillList;
    }

    public void setTrsEmployeeSkillList(List<TrsEmployeeSkill> trsEmployeeSkillList) {
        this.trsEmployeeSkillList = trsEmployeeSkillList;
    }

    @XmlTransient
    public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationList() {
        return trsEmployeeImmigrationList;
    }

    public void setTrsEmployeeImmigrationList(List<TrsEmployeeImmigration> trsEmployeeImmigrationList) {
        this.trsEmployeeImmigrationList = trsEmployeeImmigrationList;
    }

    @XmlTransient
    public List<TrsEmployeeSalary> getTrsEmployeeSalaryList() {
        return trsEmployeeSalaryList;
    }

    public void setTrsEmployeeSalaryList(List<TrsEmployeeSalary> trsEmployeeSalaryList) {
        this.trsEmployeeSalaryList = trsEmployeeSalaryList;
    }
    
    public MstLocation getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(MstLocation idLocation) {
		this.idLocation = idLocation;
	}

	public MstNationality getIdNationality() {
		return idNationality;
	}

	public void setIdNationality(MstNationality idNationality) {
		this.idNationality = idNationality;
	}

	public MstSubUnit getIdSubUnit() {
		return idSubUnit;
	}

	public void setIdSubUnit(MstSubUnit idSubUnit) {
		this.idSubUnit = idSubUnit;
	}
	
	public MstJobCategory getIdJobCategory() {
		return idJobCategory;
	}

	public void setIdJobCategory(MstJobCategory idJobCategory) {
		this.idJobCategory = idJobCategory;
	}

	public MstEmployementStatus getIdEmployementStatus() {
		return idEmployementStatus;
	}

	public void setIdEmployementStatus(MstEmployementStatus idEmployementStatus) {
		this.idEmployementStatus = idEmployementStatus;
	}

	public MstJobtitle getIdJobTitle() {
		return idJobTitle;
	}

	public void setIdJobTitle(MstJobtitle idJobTitle) {
		this.idJobTitle = idJobTitle;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@XmlTransient
	public List<TrsEmployeeReportto> getTrsEmployeeReporttoSupervisorList() {
		return trsEmployeeReporttoSupervisorList;
	}

	public void setTrsEmployeeReporttoSupervisorList(List<TrsEmployeeReportto> trsEmployeeReporttoSupervisorList) {
		this.trsEmployeeReporttoSupervisorList = trsEmployeeReporttoSupervisorList;
	}

	@XmlTransient
	public List<TrsEmployeeReportto> getTrsEmployeeReporttoSubList() {
		return trsEmployeeReporttoSubList;
	}

	public void setTrsEmployeeReporttoSubList(List<TrsEmployeeReportto> trsEmployeeReporttoSubList) {
		this.trsEmployeeReporttoSubList = trsEmployeeReporttoSubList;
	}

    @XmlTransient
    public List<TrsJobVacancy> getTrsJobVacancyList() {
        return trsJobVacancyList;
    }

    public void setTrsJobVacancyList(List<TrsJobVacancy> trsJobVacancyList) {
        this.trsJobVacancyList = trsJobVacancyList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getOtherLicense() {
		return otherLicense;
	}

	public void setOtherLicense(String otherLicense) {
		this.otherLicense = otherLicense;
	}

	public Date getExpiredLicense() {
		return expiredLicense;
	}

	public void setExpiredLicense(Date expiredLicense) {
		this.expiredLicense = expiredLicense;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddressStreet1() {
		return addressStreet1;
	}

	public void setAddressStreet1(String addressStreet1) {
		this.addressStreet1 = addressStreet1;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWorkTelephone() {
		return workTelephone;
	}

	public void setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getOtherEmail() {
		return otherEmail;
	}

	public void setOtherEmail(String otherEmail) {
		this.otherEmail = otherEmail;
	}

	public Character getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Character maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@XmlTransient
    public List<TrsAttendance> getTrsAttendanceList() {
        return trsAttendanceList;
    }

    public void setTrsAttendanceList(List<TrsAttendance> trsAttendanceList) {
        this.trsAttendanceList = trsAttendanceList;
    }
}