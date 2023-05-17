package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;

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
    CarDTO findById(long id);

    /**
     *
     * @author Anton Nirca
     * @since 26/04/2023
     *
     * @param model
     * @return
     */
    List<CarDTO> findAllCarsByModel(String model);
}
