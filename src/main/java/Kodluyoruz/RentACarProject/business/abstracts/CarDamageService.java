package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.CarDamageRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CarDamageResponseDto;

public interface CarDamageService {

	Integer saveCarDamage(CarDamageRequestDto carDamageRequestDto);

	List<CarDamageResponseDto> findAllCarDamages();

	List<CarDamageResponseDto> findAllCarDamagesById(Integer carId);

	boolean deleteCarDamageById(Integer carDamageId);

}
