package mts.student.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс-адаптер.
 * Отвечает за перевод даты в строку и обратно
 * Наследуется от XmlAdapter, нужно указать, что будет конвертироваться, как в дженерике
 *     Поле, которое использует адаптер аннотируется
 *     @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final Logger logger = LoggerFactory.getLogger(LocalDateAdapter.class);

    private static final String PATTERN = "dd.MM.yyyy";

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        logger.info("Unmarshalling JSON date: " + s + " to: " + LocalDate.parse(s, DateTimeFormatter.ofPattern(PATTERN)));
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(PATTERN));
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        logger.info("Unmarshalling JSON date: " + localDate + " to: " + localDate.format(DateTimeFormatter.ofPattern(PATTERN)));
        return localDate.format(DateTimeFormatter.ofPattern(PATTERN));
    }
}
