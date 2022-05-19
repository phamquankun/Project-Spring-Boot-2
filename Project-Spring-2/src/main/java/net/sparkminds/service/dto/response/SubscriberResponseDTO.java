package net.sparkminds.service.dto.response;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Builder;
import lombok.Data;
import net.sparkminds.entity.enumeration.Gender;

@Builder
@Data
public class SubscriberResponseDTO {

	private String phoneNumber;

	private Long brandId;
	
	private Long profileId;
	
	private String brandName;
	
	private String profileName;
	
	private Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	private Gender gender;
}
