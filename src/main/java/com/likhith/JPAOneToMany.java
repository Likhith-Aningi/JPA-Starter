package com.likhith;

import com.likhith.entity.AccessCard;
import com.likhith.entity.Employee;
import com.likhith.entity.PaySlip;
import com.sun.security.jgss.GSSUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JPAOneToMany {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStarter");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Employee emp = new Employee("Likhith-jpaStarter4");
        AccessCard accessCard = new AccessCard(Floor.ZERO,false);//one emp can have one access card and vice-versa
        accessCard.setEmployee(emp);
        emp.setAccessCard(accessCard);
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
        //one emp can have multiple payslips and vice-versa
        et.begin();
        em.persist(emp);
        em.persist(accessCard);
        em.persist(paySlip2);
        em.persist(paySlip1);
        et.commit();
        var getter=em.find(PaySlip.class,1);
        var getter2=em.find(PaySlip.class,2);
        System.out.println(getter);
        System.out.println(getter2);
        System.out.println("=============");
        var empGetter=em.find(Employee.class,1);
        System.out.println(empGetter.getPaySlips());
    }
}
