package md.miller1995.Dealership.controllers;

import io.swagger.v3.oas.annotations.Operation;
import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/{id}")
    @Operation(description = "route to find a car by ID")
    public ResponseEntity<CarDTO> getCarById(@PathVariable(name = "id") long id){
        CarEntity carEntity = carService.findById(id);
        CarDTO carDTO = carService.carEntityToCarDTO(carEntity);

        return new ResponseEntity<CarDTO>(carDTO, HttpStatus.OK);
    }

    @GetMapping("")
    @Operation(description = "Route to find all cars by model")
    public ResponseEntity<List<CarDTO>> findAllCarsByModel(@RequestParam(value = "model") String model){
        List<CarDTO> carDTOList = carService.findAllCarsByModel(model);

        return new ResponseEntity<List<CarDTO>>(carDTOList, HttpStatus.OK);
    }
}
