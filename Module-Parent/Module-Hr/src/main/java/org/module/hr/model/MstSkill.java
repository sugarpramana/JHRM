package org.module.hr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "mst_skill", catalog = "dbhr", schema = "schema_hr")
public class MstSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstSkill_idSkill_GENERATOR", sequenceName="SCHEMA_HR.MstSkill_idSkill_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstSkill_idSkill_GENERATOR")
    @Column(name = "id_skill")
    private Integer idSkill;
    
    @Column(name = "name_skill")
    private String nameSkill;
    
    @Column(name = "description_skill")
    private String descriptionSkill;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSkill")
    private List<TrsEmployeeSkill> trsEmployeeSkillList;

    public MstSkill() {
    	
    }

    public MstSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public Integer getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }

    public String getDescriptionSkill() {
        return descriptionSkill;
    }

    public void setDescriptionSkill(String descriptionSkill) {
        this.descriptionSkill = descriptionSkill;
    }

    @XmlTransient
    public List<TrsEmployeeSkill> getTrsEmployeeSkillList() {
        return trsEmployeeSkillList;
    }

    public void setTrsEmployeeSkillList(List<TrsEmployeeSkill> trsEmployeeSkillList) {
        this.trsEmployeeSkillList = trsEmployeeSkillList;
    }
}