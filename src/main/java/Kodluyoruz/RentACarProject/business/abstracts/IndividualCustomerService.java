package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.IndividualCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.IndividualCustomerResponseDto;

public interface IndividualCustomerService {

	Integer saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

	List<IndividualCustomerResponseDto> findAllIndividualCustomers();

	List<IndividualCustomerResponseDto> findAllIndividualCustomersById(Integer rentalId);

	boolean deleteIndividualCustomerById(Integer individualCustomerId);
}
