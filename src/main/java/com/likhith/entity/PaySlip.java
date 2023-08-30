package com.likhith.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class PaySlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "PAY_PERIOD_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Column(name = "PAY_PERIOD_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    private  float sal;
    @ManyToOne
    @JoinColumn(name = "payslip_for")
    private Employee emp;

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "PaySlip{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", sal=" + sal +
                ", emp=" + emp +
                '}';
    }
}
