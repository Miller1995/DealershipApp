package md.miller1995.Dealership.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements Serializable {

    private String brand;
    private String model;
    private LocalDate createdAt;
    private String color;
    private float price;
}

