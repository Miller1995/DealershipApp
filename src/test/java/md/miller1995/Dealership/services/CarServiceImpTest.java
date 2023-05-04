package md.miller1995.Dealership.services;

import md.miller1995.Dealership.models.dto.CarDTO;
import md.miller1995.Dealership.models.entities.CarEntity;
import md.miller1995.Dealership.repositories.CarRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceImpTest {

    // read about @ExtendWith(MockitoExtension.class) , @Mock , MockitoAnnotations.openMocks(this) and AutoCloseable , autoCloseable.close()
    private final CarRepository carRepository = Mockito.mock(CarRepository.class);  // alternative can be with -> @Mock
    private ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
    private final CarServiceImp carServiceImp = new CarServiceImp(carRepository, modelMapper); // read about alternative -> @InjectMock

    /*  if I want to use @Mock and @InjectionMock annotations,
        I need to create method After -> tearDown for close mocks
        and Before -> setUp for open Mocks
     */

    @Test
    public void testShouldFindCarEntityById(){
        //given
        CarEntity newCarEntity =  new CarEntity(
                1L,
                "Mercedes",
                "A Class",
                "134334VCNY66",
                LocalDate.now(),
                "blue",
                2999
        );
        //when
        carServiceImp.findById(newCarEntity.getId());
        //then
        verify(carRepository).findById(newCarEntity.getId());
    }

    @Test
    void testShouldFindAllCarsByModel() {
        //given
        CarEntity newCarEntity =  new CarEntity(
                1L,
                "Mercedes",
                "A Class",
                "134334VCNY66",
                LocalDate.now(),
                "blue",
                2999
        );
        //when
        carServiceImp.findAllCarsByModel(newCarEntity.getModel());
        //then
        verify(carRepository).findCarEntityByModel(newCarEntity.getModel());
    }

    @Test
    void testShouldConvertCarEntityToCarDTO() {
        //given
        CarEntity carEntity = new CarEntity(
                1L,
                "Mercedes",
                "A Class",
                "134334VCNY66",
                LocalDate.now(),
                "blue",
                2999
        );
        CarDTO carDTO = new CarDTO("Mercedes",
                "A Class",
                LocalDate.now(),
                "blue",
                2999
        );
        when(modelMapper.map(carEntity, CarDTO.class)).thenReturn(carDTO);
        //when
        CarDTO carToCompare = carServiceImp.carEntityToCarDTO(carEntity);
        //then
        assertThat(carDTO).isEqualTo(carToCompare);
    }

    @Test
    @Disabled
    void testShouldConvertCarEntityListToCarDTOList() {
    }
}
