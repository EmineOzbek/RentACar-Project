package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.CorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CorporateCustomerResponseDto;

public interface CorporateCustomerService {

	Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto);

	List<CorporateCustomerResponseDto> findAllCorporateCustomers();

	List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId);

	boolean deleteCorporateCustomerById(Integer corporateCustomerId);

}
