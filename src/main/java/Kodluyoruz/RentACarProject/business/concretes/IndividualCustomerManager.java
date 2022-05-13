package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.IndividualCustomerService;
import Kodluyoruz.RentACarProject.dto.requestDtos.IndividualCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.IndividualCustomerResponseDto;
import Kodluyoruz.RentACarProject.entity.IndividualCustomer;
import Kodluyoruz.RentACarProject.entity.Rental;
import Kodluyoruz.RentACarProject.repository.IndividualCustomerRepository;
import Kodluyoruz.RentACarProject.repository.RentalRepository;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;
	private RentalRepository rentalRepository;
	private ModelMapper modelMapper;

	@Override
	public Integer saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto) {
		IndividualCustomer individualCustomer = modelMapper.map(individualCustomerRequestDto, IndividualCustomer.class);
		individualCustomer = individualCustomerRepository.save(individualCustomer);
		return individualCustomer.getId();
	}

	@Override
	public List<IndividualCustomerResponseDto> findAllIndividualCustomers() {
		Iterable<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAll();

		List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();
		for (IndividualCustomer individualCustomer : individualCustomerList) {
			IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
			individualCustomerResponseDtos.add(individualCustomerResponseDto);
		}
		return individualCustomerResponseDtos;

	}

	@Override
	public List<IndividualCustomerResponseDto> findAllIndividualCustomersById(Integer rentalId) {
		Rental rental = rentalRepository.findById(rentalId).get();
		List<IndividualCustomer> individualCustomerList = individualCustomerRepository
				.findAllIndividualCustomersById(rental);

		List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();
		for (IndividualCustomer individualCustomer : individualCustomerList) {
			IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
			individualCustomerResponseDtos.add(individualCustomerResponseDto);
		}
		return individualCustomerResponseDtos;
	}

	@Override
	public boolean deleteIndividualCustomerById(Integer individualCustomerId) {
		IndividualCustomer individualCustomer = individualCustomerRepository.findById(individualCustomerId).get();
		individualCustomerRepository.delete(individualCustomer);
		return true;
	}

}
