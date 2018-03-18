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
@Table(name = "mst_setting", catalog = "dbhr", schema = "schema_hr")
public class MstSetting implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_setting")
    private Integer idSetting;
    
    @Column(name = "key_set")
    private String keySet;
    
    @Column(name = "value_set")
    private String valueSet;
    
    @Column(name = "description")
    private String description;

    public MstSetting() {
    	
    }

    public MstSetting(Integer idSetting) {
        this.idSetting = idSetting;
    }

    public Integer getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(Integer idSetting) {
        this.idSetting = idSetting;
    }

    public String getKeySet() {
        return keySet;
    }

    public void setKeySet(String keySet) {
        this.keySet = keySet;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}