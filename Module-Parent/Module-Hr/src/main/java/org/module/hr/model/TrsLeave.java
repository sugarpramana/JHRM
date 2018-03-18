package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author formulateko@admin.com
*/
@Entity
@Table(name = "trs_leave", catalog = "dbhr", schema = "schema_hr")
public class TrsLeave implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave")
    private Integer idLeave;
    
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    
    @Column(name = "duration")
    private Integer duration;
    
    @Column(name = "comment")
    private String comment;
    
    @JoinColumn(name = "id_leave_type", referencedColumnName = "id_leave_type")
    @ManyToOne
    private MstLeaveType idLeaveType;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    
    @Column(name = "active")
    private Integer status;

    public TrsLeave() {
    	
    }

    public TrsLeave(Integer idLeave) {
        this.idLeave = idLeave;
    }

    public Integer getIdLeave() {
        return idLeave;
    }

    public void setIdLeave(Integer idLeave) {
        this.idLeave = idLeave;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MstLeaveType getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(MstLeaveType idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}