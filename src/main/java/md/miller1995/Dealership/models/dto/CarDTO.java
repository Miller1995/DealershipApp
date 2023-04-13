package md.miller1995.Dealership.models.dto;

import java.io.Serializable;
import java.time.LocalDate;


public class CarDTO implements Serializable {
    private String brand;
    private String model;
    private LocalDate dateOfManufactured;
    private String color;
    private float price;

    public CarDTO(){}

    public CarDTO (String brand, String model, LocalDate dateOfManufactured, String color, float price){
        this.brand = brand;
        this.model = model;
        this.dateOfManufactured = dateOfManufactured;
        this.color = color;
        this.price = price;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getDateOfManufactured() {
        return dateOfManufactured;
    }

    public void setDateOfManufactured(LocalDate dateOfManufactured) {
        this.dateOfManufactured = dateOfManufactured;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
