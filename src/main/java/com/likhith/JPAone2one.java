package com.likhith;

import com.likhith.entity.AccessCard;
import com.likhith.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAone2one {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStarter");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Employee emp = new Employee("Likhith-jpaStarter4");
        AccessCard accessCard = new AccessCard(Floor.ZERO,false);
        accessCard.setEmployee(emp);
        emp.setAccessCard(accessCard);
        System.out.println(emp+"\n"+accessCard);
        et.begin();
        em.persist(emp);
        em.persist(accessCard);
        et.commit();
        var getter = em.find(Employee.class, 1);
        var card=em.find(AccessCard.class,1);
        System.out.println(getter);
        System.out.println(card);
    }
}
