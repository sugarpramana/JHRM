package org.module.hr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_sub_unit", catalog = "dbhr", schema = "schema_hr")
public class MstSubUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_sub_unit")
    private Integer idSubUnit;
    
    @Column(name = "code_sub_unit")
    private String codeSubUnit;
    
    @Column(name = "name_sub_unit")
    private String nameSubUnit;
    
    @Column(name = "description_sub_unit")
    private String descriptionSubUnit;
    
    @Column(name = "parent")
    private Short parent;
    
    @Column(name = "child")
    private Short child;
    
    @Column(name = "level")
    private Short level;
    
    @OneToMany(mappedBy = "idSubUnit")
    private List<TrsEmployee> trsEmployeeList;

    public Integer getIdSubUnit() {
        return idSubUnit;
    }

    public void setIdSubUnit(Integer idSubUnit) {
        this.idSubUnit = idSubUnit;
    }

    public String getCodeSubUnit() {
        return codeSubUnit;
    }

    public void setCodeSubUnit(String codeSubUnit) {
        this.codeSubUnit = codeSubUnit;
    }

    public String getNameSubUnit() {
        return nameSubUnit;
    }

    public void setNameSubUnit(String nameSubUnit) {
        this.nameSubUnit = nameSubUnit;
    }

    public String getDescriptionSubUnit() {
        return descriptionSubUnit;
    }

    public void setDescriptionSubUnit(String descriptionSubUnit) {
        this.descriptionSubUnit = descriptionSubUnit;
    }

    public Short getParent() {
        return parent;
    }

    public void setParent(Short parent) {
        this.parent = parent;
    }

    public Short getChild() {
        return child;
    }

    public void setChild(Short child) {
        this.child = child;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    @XmlTransient
    public List<TrsEmployee> getTrsEmployeeList() {
        return trsEmployeeList;
    }

    public void setTrsEmployeeList(List<TrsEmployee> trsEmployeeList) {
        this.trsEmployeeList = trsEmployeeList;
    }
}