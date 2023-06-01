package com.project.domain.repo;

import com.project.codeReturn.Codes;
import com.project.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Codes updateUser(String login, String password, String firstName, String secondName, String email,
                       String phoneNumber, String country, String address);

    Codes removeUser(String login, String password);

    User addUser(String username, String password, String email, boolean enabled);

    Codes updatePassword(String login, String oldPassword, String newPassword, String new_password_check);

    boolean findById(String uuid);

	
}