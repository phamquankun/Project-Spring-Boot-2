package net.sparkminds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.entity.Profile;
import net.sparkminds.repository.ProfileRepository;
import net.sparkminds.service.ProfileService;
import net.sparkminds.service.dto.request.ProfileRequestDTO;
import net.sparkminds.service.dto.response.ProfileResponseDTO;

@Service
@Transactional(readOnly=true)
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	@Transactional
	public ProfileResponseDTO createProfile(ProfileRequestDTO profileRequestDTO) {
		Profile profile = new Profile();
		profile.setName(profileRequestDTO.getName());
		profile.setDescription(profileRequestDTO.getDescription());
		profileRepository.save(profile);
		return ProfileResponseDTO.builder().name(profile.getName()).description(profile.getDescription())
				.createdBy(profile.getCreatedBy()).createdDate(profile.getCreatedDate()).build();
	}

	@Override
	public List<Profile> getAllProfile() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public ProfileResponseDTO updateProfile(ProfileRequestDTO profileRequestDTO, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProfile(Long id) {
		// TODO Auto-generated method stub
		
	}

}
