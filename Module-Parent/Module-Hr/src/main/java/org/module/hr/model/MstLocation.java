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
@Table(name = "mst_location", catalog = "dbhr", schema = "schema_hr")
public class MstLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstLocation_idLocation_GENERATOR", sequenceName="SCHEMA_HR.MstLocation_idLocation_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstLocation_idLocation_GENERATOR")
    @Column(name = "id_location")
    private Integer idLocation;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "country_code")
    private String countryCode;
    
    @Column(name = "province")
    private String province;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "fax")
    private String fax;
    
    @Column(name = "notes")
    private String notes;

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}