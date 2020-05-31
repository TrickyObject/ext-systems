package mts.city.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class AdressPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_adress_id")
    private long personAdressId;
    @Column (name = "adress_id")
    private int adressId;
    @Column (name = "person_id")
    private int personId;
    @Column (name = "start_date")
    private LocalDate startDate;
    @Column (name = "end_date")
    private LocalDate endDate;
    @Column (name = "temporal")
    private boolean temporal;


}
