package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.CorporateCustomerService;
import Kodluyoruz.RentACarProject.dto.requestDtos.CorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.CorporateCustomerResponseDto;
import Kodluyoruz.RentACarProject.entity.CorporateCustomer;
import Kodluyoruz.RentACarProject.entity.Rental;
import Kodluyoruz.RentACarProject.repository.CorporateCustomerRepository;
import Kodluyoruz.RentACarProject.repository.RentalRepository;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	private RentalRepository rentalRepository;
	private ModelMapper modelMapper;

	@Override
	public Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto) {
		CorporateCustomer corporateCustomer = modelMapper.map(corporateCustomerRequestDto, CorporateCustomer.class);
		corporateCustomer = corporateCustomerRepository.save(corporateCustomer);
		return corporateCustomer.getId();
	}

	@Override
	public List<CorporateCustomerResponseDto> findAllCorporateCustomers() {
		Iterable<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();

		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
		for (CorporateCustomer corporateCustomer : corporateCustomerList) {
			CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
			corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
		}
		return corporateCustomerResponseDtos;
	}

	@Override
	public List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId) {
		Rental rental = rentalRepository.findById(rentalId).get();
		List<CorporateCustomer> corporateCustomerList = corporateCustomerRepository
				.findAllCorporateCustomersById(rental);

		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
		for (CorporateCustomer corporateCustomer : corporateCustomerList) {
			CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
			corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
		}
		return corporateCustomerResponseDtos;
	}

	@Override
	public boolean deleteCorporateCustomerById(Integer corporateCustomerId) {
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(corporateCustomerId).get();
		corporateCustomerRepository.delete(corporateCustomer);
		return true;
	}

}
