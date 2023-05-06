package com.project.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.project.domain.entity.*;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	@Modifying
	@Query("UPDATE User SET password = :password, firstName = :firstName, secondName = :secondName, email = :email, phoneNumber = :phoneNumber, country = :country, address = :address WHERE login = :login")
	String updateUser(@Param("login") String login, @Param("password") String password,
			@Param("firstName") String firstName, @Param("secondName") String secondName, @Param("email") String email,
			@Param("phoneNumber") String phoneNumber, @Param("country") String country,
			@Param("address") String address);

	@Modifying
    @Query("DELETE FROM User WHERE login = :login AND password = :password")
    String removeUser(@Param("login") String login, @Param("password") String password);


	@Modifying
	@Query(value = "INSERT INTO User(username, password, email, enabled) VALUES (:username, :password, :email, :enabled)", nativeQuery = true)
	@Transactional
	User addUser(@Param("username") String username, @Param("password") String password, @Param("email") String email,
			@Param("enabled") boolean enabled);

	@Modifying
	@Query("UPDATE User SET password = :newPassword WHERE login = :login AND password = :oldPassword")
	String updatePassword(@Param("login") String login, @Param("oldPassword") String old_password,
	                      @Param("newPassword") String new_password, @Param("newPasswordCheck") String new_password_check); 
}