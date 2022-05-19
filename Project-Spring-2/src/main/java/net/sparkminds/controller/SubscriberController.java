package net.sparkminds.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.entity.Subscriber;
import net.sparkminds.service.SubscriberService;
import net.sparkminds.service.dto.request.SubscriberRequestDTO;
import net.sparkminds.service.dto.response.SubscriberResponseDTO;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {

	private final SubscriberService subscriberService;
	
	public SubscriberController(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}
	@GetMapping
	public ResponseEntity<List<Subscriber>> getSubscriber() {
		return ResponseEntity.ok().body(subscriberService.getAllSubscriber());
	};
	@GetMapping(value="/brand")
	public ResponseEntity<List<SubscriberResponseDTO>> getSubByBrandId(@RequestParam Long brandId) {
		return ResponseEntity.ok().body(subscriberService.getSubscriberByBrandId(brandId));
	};
	@GetMapping(value="/gender")
	public ResponseEntity<List<SubscriberResponseDTO>> getSubByGender(@RequestParam String sex) {
		return ResponseEntity.ok().body(subscriberService.getSubscriberByGender(sex));
	};
	@PostMapping
	public ResponseEntity<SubscriberResponseDTO> createSubscriber(@RequestBody SubscriberRequestDTO subscriberRequestDTO) {
		return ResponseEntity.ok(subscriberService.createSubscriber(subscriberRequestDTO));
	}
}
