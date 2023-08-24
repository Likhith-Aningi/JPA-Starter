package com.likhith;

import com.likhith.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {
    public static void main(String[] args) {
        Employee emp=new Employee("Likhith-jpaStarter");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpaStarter");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(emp);
        et.commit();
        System.out.println("========CREATE DONE========");
        var getter=em.find(Employee.class,1);
        System.out.println(getter);
        System.out.println("========READ DONE========");
        et.begin();
        getter.setName("updatedLikhith");
        em.persist(getter);
        et.commit();
        System.out.println(getter);
        System.out.println("========UPDATE DONE========");
        et.begin();
        getter=em.find(Employee.class,1);
        em.remove(getter);
        et.commit();
        getter=em.find(Employee.class,1);
        System.out.println(getter);
        System.out.println("========DELETE DONE========");
    }
}
