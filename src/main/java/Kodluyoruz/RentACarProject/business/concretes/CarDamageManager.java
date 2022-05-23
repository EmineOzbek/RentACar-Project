package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.CarDamageService;
import Kodluyoruz.RentACarProject.dto.requestDtos.CarDamageRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CarDamageResponseDto;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.CarDamage;
import Kodluyoruz.RentACarProject.repository.CarDamageRepository;
import Kodluyoruz.RentACarProject.repository.CarRepository;

@Service
public class CarDamageManager implements CarDamageService {

	@Autowired
	private CarDamageRepository carDamageRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer saveCarDamage(CarDamageRequestDto carDamageRequestDto) {
		CarDamage carDamage = modelMapper.map(carDamageRequestDto, CarDamage.class);
		carDamage = carDamageRepository.save(carDamage);
		return carDamage.getId();
	}

	@Override
	public List<CarDamageResponseDto> findAllCarDamages() {
		Iterable<CarDamage> carDamageList = carDamageRepository.findAll();

		List<CarDamageResponseDto> carDamageResponseDtos = new ArrayList<>();
		for (CarDamage carDamage : carDamageList) {
			CarDamageResponseDto carDamageResponseDto = modelMapper.map(carDamage, CarDamageResponseDto.class);
			carDamageResponseDtos.add(carDamageResponseDto);
		}
		return carDamageResponseDtos;
	}

	@Override
	public List<CarDamageResponseDto> findAllCarDamagesById(Integer carId) {
		Car car = carRepository.findById(carId).get();
		List<CarDamage> carDamageList = carDamageRepository.findAllCarDamagesById(car);

		List<CarDamageResponseDto> carDamageResponseDtos = new ArrayList<>();
		for (CarDamage carDamage : carDamageList) {
			CarDamageResponseDto carDamageResponseDto = modelMapper.map(carDamage, CarDamageResponseDto.class);
			carDamageResponseDtos.add(carDamageResponseDto);
		}
		return carDamageResponseDtos;
	}

	@Override
	public boolean deleteCarDamageById(Integer carDamageId) {
		CarDamage cardamage = carDamageRepository.findById(carDamageId).get();
		carDamageRepository.delete(cardamage);
		return true;
	}

}
