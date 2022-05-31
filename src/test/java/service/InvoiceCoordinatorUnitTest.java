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

import Kodluyoruz.RentACarProject.business.concretes.InvoiceManager;
import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;
import Kodluyoruz.RentACarProject.entity.Invoice;
import Kodluyoruz.RentACarProject.repository.InvoiceCorporateCustomerRepository;
import Kodluyoruz.RentACarProject.repository.InvoiceIndividualCustomerRepository;
import Kodluyoruz.RentACarProject.repository.InvoiceRepository;

@ExtendWith(MockitoExtension.class)
public class InvoiceCoordinatorUnitTest {

	@InjectMocks
	InvoiceManager invoiceManager;

	@Mock
	InvoiceRepository invoiceRepository;
	@Mock
	InvoiceCorporateCustomerRepository invoiceCorporateCustomerRepository;
	@Mock
	InvoiceIndividualCustomerRepository invoiceIndividualCustomerRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveInvoiceCorporateCustomerSaveTest() {
		InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto = mock(InvoiceCorporateCustomerRequestDto.class);
		invoiceCorporateCustomerRequestDto.setId(2);

		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);
		when(modelMapper.map(invoiceCorporateCustomerRequestDto, Invoice.class)).thenReturn(invoiceMock);
		when(invoiceCorporateCustomerRepository.save(invoiceMock)).thenReturn(invoiceMock);
		Integer invoiceCorporateCustomerSaveSuccess = invoiceManager.saveInvoiceCorporateCustomer(invoiceCorporateCustomerRequestDto);

		Assertions.assertEquals(0, invoiceCorporateCustomerSaveSuccess);
	}

	@Test
	void saveInvoiceIndividualCustomerSaveTest() {
		InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto = mock(InvoiceIndividualCustomerRequestDto.class);
		invoiceIndividualCustomerRequestDto.setId(2);

		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);
		when(modelMapper.map(invoiceIndividualCustomerRequestDto, Invoice.class)).thenReturn(invoiceMock);
		when(invoiceIndividualCustomerRepository.save(invoiceMock)).thenReturn(invoiceMock);
		Integer invoiceIndividualCustomerSaveSuccess = invoiceManager.saveInvoiceIndividualCustomer(invoiceIndividualCustomerRequestDto);

		Assertions.assertEquals(0, invoiceIndividualCustomerSaveSuccess);
	}

	@Test
	void deleteInvoiceByIdTest() {
		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);

		when(invoiceRepository.findById(invoiceMock.getId())).thenReturn(Optional.of(invoiceMock));
		boolean delete = invoiceManager.deleteInvoiceById(invoiceMock.getId());

		Assertions.assertEquals(true, delete);
	}
}
