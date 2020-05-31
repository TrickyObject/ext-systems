package mts.city.domain.entity;

import org.graalvm.compiler.nodes.StructuredGraph;

import javax.persistence.*;

@Entity
@Table (name = "cr_adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "adress_id")
    private long adressId;
    @Column (name = "district_code")
    private int districtCode;
    @Column (name = "street_code")
    private int street_code;
    @Column (name = "building")
    private String building;
    @Column (name = "extension")
    private String extension;
    // TODO: связь с другими таблицами
    @Column (name = "apartment")
    private String apartment;




    public long getAdressId() {
        return adressId;
    }

    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public int getStreet_code() {
        return street_code;
    }

    public void setStreet_code(int street_code) {
        this.street_code = street_code;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
