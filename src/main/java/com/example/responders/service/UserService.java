package com.example.responders.service;

import com.example.responders.dto.UserDTO;
import com.example.responders.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);
    void save(User user);
    List<UserDTO> getAll();
    User findByName(String name);

    void updateProfile(UserDTO userDTO);

    void deleteById(Long id);

}
