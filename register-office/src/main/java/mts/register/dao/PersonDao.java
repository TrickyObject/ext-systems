package mts.register.dao;

import mts.register.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PersonDao {

//        em.persist(); //сохранить новое
//        em.merge(); // обновление
//        em.remove(); // удаление

    private EntityManager em;

    public PersonDao() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        em = factory.createEntityManager();


    }

    public List<Person> findPerson() {
        // вариант с параметром
        Query query = em.createNamedQuery("Person.findPersons");
        query.setParameter("personId",1L);
        return query.getResultList();
        // вариант без параметра
//        return em.createNamedQuery("Person.findPersons").getResultList();
    }
}
