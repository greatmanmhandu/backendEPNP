package com.ehpnp.Backend.controller;

import com.ehpnp.Backend.dto.user.*;
import com.ehpnp.Backend.model.User;
import com.ehpnp.Backend.repository.UserRepository;
import com.ehpnp.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserCreationDTO user) {
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }

    @PostMapping("/create-mobile")
    ResponseEntity<UserDTO> createUserMobile(@RequestBody UserCreationDTO user) {
        User userFound = userRepository.findByUsername(user.getUsername());
        if (userFound != null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }


    @PostMapping("/login")
    ResponseEntity<UserDTO> userLogin(@RequestBody LoginDTO loginData) {
        UserDTO user = userService.userLogin(loginData);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/login-mobile")
    ResponseEntity<UserDTO> userLoginMobile(@RequestBody LoginDTO loginData) {

        UserDTO user = userService.userLoginMobile(loginData);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    ResponseEntity<UsersPageDTO> getAllUsers(
            @RequestParam(name = "searchCriteria", required = false) String criteria,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(criteria, page, pageSize));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userData) {
        UserDTO updatedUser = userService.updateUser(id, userData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @PutMapping("/{id}/{newPassword}")
    ResponseEntity<UserDTO> updatePassword(@PathVariable Long id, @PathVariable String newPassword) {
        UserDTO updatedUser = userService.updatePassword(id, newPassword);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }
}
