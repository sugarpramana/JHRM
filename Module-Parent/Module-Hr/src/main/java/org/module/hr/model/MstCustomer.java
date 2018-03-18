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
@Table(name = "mst_customer", catalog = "dbhr", schema = "schema_hr")
public class MstCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstCustomer_idCustomer_GENERATOR", sequenceName="SCHEMA_HR.MstCustomer_idCustomer_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstCustomer_idCustomer_GENERATOR")
    @Column(name = "id_customer")
    private Integer idCustomer;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_description")
    private String customerDescription;
    
    @OneToMany(mappedBy = "idCustomer")
    private List<MstProject> mstProjectList;

    public MstCustomer() {
    }

    public MstCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    @XmlTransient
    public List<MstProject> getMstProjectList() {
        return mstProjectList;
    }

    public void setMstProjectList(List<MstProject> mstProjectList) {
        this.mstProjectList = mstProjectList;
    }
}