package org.module.hr.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_paygrade_currency", catalog = "dbhr", schema = "schema_hr")
public class MstPaygradeCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_paygrade_currency")
    private Integer idPaygradeCurrency;
    
    @Column(name = "min_salary")
    private BigInteger minSalary;
    
    @Column(name = "max_salary")
    private BigInteger maxSalary;
    
    @JoinColumn(name = "id_currency", referencedColumnName = "id_currency")
    @ManyToOne
    private MstCurrency idCurrency;
    
    @JoinColumn(name = "id_paygrade", referencedColumnName = "id_paygrade")
    @ManyToOne
    private MstPaygrade idPaygrade;

    public Integer getIdPaygradeCurrency() {
        return idPaygradeCurrency;
    }

    public void setIdPaygradeCurrency(Integer idPaygradeCurrency) {
        this.idPaygradeCurrency = idPaygradeCurrency;
    }

    public BigInteger getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigInteger minSalary) {
        this.minSalary = minSalary;
    }

    public BigInteger getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigInteger maxSalary) {
        this.maxSalary = maxSalary;
    }

    public MstCurrency getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(MstCurrency idCurrency) {
        this.idCurrency = idCurrency;
    }

    public MstPaygrade getIdPaygrade() {
        return idPaygrade;
    }

    public void setIdPaygrade(MstPaygrade idPaygrade) {
        this.idPaygrade = idPaygrade;
    }
}