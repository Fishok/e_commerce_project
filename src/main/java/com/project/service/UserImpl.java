package com.project.service;

import com.project.domain.entity.User;
import com.project.domain.repo.UserRepo;

import java.util.Optional;

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
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username).orElse(null);
	}

	@Override
	public User addUser(String username, String password, String email, boolean enabled) {
		return userRepo.addUser(username, password, email, enabled);
	}

	@Override
	public boolean updateUser(String username, String password, String firstName, String secondName,
			String email, String phoneNumber, String country, String address) {
		User user = userRepo.findByUsername(username).orElse(null);
		if (userRepo.existsByUsername(username)) {
			user.setPassword(password);
	        user.setFirstName(firstName);
	        user.setSecondName(secondName);
	        user.setEmail(email);
	        user.setPhoneNumber(phoneNumber);
	        user.setCountry(country);
	        user.setAddress(address);
	        userRepo.save(user);
	        return true;
		}
		return false;
	}

	@Override
	public boolean removeUser(String username, String password) {
		User user = userRepo.findByUsername(username).orElse(null);
        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }
        userRepo.delete(user);
        return true;
    }

	@Override
	public boolean updatePassword(String username, String oldPassword, String newPassword, String newPasswordCheck) {
		 User user = userRepo.findByUsername(username).orElse(null);
	        if (user == null || !user.getPassword().equals(oldPassword) || !newPassword.equals(newPasswordCheck)) {
	            return false;
	        }
	        user.setPassword(newPassword);
	        userRepo.save(user);
	        return true;
	    }

	@Override
	public boolean existsByUsername(String username) {
		return userRepo.existsByUsername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepo.existsByEmail(email);
	}
}
