package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.entities.Car;
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

    public List<Car> findAllCars(){
        return carRepository.findAll();
    }

    public Car findById(long id){
        Optional<Car> foundCar = carRepository.findById(id);
        return foundCar.orElse(null);
    }
}
