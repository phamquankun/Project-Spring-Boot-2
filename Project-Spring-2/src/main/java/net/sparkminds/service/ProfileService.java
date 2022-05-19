package net.sparkminds.service;

import java.util.List;

import net.sparkminds.entity.Profile;
import net.sparkminds.service.dto.request.ProfileRequestDTO;
import net.sparkminds.service.dto.response.ProfileResponseDTO;

public interface ProfileService {
	ProfileResponseDTO createProfile(ProfileRequestDTO profileRequestDTO);
	
	List<Profile> getAllProfile();
	
	ProfileResponseDTO updateProfile(ProfileRequestDTO profileRequestDTO, Long id);

	void deleteProfile(Long id);
}
