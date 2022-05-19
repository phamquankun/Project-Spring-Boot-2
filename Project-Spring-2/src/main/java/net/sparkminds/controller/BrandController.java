package net.sparkminds.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.entity.Brand;
import net.sparkminds.service.BrandService;
import net.sparkminds.service.dto.request.BrandRequestDTO;
import net.sparkminds.service.dto.response.BrandResponseDTO;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	private final BrandService brandService;

	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping
	public ResponseEntity<List<Brand>> getBrand() {
		return ResponseEntity.ok().body(brandService.getAllBrand());
	};

	@PostMapping
	public ResponseEntity<BrandResponseDTO> createBrand(@RequestBody BrandRequestDTO brandRequestDTO) {
		return ResponseEntity.ok(brandService.createBrand(brandRequestDTO));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Long id, @RequestBody BrandRequestDTO brandRequestDTO) {
		brandService.updateBrand(brandRequestDTO, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable("id") Long id) {
		brandService.deleteBrand(id);
		return ResponseEntity.noContent().build();
	}
}
