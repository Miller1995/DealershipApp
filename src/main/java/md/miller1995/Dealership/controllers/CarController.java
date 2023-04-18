package md.miller1995.Dealership.controllers;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable(name = "id") long id){
        CarEntity carEntity = carService.findById(id);
        CarDTO carDTO = carService.carEntityToCarDTO(carEntity);

        return new ResponseEntity<CarDTO>(carDTO, HttpStatus.OK);
    }
}
