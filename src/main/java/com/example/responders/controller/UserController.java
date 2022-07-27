package com.example.responders.controller;

import com.example.responders.dto.UserDTO;
import com.example.responders.models.User;
import com.example.responders.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("users",userService.getAll());
        return "users/userList";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "users/user";
    }

    @PostMapping("/new")
    public String saveUser(UserDTO userDTO, Model model){
        if(userService.save(userDTO)){
            return "redirect:/users";
        }else {
            model.addAttribute("user", userDTO);
            return "users/user";
        }
    }

    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal){
        if(principal == null){
            throw new RuntimeException("You are not authorize");
        }
        User user = userService.findByName(principal.getName());

        UserDTO userDTO = new UserDTO(user.getId(), user.getName(),user.getEmail());

        model.addAttribute("user",userDTO);
        return "users/profile";
    }


    @PostMapping("/profile")
    public String updateProfileUser(UserDTO userDTO, Model model, Principal principal){
        if(principal == null || !Objects.equals(principal.getName(), userDTO.getUsername())){
            throw new RuntimeException("You are not authorize");
        }
        if(userDTO.getPassword() != null && !userDTO.getPassword().isEmpty() && !Objects.equals(userDTO.getPassword(),userDTO.getMatchingPassword())){
            model.addAttribute("user",userDTO);
            return "users/profile";
        }
        userService.updateProfile(userDTO);
        return "redirect:/profile";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
