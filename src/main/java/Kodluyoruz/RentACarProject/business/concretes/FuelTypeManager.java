package Kodluyoruz.RentACarProject.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodluyoruz.RentACarProject.business.abstracts.FuelTypeService;
import Kodluyoruz.RentACarProject.dto.requestDtos.FuelTypeRequestDto;
import Kodluyoruz.RentACarProject.entity.FuelType;
import Kodluyoruz.RentACarProject.repository.FuelTypeRepository;

@Service
public class FuelTypeManager implements FuelTypeService{

	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Integer saveFuelType(FuelTypeRequestDto fuelTypeRequestDto) {
		FuelType fuelType = modelMapper.map(fuelTypeRequestDto, FuelType.class);
		fuelType = fuelTypeRepository.save(fuelType);
		return fuelType.getId();
	}
}
