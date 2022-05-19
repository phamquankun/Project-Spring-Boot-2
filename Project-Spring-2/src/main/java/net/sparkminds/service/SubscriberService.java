package net.sparkminds.service;

import java.util.List;

import net.sparkminds.entity.Subscriber;
import net.sparkminds.service.dto.request.SubscriberRequestDTO;
import net.sparkminds.service.dto.response.SubscriberResponseDTO;

public interface SubscriberService {
	SubscriberResponseDTO createSubscriber(SubscriberRequestDTO subscriberRequestDTO);
	
	List<SubscriberResponseDTO> getSubscriberByBrandId(Long brandId);
	
	List<SubscriberResponseDTO> getSubscriberByGender(String sex);
	
	List<Subscriber> getAllSubscriber();

	void updateSubscriber(SubscriberRequestDTO subscriberRequestDTO, Long id);

	void deleteSubscriber(Long id);
}
