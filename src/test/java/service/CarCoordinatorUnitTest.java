package service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import Kodluyoruz.RentACarProject.business.concretes.CarManager;
import Kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.repository.CarRepository;

@ExtendWith(MockitoExtension.class)
public class CarCoordinatorUnitTest {

	@InjectMocks
	CarManager carManager;

	@Mock
	CarRepository carRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveCarTest() {
		CarRequestDto carRequestDto = mock(CarRequestDto.class);
		carRequestDto.setId(2);

		Car carMock = mock(Car.class);
		carMock.setId(1);
		when(modelMapper.map(carRequestDto, Car.class)).thenReturn(carMock);
		when(carRepository.save(carMock)).thenReturn(carMock);
		Integer carSaveSuccess = carManager.saveCar(carRequestDto);

		Assertions.assertEquals(0, carSaveSuccess);
	}

	@Test
	void deleteCarByIdTest() {
		Car carMock = mock(Car.class);
		carMock.setId(1);

		when(carRepository.findById(carMock.getId())).thenReturn(Optional.of(carMock));
		boolean delete = carManager.deleteCarById(carMock.getId());

		Assertions.assertEquals(true, delete);
	}

}
