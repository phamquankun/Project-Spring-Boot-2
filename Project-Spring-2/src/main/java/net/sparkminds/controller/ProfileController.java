package net.sparkminds.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.entity.Brand;
import net.sparkminds.entity.Profile;
import net.sparkminds.service.BrandService;
import net.sparkminds.service.ProfileService;
import net.sparkminds.service.dto.request.BrandRequestDTO;
import net.sparkminds.service.dto.request.ProfileRequestDTO;
import net.sparkminds.service.dto.response.BrandResponseDTO;
import net.sparkminds.service.dto.response.ProfileResponseDTO;

@RestController
@RequestMapping("api/profiles")
public class ProfileController {
	private final ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping
	public ResponseEntity<List<Profile>> getProfile() {
		return ResponseEntity.ok().body(profileService.getAllProfile());
	};

	@PostMapping
	public ResponseEntity<ProfileResponseDTO> createProfile(@RequestBody ProfileRequestDTO profileRequestDTO) {
		return ResponseEntity.ok(profileService.createProfile(profileRequestDTO));
	}
}
