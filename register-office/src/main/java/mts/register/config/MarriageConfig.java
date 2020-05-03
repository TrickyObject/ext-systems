package mts.register.config;

import mts.register.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Специльный класс-бин. Может конфигурировать бины в виде кода
 * Нужна аннотация @Autowired
 */
@Configuration
@PropertySource(value = "classpath:/register.properties")
public class MarriageConfig {

    @Bean
    public PersonDao buildPersonDao() {
        System.out.println("PersonDao created");
        return new PersonDao();
    }
}
