package md.miller1995.Dealership.controllers;

import io.swagger.v3.oas.annotations.Operation;
import md.miller1995.Dealership.models.dto.CarDTO;
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
    @Operation(summary = "Route to find a car by ID", description = "Return a single result")
    public ResponseEntity<CarDTO> getCarById(@PathVariable(name = "id") long id){
        CarDTO carDTO = carService.findById(id);

        return new ResponseEntity<CarDTO>(carDTO, HttpStatus.OK);
    }

    @GetMapping("")
    @Operation(summary = "Route to find all cars by model", description = "Car search by %model% format")
    public ResponseEntity<List<CarDTO>> findAllCarsByModel(@RequestParam(value = "model") String model){
        List<CarDTO> carDTOList = carService.findAllCarsByModel(model);

        return new ResponseEntity<List<CarDTO>>(carDTOList, HttpStatus.OK);
    }
}