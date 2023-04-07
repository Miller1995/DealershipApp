package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.entities.Car;
import md.miller1995.Dealership.services.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarServiceImp carServiceImp;

    @Autowired
    public CarController(CarServiceImp carServiceImp){
        this.carServiceImp = carServiceImp;
    }

    @GetMapping()
    public List<Car> getCars(){
        return carServiceImp.findAllCars();
    }

}
