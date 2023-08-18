package org.nagyza.cardealer.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdRequestDTO {

    @NotNull
    @Size(min = 1, max = 20)
    private String brand;

    @NotNull
    @Size(min = 1, max = 20)
    private String type;

    @Size(max = 200)
    private String description;

    @NotNull
    @Max(value = 9999999999L)
    private Long price;

    public AdRequestDTO(String brand, String type, String description, Long price) {
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdRequestDTO{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
