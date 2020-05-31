package mts.city.domain.entity;

import javax.persistence.Column;

public class District {

    @Column(name = "district_code")
    private int districtCode;
    @Column (name = "district_name")
    private String districtName;


}
