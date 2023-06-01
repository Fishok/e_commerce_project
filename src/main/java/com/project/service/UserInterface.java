package com.project.service;

import com.project.codeReturn.Codes;
import com.project.domain.entity.User;
import com.project.dto.UserDTO;

public interface UserInterface {
	User getUserByUsername(String username);

	Codes addUser(UserDTO user);

	Codes updateUser(UserDTO user);

	Codes removeUser(String username, String password);

	Codes updatePassword(String username, String oldPassword, String newPassword, String newPasswordCheck);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	boolean findById(String uuid);
}
