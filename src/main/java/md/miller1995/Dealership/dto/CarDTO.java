package md.miller1995.Dealership.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class CarDTO {
    private String brand;
    private String model;
    private LocalDate dateOfManufactured;
    private String color;
}
