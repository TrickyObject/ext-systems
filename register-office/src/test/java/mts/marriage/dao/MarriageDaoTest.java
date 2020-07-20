package mts.marriage.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MarriageDaoTest {

    EntityManager entityManager;

    @Before
    public void getEntityManager() {

        MarriageDao dao = new MarriageDao();
        entityManager = dao.getEntityManager();
    }

    @Test
    public void checkEntityManager() {

        Assert.assertTrue(entityManager != null);

    }

    @Ignore
    @Test
    public void init() {

        URL url = this.getClass().getResource("/ro.sql");
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Paths.get(url.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String sql = strings.stream().collect(Collectors.joining());
        Query query = entityManager.createQuery(sql);
        List resultList = query.getResultList();
        entityManager.close();

        Assert.assertTrue(resultList != null);

    }

}