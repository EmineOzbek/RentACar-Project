package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.InvoiceService;
import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import Kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;

import Kodluyoruz.RentACarProject.dto.responseDtos.InvoiceResponseDto;
import Kodluyoruz.RentACarProject.entity.CorporateCustomer;
import Kodluyoruz.RentACarProject.entity.IndividualCustomer;
import Kodluyoruz.RentACarProject.entity.Invoice;
import Kodluyoruz.RentACarProject.repository.CorporateCustomerRepository;
import Kodluyoruz.RentACarProject.repository.IndividualCustomerRepository;
import Kodluyoruz.RentACarProject.repository.InvoiceCorporateCustomerRepository;
import Kodluyoruz.RentACarProject.repository.InvoiceIndividualCustomerRepository;
import Kodluyoruz.RentACarProject.repository.InvoiceRepository;

@Service
public class InvoiceManager implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;
	@Autowired
	private InvoiceCorporateCustomerRepository invoiceCorporateCustomerRepository;
	@Autowired
	private InvoiceIndividualCustomerRepository invoiceIndividualCustomerRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer saveInvoiceCorporateCustomer(InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto) {
		Invoice invoiceCorporateCustomer = modelMapper.map(invoiceCorporateCustomerRequestDto, Invoice.class);
		invoiceCorporateCustomer = invoiceCorporateCustomerRepository.save(invoiceCorporateCustomer);
		return invoiceCorporateCustomer.getId();
	}

	@Override
	public Integer saveInvoiceIndividualCustomer(InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto) {
		Invoice invoiceIndividualCustomer = modelMapper.map(invoiceIndividualCustomerRequestDto, Invoice.class);
		invoiceIndividualCustomer = invoiceIndividualCustomerRepository.save(invoiceIndividualCustomer);
		return invoiceIndividualCustomer.getId();
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoices() {
		Iterable<Invoice> invoiceList = invoiceRepository.findAll();

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoicesByCorporateCustomerId(Integer CorporateCustomerId) {
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(CorporateCustomerId).get();
		List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByCorporateCustomerId(corporateCustomer);

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoicesByIndividualCustomerId(Integer IndividualCustomerId) {
		IndividualCustomer individualCustomer = individualCustomerRepository.findById(IndividualCustomerId).get();
		List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByIndividualCustomerId(individualCustomer);

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public boolean deleteInvoiceById(Integer invoiceId) {
		Invoice invoice = invoiceRepository.findById(invoiceId).get();
		invoiceRepository.delete(invoice);
		return true;
	}

}
