package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.CarService;
import Kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CarResponseDto;
import Kodluyoruz.RentACarProject.entity.Brand;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.FuelType;
import Kodluyoruz.RentACarProject.repository.BrandRepository;
import Kodluyoruz.RentACarProject.repository.CarRepository;
import Kodluyoruz.RentACarProject.repository.FuelTypeRepository;

@Service
public class CarManager implements CarService {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer saveCar(CarRequestDto carRequestDto) {
		Car car = modelMapper.map(carRequestDto, Car.class);
		car = carRepository.save(car);
		return car.getId();
	}

	@Override
	public List<CarResponseDto> findAllCars() {
		Iterable<Car> carList = carRepository.findAll();

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}

		return carResponseDtos;
	}

	@Override
	public List<CarResponseDto> findAllCarsByBrandId(Integer brandId) {
		Brand brand = brandRepository.findById(brandId).get();
		List<Car> carList = carRepository.findAllCarsByBrandId(brand);

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}
		return carResponseDtos;
	}
	
	@Override
	public List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId) {
		FuelType fuelType = fuelTypeRepository.findById(fuelTypeId).get();
		List<Car> carList = carRepository.findAllCarsByFuelTypeId(fuelType);

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}
		return carResponseDtos;
	}

	@Override
	public boolean deleteCarById(Integer carId) {
		Car car = carRepository.findById(carId).get();
		carRepository.delete(car);
		return true;
	}

}
