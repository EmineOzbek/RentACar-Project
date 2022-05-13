package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.RentalService;
import Kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.RentalResponseDto;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.Rental;
import Kodluyoruz.RentACarProject.repository.CarRepository;
import Kodluyoruz.RentACarProject.repository.RentalRepository;

@Service
public class RentalManager implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	private CarRepository carRepository;
	private ModelMapper modelMapper;

	@Override
	public Integer saveRental(RentalRequestDto rentalRequestDto) {
		Rental rental = modelMapper.map(rentalRequestDto, Rental.class);
		rental = rentalRepository.save(rental);
		return rental.getId();
	}

	@Override
	public List<RentalResponseDto> findAllRentals() {
		Iterable<Rental> rentalList = rentalRepository.findAll();

		List<RentalResponseDto> rentalResponseDtos = new ArrayList<>();
		for (Rental rental : rentalList) {
			RentalResponseDto rentalResponseDto = modelMapper.map(rental, RentalResponseDto.class);
			rentalResponseDtos.add(rentalResponseDto);
		}

		return rentalResponseDtos;
	}

	@Override
	public List<RentalResponseDto> findAllRentalsById(Integer carId) {
		Car car = carRepository.findById(carId).get();
		List<Rental> rentalList = rentalRepository.findAllByCarId(car);

		List<RentalResponseDto> rentalResponseDtos = new ArrayList<>();
		for (Rental rental : rentalList) {
			RentalResponseDto rentalResponseDto = modelMapper.map(rental, RentalResponseDto.class);
			rentalResponseDtos.add(rentalResponseDto);
		}

		return rentalResponseDtos;
	}

	@Override
	public boolean deleteRentalById(Integer rentalId) {
		Rental rental = rentalRepository.findById(rentalId).get();
		rentalRepository.delete(rental);
		return true;
	}

}
