package com.project.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.project.domain.entity.Collects;



@Repository
public interface CollectsRepo extends JpaRepository<Collects, Long> {
	Collects findByNameCollection(String nameCollection);

	@Transactional
	boolean removeCollection(String nameCollection);

	
	@Transactional
	Collects addCollection(String nameCollection);
}