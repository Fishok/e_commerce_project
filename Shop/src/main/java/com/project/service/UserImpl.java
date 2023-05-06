package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.entity.User;
import com.project.domain.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImpl implements UserInterface {
	@Autowired
	private UserRepo userRepo;

	public UserImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User getUserByUsername(String username) {
		Optional<User> userOptional = userRepo.findByUsername(username);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		return null;
	}

	@Override
	public User addUser(String username, String password, String email, boolean enabled) {
		return userRepo.addUser(username, password, email, enabled);
	}

	@Override
	public boolean updateUser(String username, String password, String firstName, String secondName, String email,
			String phoneNumber, String country, String address) {
		if (userRepo.existsByUsername(username)) {
			String result = userRepo.updateUser(username, password, firstName, secondName, email, phoneNumber, country,
					address);
			return result != null && result.equals(username);
		}
		return false;
	}

	@Override
	public boolean removeUser(String username, String password) {
		String result = userRepo.removeUser(username, password);
		return result != null && result.equals(username);
	}

	@Override
	public boolean updatePassword(String username, String oldPassword, String newPassword, String newPasswordCheck) {
		if (userRepo.existsByUsername(username)) {
			User user = getUserByUsername(username);
			if (user.getPassword().equals(oldPassword) && newPassword.equals(newPasswordCheck)) {
				String result = userRepo.updatePassword(username, oldPassword, newPassword, newPasswordCheck);
				return result != null && result.equals(username);
			}
		}
		return false;
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
