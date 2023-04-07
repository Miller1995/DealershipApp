package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.Car;
import md.miller1995.Dealership.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getCars(){
        return carService.findAllCar();
    }

}
