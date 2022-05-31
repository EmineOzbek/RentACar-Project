package service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import Kodluyoruz.RentACarProject.business.concretes.RentalManager;
import Kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import Kodluyoruz.RentACarProject.entity.Rental;
import Kodluyoruz.RentACarProject.repository.RentalRepository;

@ExtendWith(MockitoExtension.class)
public class RentalCoordinatorUnitTest {

	@InjectMocks
	RentalManager rentalManager;

	@Mock
	RentalRepository rentalRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveRentalTest() {
		RentalRequestDto rentalRequestDto = mock(RentalRequestDto.class);
		rentalRequestDto.setId(2);

		Rental rentalMock = mock(Rental.class);
		rentalMock.setId(1);
		when(modelMapper.map(rentalRequestDto, Rental.class)).thenReturn(rentalMock);
		when(rentalRepository.save(rentalMock)).thenReturn(rentalMock);
		Integer rentalSaveSuccess = rentalManager.saveRental(rentalRequestDto);

		Assertions.assertEquals(0, rentalSaveSuccess);
	}

	@Test
	void deleteRentalByIdTest() {
		Rental rentalMock = mock(Rental.class);
		rentalMock.setId(1);

		when(rentalRepository.findById(rentalMock.getId())).thenReturn(Optional.of(rentalMock));
		boolean delete = rentalManager.deleteRentalById(rentalMock.getId());

		Assertions.assertEquals(true, delete);
	}
}
