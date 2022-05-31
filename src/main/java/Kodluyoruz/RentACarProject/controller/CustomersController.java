package Kodluyoruz.RentACarProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodluyoruz.RentACarProject.business.abstracts.CustomerService;
import Kodluyoruz.RentACarProject.dto.responseDtos.CustomerResponseDto;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/findAllCustomers")
	public ResponseEntity<List<CustomerResponseDto>> findAllCustomers() {
		List<CustomerResponseDto> customerResponseDtos = customerService.findAllCustomers();
		return new ResponseEntity<>(customerResponseDtos, HttpStatus.OK);
	}

}
