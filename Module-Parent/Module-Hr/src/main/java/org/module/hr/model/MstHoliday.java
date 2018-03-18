package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "mst_holiday", catalog = "dbhr", schema = "schema_hr")
public class MstHoliday implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_holiday")
    @SequenceGenerator(name="MstHoliday_idHoliday_GENERATOR", sequenceName="SCHEMA_HR.MstHoliday_idHoliday_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MstHoliday_idHoliday_GENERATOR")
    private Integer idHoliday;
    
    @Column(name = "holiday_name")
    private String holidayName;
    
    @Column(name = "holiday_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date holidayDate;

    @Column(name = "isAnnually")
    private Boolean annually;
    
    //dayType ENUM
    @Column(name = "day_type")
    private Integer dayType;
    
    public MstHoliday() {
    }

    public MstHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public Integer getIdHoliday() {
        return idHoliday;
    }

    public void setIdHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Boolean getAnnually() {
        return annually;
    }

    public void setAnnually(Boolean annually) {
        this.annually = annually;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }
}