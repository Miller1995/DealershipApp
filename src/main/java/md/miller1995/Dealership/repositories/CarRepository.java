package md.miller1995.Dealership.repositories;

import md.miller1995.Dealership.models.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
    // TODO custom query if is necessary
}
