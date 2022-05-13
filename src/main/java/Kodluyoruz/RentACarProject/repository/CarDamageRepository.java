package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.entity.CarDamage;

@Repository
public interface CarDamageRepository extends CrudRepository<CarDamage, Integer> {

	List<CarDamage> findAllCarDamagesById(Car car);
}
