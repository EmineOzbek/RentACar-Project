package Kodluyoruz.RentACarProject.business.abstracts;

import Kodluyoruz.RentACarProject.dto.requestDtos.FuelTypeRequestDto;

public interface FuelTypeService {

	Integer saveFuelType(FuelTypeRequestDto fuelTypeRequestDto);

}
