package Kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.BrandService;
import Kodluyoruz.RentACarProject.dto.requestDtos.BrandRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.BrandResponseDto;
import Kodluyoruz.RentACarProject.entity.Brand;
import Kodluyoruz.RentACarProject.entity.Car;
import Kodluyoruz.RentACarProject.repository.BrandRepository;
import Kodluyoruz.RentACarProject.repository.CarRepository;

@Service
public class BrandManager implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	private CarRepository carRepository;
	private ModelMapper modelMapper;

	@Override
	public Integer saveBrand(BrandRequestDto brandRequestDto) {
		Brand brand = modelMapper.map(brandRequestDto, Brand.class);
		brand = brandRepository.save(brand);
		return brand.getId();
	}

	@Override
	public List<BrandResponseDto> findAllBrands() {
		Iterable<Brand> brandList = brandRepository.findAll();

		List<BrandResponseDto> brandResponseDtos = new ArrayList<>();
		for (Brand brand : brandList) {
			BrandResponseDto brandResponseDto = modelMapper.map(brand, BrandResponseDto.class);
			brandResponseDtos.add(brandResponseDto);
		}
		return brandResponseDtos;
	}

	@Override
	public List<BrandResponseDto> findAllBrandsById(Integer carId) {
		Car car = carRepository.findById(carId).get();
		List<Brand> brandList = brandRepository.findAllBrandsById(car);

		List<BrandResponseDto> brandResponseDtos = new ArrayList<>();
		for (Brand brand : brandList) {
			BrandResponseDto brandResponseDto = modelMapper.map(brand, BrandResponseDto.class);
			brandResponseDtos.add(brandResponseDto);
		}
		return brandResponseDtos;
	}

	@Override
	public boolean deleteBrandById(Integer brandId) {
		Brand brand = brandRepository.findById(brandId).get();
		brandRepository.delete(brand);
		return true;
	}

}
