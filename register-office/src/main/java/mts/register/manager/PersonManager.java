package mts.register.manager;

import mts.register.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class PersonManager {

    public static void main(String[] args) {

        System.out.println("======= Factory ===========");
        SessionFactory sf = buildSessionFactory();

        // втсавка объекта
        System.out.println("======= Session ===========");
        Session session = sf.openSession();
        session.getTransaction().begin();

        System.out.println("======= Person ===========");
        Person person = new Person();
        person.setFirstName("Василий");
        person.setLastName("Сидоров");
        // Work just like insert. In return serializble;
        Long id = (Long) session.save(person);
        System.out.println("Added with id = " + id);
        // есть соответственнои роллбэк
        session.getTransaction().commit();
        session.close();

        // Читаем то, что втсавили. Транзацкию можно не делать, поскольку происходит чтение
        session = sf.openSession();
        Person person1 = session.get(Person.class, id);
        System.out.println(person1);
        session.close();

        // выборка всех данных на языке HQL. H for Hibernate :D
        // второй аргумент опионален
        System.out.println("======= LIST ==========");
        session = sf.openSession();
        List<Person> list = session.createQuery("FROM Person", Person.class).list();
        list.forEach(p -> System.out.println(p));
        session.close();

        session.delete;

    }


    private static SessionFactory buildSessionFactory() {

        // SessionFactory позволяет получать аналог коннектов к БД
         try {
             // сервис для регистрации в хибернейте. Хибернейт работает через него
             StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                     // конфиг для построения сервиса по описанию. Можно без аргумента, будет искаться по дефолту
                     .configure("hibernate.cfg.xml")
                     .build();
             // метаданные для построения барики сессий
             Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

             return metadata.getSessionFactoryBuilder().build();
         } catch (Throwable ex) {

             System.out.println("Init fail: " + ex);
             throw new ExceptionInInitializerError(ex);
         }
    }
}
