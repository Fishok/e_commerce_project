package com.project.service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.User;
import com.project.domain.repo.UserRepo;
import com.project.dto.UserDTO;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.User;
import com.project.domain.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImpl implements UserInterface {
	
	private UserRepo userRepo;
	@Autowired
	public UserImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}



	@Override
	public Codes addUser(UserDTO user) {
	    String uuid = UUID.randomUUID().toString();
	    if (userRepo.findById(uuid)) {
	        return Codes.WRONG;
	    }
	    
	    User newUser = new User(uuid, user.getUsername(), user.getPassword(), user.getRole(), user.getFirstName(),
	                            user.getSecondName(), user.getEmail(), user.getPhoneNumber(), user.getCountry(),
	                            user.getAddress());

	    userRepo.save(newUser);
	    return Codes.OK;
	}

	

	@Override
	public Codes removeUser(String username, String password) {
		User user = userRepo.findByUsername(username)
                .orElse(null);
        if (user == null || !user.getPassword().equals(password)) {
            return Codes.WRONG;
        }
        userRepo.delete(user);
        return Codes.OK;
    }

	@Override
	public Codes updatePassword(String username, String oldPassword, String newPassword, String newPasswordCheck) {
		 User user = userRepo.findByUsername(username)
	                .orElse(null);
	        if (user == null || !user.getPassword().equals(oldPassword) || !newPassword.equals(newPasswordCheck)) {
	            return Codes.WRONG;
	        }
	        user.setPassword(newPassword);
	        userRepo.save(user);
	        return Codes.OK;
	    }


	@Override
	public User getUserByUsername(String username) {
	    return userRepo.findByUsername(username).orElse(null);
	}



	@Override
	public Codes updateUser(UserDTO user) {
	    User existingUser = userRepo.findByUsername(user.getUsername()).orElse(null);
	    if (existingUser == null) {
	        return Codes.WRONG;
	    }

	    User updatedUser = new User(existingUser.getUuid(), user.getUsername(), user.getPassword(), user.getRole(),
	                                user.getFirstName(), user.getSecondName(), user.getEmail(), user.getPhoneNumber(),
	                                user.getCountry(), user.getAddress());

	    userRepo.save(updatedUser);
	    return Codes.OK;
	}

	@Override
	public boolean existsByEmail(String email) {
	    return userRepo.existsByEmail(email);
	}



	@Override
	public boolean existsByUsername(String username) {
	    return userRepo.existsByUsername(username);
	}

	@Override
	public boolean findById(String uuid) {
	   
	    return userRepo.findById(uuid);
	}
	

   


}
