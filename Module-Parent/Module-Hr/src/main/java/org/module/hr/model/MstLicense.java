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
@Table(name = "mst_license", catalog = "dbhr", schema = "schema_hr")
public class MstLicense implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstLicense_idLicense_GENERATOR", sequenceName="SCHEMA_HR.MstLicense_idLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstLicense_idLicense_GENERATOR")
    @Column(name = "id_license")
    private Integer idLicense;
    
    @Column(name = "name_license")
    private String nameLicense;
    
    @OneToMany(mappedBy = "idLicense")
    private List<TrsEmployeeLicense> trsEmployeeLicenseList;

    public Integer getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(Integer idLicense) {
        this.idLicense = idLicense;
    }

    public String getNameLicense() {
        return nameLicense;
    }

    public void setNameLicense(String nameLicense) {
        this.nameLicense = nameLicense;
    }

    @XmlTransient
    public List<TrsEmployeeLicense> getTrsEmployeeLicenseList() {
        return trsEmployeeLicenseList;
    }

    public void setTrsEmployeeLicenseList(List<TrsEmployeeLicense> trsEmployeeLicenseList) {
        this.trsEmployeeLicenseList = trsEmployeeLicenseList;
    }
}