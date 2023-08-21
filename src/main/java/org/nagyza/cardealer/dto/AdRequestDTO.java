package org.nagyza.cardealer.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdRequestDTO {

    @NotBlank(message = "Brand field must be filled!")
    @Size(min = 1, max = 20, message = "Invalid field: brand. Size must be between 1 and 20 character(s)!")
    private String brand;

    @NotBlank(message = "Type field must be filled!")
    @Size(min = 1, max = 20, message = "Invalid field: brand. Size must be between 1 and 20 character(s)!")
    private String type;

    @Size(max = 200, message = "Invalid field: description. Can not be longer than 200 characters!")
    private String description;

    @NotNull(message = "Price field must be filled!")
    @Max(value = 9999999999L, message = "Invalid field: price. Can not be bigger than 9 999 999 999!")
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
