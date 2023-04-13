package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;

import java.util.List;

public interface CarService {

    List<CarEntity> findAllCars();
    CarEntity findById(long id);
    CarDTO carEntityToCarDTO(CarEntity carEntity);
}
