package net.sparkminds.service;

import java.util.List;

import net.sparkminds.entity.Brand;
import net.sparkminds.service.dto.request.BrandRequestDTO;
import net.sparkminds.service.dto.response.BrandResponseDTO;


public interface BrandService {
	BrandResponseDTO createBrand(BrandRequestDTO brandRequestDTO);
	
	List<Brand> getAllBrand();
	
	BrandResponseDTO updateBrand(BrandRequestDTO brandRequestDTO, Long id);

	void deleteBrand(Long id);
}
