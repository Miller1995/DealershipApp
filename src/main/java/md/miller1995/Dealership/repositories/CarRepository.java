package md.miller1995.Dealership.repositories;

import md.miller1995.Dealership.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    // TODO custom query if is necessary
}
