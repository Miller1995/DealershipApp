package md.miller1995.Dealership.models;

import java.time.LocalDate;

public class Car {
    private long id;
    private String brand;
    private String model;
    private LocalDate dateOfManufactured;
    private float price;
    private String vin;
    private String color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", dateOfManufactured=" + dateOfManufactured +
                ", price=" + price +
                ", vinCode='" + vin + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
