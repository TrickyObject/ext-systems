package mts.student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRegisterDao {

    private EntityManagerFactory emf;

    // сделать через аннотацию? javaee?
    // @PersistenceContext
    public StudentRegisterDao() {
        emf = Persistence
                .createEntityManagerFactory("persistence");

    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }


}
