package com.practice.myfirstapp.service;

import com.practice.myfirstapp.dto.LoginDTO;
import com.practice.myfirstapp.dto.UserDTO;
import com.practice.myfirstapp.response.LoginMessage;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);

}
