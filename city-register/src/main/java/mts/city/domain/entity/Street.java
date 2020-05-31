package mts.city.domain.entity;

import javax.persistence.Column;

public class Street {

    @Column(name = "street_code")
    private int streetCode;
    @Column (name = "street_name")
    private  String streetName;


}
