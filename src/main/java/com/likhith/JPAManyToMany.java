package com.likhith;

import com.likhith.entity.AccessCard;
import com.likhith.entity.EmailGroup;
import com.likhith.entity.Employee;
import com.likhith.entity.PaySlip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JPAManyToMany {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStarter");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Employee emp=new Employee("Many2Many");
        Employee emp2=new Employee("TwoMany2Many");
        EmailGroup eg=new EmailGroup();
        AccessCard accessCard = new AccessCard(Floor.FIRST,true);
        accessCard.setEmployee(emp);
        emp.setAccessCard(accessCard);
        AccessCard accessCard2 = new AccessCard(Floor.SECOND,true);
        accessCard2.setEmployee(emp2);
        emp2.setAccessCard(accessCard2);
        eg.setGroupName("R&D");
        EmailGroup eg2=new EmailGroup();
        eg2.setGroupName("Sales");
        emp.addGroup(eg);
        emp.addGroup(eg2);
        eg2.addEmp(emp);
        eg.addEmp(emp);

        PaySlip paySlip1=new PaySlip();
        paySlip1.setEnd(new Date());
        paySlip1.setStart(new Date());
        paySlip1.setSal(100f);
        paySlip1.setEmp(emp);
        PaySlip paySlip2=new PaySlip();
        paySlip2.setEnd(new Date());
        paySlip2.setStart(new Date());
        paySlip2.setSal(200f);
        paySlip2.setEmp(emp);
        emp.setPaySlips(List.of(paySlip1,paySlip2));

        et.begin();
        em.persist(emp);
        em.persist(emp2);
        em.persist(eg);
        em.persist(eg2);
        em.persist(accessCard2);
        em.persist(accessCard);
        em.persist(paySlip1);
        em.persist(paySlip2);
        et.commit();
        System.out.println("-----------------------");
        var getter=em.find(EmailGroup.class,1);
        System.out.println("========================");
        System.out.println(getter.getEmps());
    }
}
