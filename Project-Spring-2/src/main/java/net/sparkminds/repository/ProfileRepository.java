package net.sparkminds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
