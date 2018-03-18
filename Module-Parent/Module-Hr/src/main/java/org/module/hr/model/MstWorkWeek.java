package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_work_week", catalog = "dbhr", schema = "schema_hr")
public class MstWorkWeek implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_work_week")
    @SequenceGenerator(name="MstWorkWeek_idWorkWeek_GENERATOR", sequenceName="SCHEMA_HR.MstWorkWeek_idWorkWeek_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MstWorkWeek_idWorkWeek_GENERATOR")
    private Integer idWorkWeek;
    
    @Column(name = "workday_name")
    private String workdayName;
    
    //dayType ENUM
    @Column(name = "day_type")
    private Integer dayType;
    
    public MstWorkWeek() {
    }

    public Integer getIdWorkWeek() {
        return idWorkWeek;
    }

    public void setIdWorkWeek(Integer idWorkWeek) {
        this.idWorkWeek = idWorkWeek;
    }

    public String getWorkdayName() {
        return workdayName;
    }

    public void setWorkdayName(String workdayName) {
        this.workdayName = workdayName;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }
}