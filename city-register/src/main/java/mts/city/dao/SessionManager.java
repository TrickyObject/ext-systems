package mts.city.dao;
/**
 Объект отвечает за создание сессий
 Нужно будет создать 1 экземпляр и получать из него сессии
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionManager {

    private static SessionFactory sf;

    public static void main(String[] args) {

        //сделать синглтон
        sf = buildSessionFactory();
//        Session session = sf.openSession();
//        session.getTransaction();


    }

    // сделать сешн фэктори или через хикари
    // сделать метод получения сессии
    private static SessionFactory buildSessionFactory() {

        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry)
                    .getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            System.out.println("Провал создания фабрики сессий.. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Session getSession () {

        return sf.openSession();

    }

}
