package org.nagyza.cardealer.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;
    private String type;
    public Car(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Car(Long id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    public Car() {

    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
