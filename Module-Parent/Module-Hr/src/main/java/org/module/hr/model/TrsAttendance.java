package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_attendance", catalog = "dbhr", schema = "schema_hr")
public class TrsAttendance implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsAttendance_idAttendance_GENERATOR", sequenceName="SCHEMA_HR.TrsAttendance_idAttendance_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsAttendance_idAttendance_GENERATOR")
    @Column(name = "id_attendance")
    private Integer idAttendance;
    
    @Column(name = "in")
    @Temporal(TemporalType.DATE)
    private Date in;
    
    @Column(name = "in_description")
    private String inDescription;
    
    @Column(name = "out")
    @Temporal(TemporalType.DATE)
    private Date out;
    
    @Column(name = "out_description")
    private String outDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duration")
    private Double duration;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsAttendance() {
    	
    }

    public TrsAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public String getInDescription() {
        return inDescription;
    }

    public void setInDescription(String inDescription) {
        this.inDescription = inDescription;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public String getOutDescription() {
        return outDescription;
    }

    public void setOutDescription(String outDescription) {
        this.outDescription = outDescription;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
}