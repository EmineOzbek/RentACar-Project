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

import Kodluyoruz.RentACarProject.business.abstracts.CorporateCustomerService;
import Kodluyoruz.RentACarProject.dto.requestDtos.CorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CorporateCustomerResponseDto;

@RestController
@RequestMapping("/corporateCustomers")
public class CorporateCustomersController {

	private CorporateCustomerService corporateCustomerService;

	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		super();
		this.corporateCustomerService = corporateCustomerService;
	}

	@PostMapping("/saveCorporateCustomer")
	public ResponseEntity<Integer> saveCorporateCustomer(@RequestBody CorporateCustomerRequestDto corporateCustomerRequestDto) {
		Integer corporateCustomerId = corporateCustomerService.saveCorporateCustomer(corporateCustomerRequestDto);
		return new ResponseEntity<>(corporateCustomerId, HttpStatus.OK);
	}

	@GetMapping("/findAllCorporateCustomers")
	public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomers() {
		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomers();
		return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllCorporateCustomersById")
	public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomersById(@RequestParam Integer rentalId) {
		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomersById(rentalId);
		return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCorporateCustomerById")
	public ResponseEntity<Boolean> deleteCorporateCustomerById(@RequestParam Integer corporateCustomerId) {
		boolean delete = corporateCustomerService.deleteCorporateCustomerById(corporateCustomerId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
