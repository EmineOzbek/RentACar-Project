package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.Rental;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {

	List<Rental> findAllByCarId(Car car);

}
