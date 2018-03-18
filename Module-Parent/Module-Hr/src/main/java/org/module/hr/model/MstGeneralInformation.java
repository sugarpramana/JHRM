package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_general_information", catalog = "dbhr", schema = "schema_hr")
public class MstGeneralInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_general_information")
    private Integer idGeneralInformation;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "tax_id")
    private String taxId;
    
    @Column(name = "registration_number")
    private String registrationNumber;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "fax")
    private String fax;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    @Column(name = "street1")
    private String street1;
    
    @Column(name = "street2")
    private String street2;
    
    @Column(name = "note")
    private String note;

    public Integer getIdGeneralInformation() {
        return idGeneralInformation;
    }

    public void setIdGeneralInformation(Integer idGeneralInformation) {
        this.idGeneralInformation = idGeneralInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}