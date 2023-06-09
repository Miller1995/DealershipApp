package md.miller1995.Dealership.units.repositories;

import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.repositories.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;
    private CarEntity carEntity;

    @BeforeEach
    void setUp() {
        //given
        carEntity = new CarEntity(
                1L,
                "Mercedes",
                "A Class",
                "134334VCNY66",
                LocalDate.now(),
                "blue",
                2999
        );
        carRepository.save(carEntity);
    }

    @AfterEach
    void tearDown() {
        carEntity = null;
        carRepository.deleteAll();
    }

    // SUCCEED
    @Test
    void testShouldCheckIfCarEntityWasFindByModel() {
        // when
        List<CarEntity> carEntityList = carRepository.findCarEntityByModel("A Class");
        // then
        assertThat(carEntityList.get(0).getId()).isEqualTo(carEntity.getId());
        assertThat(carEntityList.get(0).getBrand()).isEqualTo(carEntity.getBrand());
    }

    // FAILURE
    @Test
    void testShouldCheckIfCarEntityWasNotFindByModel() {
        // when
        List<CarEntity> carEntityList = carRepository.findCarEntityByModel("B Class");
        //then
        assertThat(carEntityList.isEmpty()).isTrue();
    }
}