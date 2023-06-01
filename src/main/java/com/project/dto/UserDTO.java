package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class UserDTO  {
    private String username;
    private String password;
    private String role;
    private String FirstName;
    private String SecondName;
    private String Email;
    private String phoneNumber;
    private String country;
    private String address;
}
