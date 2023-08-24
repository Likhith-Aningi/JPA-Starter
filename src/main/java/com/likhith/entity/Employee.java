package com.likhith.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEST_EMP")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;
    @Column(name="emp_name",length = 20)
    private String name;
    public Employee(String ename) {
        this.name = ename;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + id +
                ", ename='" + name + '\'' +
                '}';
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
}
