package org.example.jpaexam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaRun {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User("carami", "carami@gmail.com");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
//        System.out.println("실행전");
//        entityManager.persist(user);
//        System.out.println("실행후");
    }
}
