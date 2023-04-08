package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.entities.Car;
import md.miller1995.Dealership.services.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable(name = "id") long id){
        /* Because we need to transport this object trough internet,
            we need to mapper this object initial and
            after sent object like response in get request...
            ( need build 2 methods in Service, these methods will mapper object -> convertedToCarDTO and convertedToCar)
         */
        return carServiceImp.findOneCar(id);
    }

}
