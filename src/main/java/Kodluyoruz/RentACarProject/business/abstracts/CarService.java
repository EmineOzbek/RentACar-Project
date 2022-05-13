package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CarResponseDto;

public interface CarService {

	Integer saveCar(CarRequestDto carRequestDto);

	List<CarResponseDto> findAllCars();

	List<CarResponseDto> findAllCarsByBrandId(Integer brandId);

	List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId);

	boolean deleteCarById(Integer carId);

}
