package Kodluyoruz.RentACarProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodluyoruz.RentACarProject.business.abstracts.FuelTypeService;
import Kodluyoruz.RentACarProject.dto.requestDtos.FuelTypeRequestDto;

@RestController
@RequestMapping("/fuelTypes")
public class FuelTypesController {
	
	@Autowired
	private FuelTypeService fuelTypeService;
	
	@PostMapping("/saveFuelType")
	public ResponseEntity<Integer> saveFuelType(@RequestBody FuelTypeRequestDto fuelTypeRequestDto) {
		Integer fuelTypeId = fuelTypeService.saveFuelType(fuelTypeRequestDto);
		return new ResponseEntity<>(fuelTypeId, HttpStatus.OK);
	}
}
