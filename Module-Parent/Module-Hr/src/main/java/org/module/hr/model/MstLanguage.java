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
@Table(name = "mst_language", catalog = "dbhr", schema = "schema_hr")
public class MstLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstLanguage_idLanguage_GENERATOR", sequenceName="SCHEMA_HR.MstLanguage_idLanguage_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstLanguage_idLanguage_GENERATOR")
    @Column(name = "id_language")
    private Integer idLanguage;
    
    @Column(name = "name_language")
    private String nameLanguage;
    
    @OneToMany(mappedBy = "idLanguage")
    private List<TrsEmployeeLanguage> trsEmployeeLanguageList;

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    @XmlTransient
    public List<TrsEmployeeLanguage> getTrsEmployeeLanguageList() {
        return trsEmployeeLanguageList;
    }

    public void setTrsEmployeeLanguageList(List<TrsEmployeeLanguage> trsEmployeeLanguageList) {
        this.trsEmployeeLanguageList = trsEmployeeLanguageList;
    }
}