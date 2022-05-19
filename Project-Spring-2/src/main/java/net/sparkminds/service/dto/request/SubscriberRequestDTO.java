package net.sparkminds.service.dto.request;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import net.sparkminds.entity.enumeration.Gender;

@Data
public class SubscriberRequestDTO {
	private String phoneNumber;
	
	private Long brandId;
	
	private Long profileId;
	
	private Date dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
