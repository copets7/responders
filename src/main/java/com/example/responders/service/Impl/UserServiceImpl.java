package com.example.responders.service.Impl;

import com.example.responders.dto.UserDTO;
import com.example.responders.models.Role;
import com.example.responders.models.User;
import com.example.responders.repository.UserRepository;
import com.example.responders.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean save(UserDTO userDTO) {
        logger.info("Creating new user {}" , userDTO.getUsername());
        if (!Objects.equals(userDTO.getMatchingPassword(), userDTO.getPassword())) {
            throw new RuntimeException("Password is not equals");
        }
        User user = new User(userDTO.getUsername(), userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()), Role.USER);
        userRepository.save(user);
        return true;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void updateProfile(UserDTO userDTO) {
        logger.info("Updated user " + userDTO.getUsername());
        User user = userRepository.findByName(userDTO.getUsername());
        if (user == null) {
            throw new RuntimeException("User not found by name : " + userDTO.getUsername());
        }
        boolean isChanged = false;
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword((passwordEncoder.encode(userDTO.getPassword())));
            isChanged = true;
        }

        if (!Objects.equals(userDTO.getEmail(), user.getEmail())) {
            user.setEmail((userDTO.getEmail()));
            isChanged = true;
        }
        if (isChanged) {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Deleted user with id " + id);
        userRepository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with name :  " + username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        logger.info("The " + username + " is logged in with the role " + user.getRole().name());
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);
    }

    private UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
        return userDTO;
    }
}
