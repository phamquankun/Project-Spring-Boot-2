package net.sparkminds.service.dto.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BrandResponseDTO {
	private Long id;
	
	private String name;

	private String description;

	private Instant createdDate;
	
	private String createdBy;
	

}
