package Kodluyoruz.RentACarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.Invoice;

@Repository
public interface InvoiceIndividualCustomerRepository extends CrudRepository<Invoice, Integer> {

}
