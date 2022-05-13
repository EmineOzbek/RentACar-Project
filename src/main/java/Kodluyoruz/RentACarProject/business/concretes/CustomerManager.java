package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.CustomerService;
import Kodluyoruz.RentACarProject.dto.responseDtos.CustomerResponseDto;
import Kodluyoruz.RentACarProject.entity.Customer;
import Kodluyoruz.RentACarProject.repository.CustomerRepository;

@Service
public class CustomerManager implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;

	@Override
	public List<CustomerResponseDto> findAllCustomers() {
		Iterable<Customer> customerList = customerRepository.findAll();

		List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
		for (Customer customer : customerList) {
			CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
			customerResponseDtos.add(customerResponseDto);
		}
		return customerResponseDtos;
	}

}
