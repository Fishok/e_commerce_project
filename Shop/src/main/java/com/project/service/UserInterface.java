package com.project.service;

import com.project.domain.entity.User;

public interface UserInterface {
	User getUserByUsername(String username);
    User addUser(String username, String password, String email, boolean enabled);
    boolean updateUser(String username, String password, String firstName, String secondName,
			String email, String phoneNumber, String country, String address);
    boolean removeUser(String username, String password);
    boolean updatePassword(String username, String oldPassword, String newPassword, String newPasswordCheck);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
