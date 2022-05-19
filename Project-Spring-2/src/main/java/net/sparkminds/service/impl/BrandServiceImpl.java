package net.sparkminds.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.entity.Brand;
import net.sparkminds.repository.BrandRepository;
import net.sparkminds.service.BrandService;
import net.sparkminds.service.dto.request.BrandRequestDTO;
import net.sparkminds.service.dto.response.BrandResponseDTO;

@Service
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	@Transactional
	public BrandResponseDTO createBrand(BrandRequestDTO brandRequestDTO) {
		Brand brand = new Brand();
		brand.setName(brandRequestDTO.getName());
		brand.setDescription(brandRequestDTO.getDescription());
		brandRepository.save(brand);
		return BrandResponseDTO.builder().name(brand.getName()).description(brand.getDescription())
				.createdBy(brand.getCreatedBy()).createdDate(brand.getCreatedDate()).build();
	}

	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	@Override
	@Transactional
	public BrandResponseDTO updateBrand(BrandRequestDTO brandRequestDTO, Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brand.setName(brandRequestDTO.getName());
		brand.setDescription(brandRequestDTO.getDescription());
		return BrandResponseDTO.builder().name(brand.getName()).description(brand.getDescription())
				.createdBy(brand.getCreatedBy()).createdDate(brand.getCreatedDate()).build();
	}

	@Override
	@Transactional
	public void deleteBrand(Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brand is not exist"));

		brandRepository.delete(brand);
	}

}
