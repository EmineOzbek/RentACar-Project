package Kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Kodluyoruz.RentACarProject.entity.Brand;
import Kodluyoruz.RentACarProject.entity.Car;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

	List<Brand> findAllBrandsById(Car car);

}
