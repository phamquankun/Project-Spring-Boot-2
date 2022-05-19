package net.sparkminds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import net.sparkminds.entity.enumeration.Gender;

@Entity
@Data
@Table(name="subscriber")
public class Subscriber extends AbtractEnity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="phone_number", unique=true)
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName="id")
    private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "profile_id", referencedColumnName="id")
    private Profile profile;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
