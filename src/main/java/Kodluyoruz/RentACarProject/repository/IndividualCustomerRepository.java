package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.IndividualCustomer;
import Kodluyoruz.RentACarProject.entity.Rental;

@Repository
public interface IndividualCustomerRepository extends CrudRepository<IndividualCustomer, Integer> {

	List<IndividualCustomer> findAllIndividualCustomersById(Rental rental);
}
