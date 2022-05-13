package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.responseDtos.CustomerResponseDto;

public interface CustomerService {

	List<CustomerResponseDto> findAllCustomers();

}
