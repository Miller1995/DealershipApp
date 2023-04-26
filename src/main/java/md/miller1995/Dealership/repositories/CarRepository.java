package md.miller1995.Dealership.repositories;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    // TODO custom query if is necessary

    /** This method create a custom query, that select all data from table after parameter/column "model"
     *
     * @author Anton Nirca
     * @since 26/04/2023
     *
     * @param model
     * @return list of objects CarEntity
     */
    List<CarEntity> findCarEntityByModel(String model);
}
