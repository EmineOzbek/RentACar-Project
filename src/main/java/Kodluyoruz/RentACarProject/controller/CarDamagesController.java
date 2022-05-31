package Kodluyoruz.RentACarProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodluyoruz.RentACarProject.business.abstracts.CarDamageService;
import Kodluyoruz.RentACarProject.dto.requestDtos.CarDamageRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CarDamageResponseDto;

@RestController
@RequestMapping("/carDamages")
public class CarDamagesController {

	private CarDamageService carDamageService;

	@Autowired
	public CarDamagesController(CarDamageService carDamageService) {
		super();
		this.carDamageService = carDamageService;
	}

	@PostMapping("/saveCarDamage")
	public ResponseEntity<Integer> saveCarDamage(@RequestBody CarDamageRequestDto carDamageRequestDto) {
		Integer carDamageId = carDamageService.saveCarDamage(carDamageRequestDto);
		return new ResponseEntity<>(carDamageId, HttpStatus.OK);
	}

	@GetMapping("/findAllCarDamages")
	public ResponseEntity<List<CarDamageResponseDto>> findAllCarDamages() {
		List<CarDamageResponseDto> carDamageResponseDtos = carDamageService.findAllCarDamages();
		return new ResponseEntity<>(carDamageResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllCarDamagesById")
	public ResponseEntity<List<CarDamageResponseDto>> findAllCarDamagesById(@RequestParam Integer carId) {
		List<CarDamageResponseDto> carDamageResponseDtos = carDamageService.findAllCarDamagesById(carId);
		return new ResponseEntity<>(carDamageResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCarDamageById")
	public ResponseEntity<Boolean> deleteCarDamageById(@RequestParam Integer carDamageId) {
		boolean delete = carDamageService.deleteCarDamageById(carDamageId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
