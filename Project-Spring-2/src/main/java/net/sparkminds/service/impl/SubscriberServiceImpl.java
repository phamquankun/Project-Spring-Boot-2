package net.sparkminds.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.entity.Brand;
import net.sparkminds.entity.Profile;
import net.sparkminds.entity.Subscriber;
import net.sparkminds.entity.enumeration.Gender;
import net.sparkminds.repository.BrandRepository;
import net.sparkminds.repository.ProfileRepository;
import net.sparkminds.repository.SubscriberRepository;
import net.sparkminds.service.SubscriberService;
import net.sparkminds.service.dto.request.SubscriberRequestDTO;
import net.sparkminds.service.dto.response.SubscriberResponseDTO;

@Service
@Transactional(readOnly = true)
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	@Transactional
	public SubscriberResponseDTO createSubscriber(SubscriberRequestDTO subscriberRequestDTO) {
		Brand brand = brandRepository.findById(subscriberRequestDTO.getBrandId()).orElse(null);
		Profile profile = profileRepository.findById(subscriberRequestDTO.getProfileId()).orElse(null);
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(subscriberRequestDTO.getPhoneNumber());
		subscriber.setDateOfBirth(subscriberRequestDTO.getDateOfBirth());
		subscriber.setGender(subscriberRequestDTO.getGender());
		subscriber.setBrand(brand);
		subscriber.setProfile(profile);
		subscriberRepository.save(subscriber);
		return SubscriberResponseDTO.builder().phoneNumber(subscriber.getPhoneNumber()).brandId(brand.getId())
				.brandName(brand.getName()).profileId(profile.getId()).profileName(profile.getName())
				.dateOfBirth(subscriber.getDateOfBirth()).gender(subscriber.getGender()).build();
	}

	@Override
	public List<Subscriber> getAllSubscriber() {
		return subscriberRepository.findAll();
	}

	@Override
	public void updateSubscriber(SubscriberRequestDTO subscriberRequestDTO, Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubscriber(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SubscriberResponseDTO> getSubscriberByBrandId(Long brandId) {
		return subscriberRepository.findByBrandId(brandId).stream().map(entity -> {
			return SubscriberResponseDTO.builder()
					.brandName(entity.getBrand().getName())
					.phoneNumber(entity.getPhoneNumber())
					.gender(entity.getGender())
					.brandId(brandId)
					.dateOfBirth(entity.getDateOfBirth())
					.build();
		}).collect(Collectors.toList());
	}

	@Override
	public List<SubscriberResponseDTO> getSubscriberByGender(String sex) {
		return subscriberRepository.findByGender(Gender.valueOf(sex)).stream().map(entity -> {
			return SubscriberResponseDTO.builder()
					.brandName(entity.getBrand().getName())
					.phoneNumber(entity.getPhoneNumber())
					.gender(entity.getGender())
					.dateOfBirth(entity.getDateOfBirth())
					.build();
		}).collect(Collectors.toList());
	}

}
