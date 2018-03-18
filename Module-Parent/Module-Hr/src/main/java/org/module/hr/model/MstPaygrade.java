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
@Table(name = "mst_paygrade", catalog = "dbhr", schema = "schema_hr")
public class MstPaygrade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstPaygrade_idPayGrade_GENERATOR", sequenceName="SCHEMA_HR.MstPaygrade_idPayGrade_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstPaygrade_idPayGrade_GENERATOR")
    @Column(name = "id_paygrade")
    private Integer idPaygrade;
    
    @Column(name = "paygrade_name")
    private String paygradeName;
    
    @OneToMany(mappedBy = "idPaygrade")
    private List<MstPaygradeCurrency> mstPaygradeCurrencyList;
    
    @OneToMany(mappedBy = "idPaygrade")
    private List<TrsEmployeeSalary> trsEmployeeSalaryList;

    public Integer getIdPaygrade() {
        return idPaygrade;
    }

    public void setIdPaygrade(Integer idPaygrade) {
        this.idPaygrade = idPaygrade;
    }

    public String getPaygradeName() {
        return paygradeName;
    }

    public void setPaygradeName(String paygradeName) {
        this.paygradeName = paygradeName;
    }

    @XmlTransient
    public List<MstPaygradeCurrency> getMstPaygradeCurrencyList() {
        return mstPaygradeCurrencyList;
    }

    public void setMstPaygradeCurrencyList(List<MstPaygradeCurrency> mstPaygradeCurrencyList) {
        this.mstPaygradeCurrencyList = mstPaygradeCurrencyList;
    }
    
    @XmlTransient
    public List<TrsEmployeeSalary> getTrsEmployeeSalaryList() {
        return trsEmployeeSalaryList;
    }

    public void setTrsEmployeeSalaryList(List<TrsEmployeeSalary> trsEmployeeSalaryList) {
        this.trsEmployeeSalaryList = trsEmployeeSalaryList;
    }
}