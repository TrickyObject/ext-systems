package mts.register.dao;

import mts.register.domain.Person;

import javax.persistence.*;
import java.util.List;

public class PersonDao {

//        em.persist(); //сохранить новое
//        em.merge(); // обновление
//        em.remove(); // удаление

    // при подключении спринга, заполнение менеджера происходит с помощью аннотации
    // описаниек в файле контекста
    // заполнение происходит не в конструкторе
    @PersistenceContext
    private EntityManager em;


    public List<Person> findPerson() {
        // вариант с параметром
        Query query = em.createNamedQuery("Person.findPersons");
        return query.getResultList();
        // вариант без параметра
//        return em.createNamedQuery("Person.findPersons").getResultList();
    }

    public Long addPerson(Person person) {

            em.persist(person);
            em.flush();

        return person.getPersonId();
    }
}
