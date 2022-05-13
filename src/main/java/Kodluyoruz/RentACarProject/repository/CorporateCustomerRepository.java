package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.CorporateCustomer;
import Kodluyoruz.RentACarProject.entity.Rental;

@Repository
public interface CorporateCustomerRepository extends CrudRepository<CorporateCustomer, Integer> {

	List<CorporateCustomer> findAllCorporateCustomersById(Rental rental);
}
