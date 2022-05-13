package Kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import Kodluyoruz.RentACarProject.dto.requestDtos.BrandRequestDto;
import Kodluyoruz.RentACarProject.dto.responseDtos.BrandResponseDto;

public interface BrandService {

	Integer saveBrand(BrandRequestDto brandRequestDto);

	List<BrandResponseDto> findAllBrands();

	List<BrandResponseDto> findAllBrandsById(Integer carId);

	boolean deleteBrandById(Integer brandId);

}
