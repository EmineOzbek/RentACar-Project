package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.InvoiceResponseDto;

public interface InvoiceService {

	Integer saveInvoiceCorporateCustomer(InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto);

	Integer saveInvoiceIndividualCustomer(InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto);

	List<InvoiceResponseDto> findAllInvoices();

	List<InvoiceResponseDto> findAllInvoicesByCorporateCustomerId(Integer CorporateCustomerId);

	List<InvoiceResponseDto> findAllInvoicesByIndividualCustomerId(Integer IndividualCustomerId);

	boolean deleteInvoiceById(Integer invoiceId);

}
