package md.miller1995.Dealership.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "vin")
    private String vin;
    @Column(name = "date_of_manufactured")
    private LocalDate dateOfManufactured;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private float price;
}
