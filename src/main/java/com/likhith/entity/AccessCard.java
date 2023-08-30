package com.likhith.entity;

import com.likhith.Floor;

import javax.persistence.*;

@Entity
@Table
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Floor floor;
    private boolean status;
    @OneToOne
            (mappedBy = "accessCard")
    private Employee employee;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public AccessCard(Floor floor,boolean status) {
        this.floor = floor;
        this.status=status;
    }

    public AccessCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", floor=" + floor +
                ", status=" + status +
                '}';
    }
}
