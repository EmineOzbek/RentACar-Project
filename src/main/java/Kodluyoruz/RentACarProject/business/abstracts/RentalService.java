package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.RentalResponseDto;

public interface RentalService {

	Integer saveRental(RentalRequestDto rentalRequestDto);

	List<RentalResponseDto> findAllRentals();

	List<RentalResponseDto> findAllRentalsById(Integer carId);

	boolean deleteRentalById(Integer rentalId);

}
