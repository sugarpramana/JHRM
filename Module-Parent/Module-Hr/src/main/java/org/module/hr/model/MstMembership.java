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
@Table(name = "mst_membership", catalog = "dbhr", schema = "schema_hr")
public class MstMembership implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstMembership_idMembership_GENERATOR", sequenceName="SCHEMA_HR.MstMembership_idMembership_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstMembership_idMembership_GENERATOR")
    @Column(name = "id_membership")
    private Integer idMembership;
    
    @Column(name = "name_membership")
    private String nameMembership;
    
    @OneToMany(mappedBy = "idMembership")
    private List<TrsEmployeeMembership> trsEmployeeMembershipList;

    public Integer getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(Integer idMembership) {
        this.idMembership = idMembership;
    }

    public String getNameMembership() {
        return nameMembership;
    }

    public void setNameMembership(String nameMembership) {
        this.nameMembership = nameMembership;
    }

    @XmlTransient
    public List<TrsEmployeeMembership> getTrsEmployeeMembershipList() {
        return trsEmployeeMembershipList;
    }

    public void setTrsEmployeeMembershipList(List<TrsEmployeeMembership> trsEmployeeMembershipList) {
        this.trsEmployeeMembershipList = trsEmployeeMembershipList;
    }
}