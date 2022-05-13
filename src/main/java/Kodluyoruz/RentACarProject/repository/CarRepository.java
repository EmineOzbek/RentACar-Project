package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.Brand;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.FuelType;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	List<Car> findAllCarsByBrandId(Brand brand);
	
	List<Car> findAllCarsByFuelTypeId(FuelType fuelType);

}
