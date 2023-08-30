package com.likhith.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEST_EMP")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "emp_name", length = 20)
    private String name;
    @OneToOne
    private AccessCard accessCard;
    @OneToMany
            (mappedBy = "emp")
    private List<PaySlip> paySlips;

    public List<PaySlip> getPaySlips() {
        return paySlips;
    }

    public void setPaySlips(List<PaySlip> paySlips) {
        this.paySlips = paySlips;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public Employee(String ename) {
        this.name = ename;
    }

    public Employee() {
    }


    public int getId() {
        return id;
    }

    public void setId(int eid) {
        this.id = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String ename) {
        this.name = ename;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accessCard=" + accessCard +
                '}';
    }
}
