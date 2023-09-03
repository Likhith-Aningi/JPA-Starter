package com.likhith;

import com.likhith.entity.Employee;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

public class JPQLExample {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpaStarter");
        EntityManager em=emf.createEntityManager();
        //un typed
        Query query=em.createQuery("SELECT e.name FROM Employee e ORDER BY e.name DESC");
        List resultList=query.getResultList();
        resultList.forEach(System.out::println);

        //typed
        TypedQuery<Employee> typedQuery=em.createQuery("SELECT e FROM Employee e  ORDER BY e.name ",Employee.class);
        List<Employee> typedResultList=typedQuery.getResultList();
        typedResultList.forEach(System.out::println);
    }
}
