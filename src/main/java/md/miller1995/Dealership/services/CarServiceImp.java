package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImp(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarEntity findById(long id){
        Optional<CarEntity> foundCar = carRepository.findById(id);
        return foundCar.orElse(null);
    }

    @Override
    public List<CarDTO> findAllCarsByModel(String model) {
        List<CarEntity> carEntityList = carRepository.findCarEntityByModel(model);
        List<CarDTO> carDTOList = carEntityListToCarDTOList(carEntityList);

        return carDTOList;
    }

    @Override
    public CarDTO carEntityToCarDTO(CarEntity carEntity) {
        return modelMapper.map(carEntity, CarDTO.class);
    }

    @Override
    public List<CarDTO> carEntityListToCarDTOList(List<CarEntity> carEntityList){
        return carEntityList
                .stream()
                .map(cars -> modelMapper.map(cars, CarDTO.class))
                .collect(Collectors.toList());
    }
}
