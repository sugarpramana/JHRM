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
@Table(name = "mst_currency", catalog = "dbhr", schema = "schema_hr")
public class MstCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_currency")
    private String idCurrency;
    
    @Column(name = "currency_name")
    private String currencyName;
    
    @OneToMany(mappedBy = "idCurrency")
    private List<MstPaygradeCurrency> mstPaygradeCurrencyList;
    
    @OneToMany(mappedBy = "idPaygrade")
    private List<TrsEmployeeSalary> trsEmployeeSalaryList;

    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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