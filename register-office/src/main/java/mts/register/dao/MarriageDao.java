package mts.register.dao;

import mts.register.domain.MarriageCert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Component // аналог service аннотации. То, что должно быть загружено // spring
@Repository // //spring-data-JPA
public interface MarriageDao extends JpaRepository<MarriageCert, Long> {

    // 1) в спринг дата можно оперировать наименованиями методов для того, чтобы доставать данные из таблиц
    // findByNumber + Containing = findByNumberContaining см. доку
    // 2) доставать данные с помощью нейминга
    // 2.1 и 2.2 - HQL - named query.  Нэймед квери в классе, неймед квери в вызове (ЪУЪ!)

    //1
    List<MarriageCert> findByNumber(String number);
    //2.1
    List<MarriageCert> findByNum(@Param("number") String number);
    //2.2
    @Query("SELECT mc FROM MarriageCert mc WHERE mc.number = :number")
    List<MarriageCert> findSomething(@Param("number") String number);


}

/*

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;
    // сделать запрос к сертификату, который включает все необходимые поля

    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCert findMarriageCert(MarriageRequest request) {
        LOGGER.info("findMarriageCert called.. " + test);

        // TODO
        return new MarriageCert();
    }
 */