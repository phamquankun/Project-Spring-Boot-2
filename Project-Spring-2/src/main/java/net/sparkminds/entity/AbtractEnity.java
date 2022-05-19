package net.sparkminds.entity;

import java.time.Instant;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public abstract class AbtractEnity {
	@CreatedBy
	@Column(name = "created_by", nullable = false, length = 50, updatable = false)
	protected String createdBy;

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	protected Instant createdDate = Instant.now();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	protected Instant lastModifiedDate = Instant.now();
}
