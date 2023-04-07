package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> findAllCars();
}
