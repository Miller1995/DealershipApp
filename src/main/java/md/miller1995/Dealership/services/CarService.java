package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;

import java.util.List;

public interface CarService {


    /** Method that find an object Car by and ID
     *
     * @author Anton Nirca
     * @since 18/04/2023
     *
     * @param id
     * @return object Car or null
     */
    CarEntity findById(long id);


    /**
     *
     * @author Anton Nirca
     * @since 26/04/2023
     *
     * @param model
     * @return
     */
    List<CarDTO> findAllCarsByModel(String model);


    /** Method that allowed mapping object from CarEntity to CarDTO, using Model Mapper
     *
     * @author Anton Nirca
     * @since 18/04/2023
     *
     * @param carEntity
     * @return object CarDTO
     */
    CarDTO carEntityToCarDTO(CarEntity carEntity);


    /** Method that allowed mapping list of objects from CarEntity to CarDTO, using Model Mapper
     *
     * @author Anton Nirca
     * @since 26/04/2023
     *
     * @param carEntityList
     * @return list of objects CarDTO
     */
    List<CarDTO> carEntityListToCarDTOList(List<CarEntity> carEntityList);
}
