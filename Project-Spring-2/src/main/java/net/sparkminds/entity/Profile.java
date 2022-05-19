package net.sparkminds.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="profile")
public class Profile extends AbtractEnity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", unique=true)
	@NotBlank
	private String name;
	
	@Column(name="description")
	@Size(max=300)
	private String description;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
	private List<Subscriber> subscribers;
}
