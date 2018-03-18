package org.module.hr.model;

import java.io.Serializable;

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
@Table(name = "trs_employee_salary", catalog = "dbhr", schema = "schema_hr")
public class TrsEmployeeSalary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_salary")
    private Integer idSalary;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "salary_component")
    private String salaryComponent;
    
    @Column(name = "pay_frequency")
    private String payFrequency;
    
    @Column(name = "amount")
    private String amount;
    
    @Column(name = "comment")
    private String comment;
    
    @JoinColumn(name = "id_currency", referencedColumnName = "id_currency")
    @ManyToOne
    private MstCurrency idCurrency;
    
    @JoinColumn(name = "id_paygrade", referencedColumnName = "id_paygrade")
    @ManyToOne
    private MstPaygrade idPaygrade;

    public Integer getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(Integer idSalary) {
        this.idSalary = idSalary;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

	public String getSalaryComponent() {
		return salaryComponent;
	}

	public void setSalaryComponent(String salaryComponent) {
		this.salaryComponent = salaryComponent;
	}

	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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