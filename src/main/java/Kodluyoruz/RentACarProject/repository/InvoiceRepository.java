package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Kodluyoruz.RentACarProject.entity.CorporateCustomer;
import Kodluyoruz.RentACarProject.entity.IndividualCustomer;
import Kodluyoruz.RentACarProject.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

	List<Invoice> findAllInvoicesByCorporateCustomerId(CorporateCustomer corporateCustomer);
	
	List<Invoice> findAllInvoicesByIndividualCustomerId(IndividualCustomer individualCustomer);

}
