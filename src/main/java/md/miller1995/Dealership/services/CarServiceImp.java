package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarEntity> findAllCars(){
        return carRepository.findAll();
    }

    public CarEntity findById(long id){
        Optional<CarEntity> foundCar = carRepository.findById(id);
        return foundCar.orElse(null);
    }

    @Override
    public CarDTO CarEntityToCarDTO(CarEntity carEntity) {
        CarDTO carDTO = new CarDTO();
        carDTO.setModel(carEntity.getModel());
        carDTO.setBrand(carEntity.getBrand());
        carDTO.setColor(carEntity.getColor());
        carDTO.setDateOfManufactured(carEntity.getDateOfManufactured());
        carDTO.setPrice(carEntity.getPrice());
        return carDTO;
    }
}
