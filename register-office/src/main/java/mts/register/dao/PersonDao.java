package mts.register.dao;

import mts.register.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonDao {

    private EntityManager em;

    public PersonDao() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        em = factory.createEntityManager();

    }

    public List<Person> findPerson() {

        return em.createQuery("SELECT p FROM Person p").getResultList();
    }
}
