package mts.marriage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarriageDao {

    private EntityManagerFactory emf;

    // сделать через аннотацию? javaee?
    // @PersistenceContext
    public MarriageDao() {
        emf = Persistence
                .createEntityManagerFactory("persistence");

    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }


}
