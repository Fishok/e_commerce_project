package com.project.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.Collection;

import jakarta.transaction.Transactional;

@Repository
public interface CollectionRepo extends JpaRepository<Collection, Long> {
	Optional<Collection> findByNameCollection(String nameCollection);

	@Modifying
	@Query("DELETE FROM Collection c WHERE c.nameCollection = :nameCollection")
	String removeCollection(@Param("nameCollection") String nameCollection);

	@Modifying
	@Query(value = "INSERT INTO Collection(name) VALUES (:name)", nativeQuery = true)
	@Transactional
	Collection addCollection(@Param("name") String nameCollection);
}