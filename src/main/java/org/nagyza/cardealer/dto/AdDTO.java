package org.nagyza.cardealer.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdDTO {

    private final Long id;

    private String brand;

    private String type;

    private String description;

    private Long price;

    private String seller;

    public AdDTO(Long id, String brand, String type, String description, Long price, String seller) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    public Long getId() {
        return id;
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "AdDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                '}';
    }
}
