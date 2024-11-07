package com.ehpnp.Backend.service.imp;

import com.ehpnp.Backend.dto.user.*;
import com.ehpnp.Backend.model.User;
import com.ehpnp.Backend.repository.UserRepository;
import com.ehpnp.Backend.repository.specifications.UserSpecifications;
import com.ehpnp.Backend.mapper.UserMapper;
import com.ehpnp.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO userLogin(LoginDTO loginData) {
        System.out.println(loginData.getEmail());
        User user = userRepository.findByEmail(loginData.getEmail());
        System.out.println(user);
        if (user == null) {
            return null;
        }
        Boolean successfulLogin = passwordEncoder.matches(loginData.getPassword(), user.getPasswordHash());
        if (!successfulLogin) {
            return null;
        }
        return userMapper.userToDTO(user);
    }

    @Override
    public UsersPageDTO getAllUsers(String criteria, Integer page, Integer pageSize) {
        UsersPageDTO pagedUsersResponse = new UsersPageDTO();

        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("userId").descending());

        Page<User> userPage;

        if (criteria == null || criteria.length() == 0) {
            userPage = userRepository.findAll(pageable);
        } else {
            userPage = userRepository.findAll(UserSpecifications.searchUsers(criteria), pageable);
        }

        List<UserDTO> users = userPage.getContent().stream()
                .map(user -> userMapper.userToDTO(user))
                .collect(Collectors.toList());

        pagedUsersResponse.setPage(userPage.getNumber() + 1);
        pagedUsersResponse.setPageSize(userPage.getSize());
        pagedUsersResponse.setTotalRecords(userPage.getTotalElements());
        pagedUsersResponse.setTotalPages(userPage.getTotalPages());
        if (pagedUsersResponse.getTotalPages() == 0) {
            pagedUsersResponse.setTotalPages(1);
        }
        pagedUsersResponse.setUsers(users);

        return pagedUsersResponse;
    }

    @Override
    @Transactional
    public UserDTO getUserById(Long id) {
        User foundUser = userRepository.findByUserId(id);
        return userMapper.userToDTO(foundUser);
    }

    @Override
    public UserDTO createUser(UserCreationDTO userData) {

        // Password encryption
        String passwordHash = passwordEncoder.encode(userData.getPassword());
        User user = new User();
        user.setName(userData.getName());
        user.setUsername(userData.getUsername());
        user.setPasswordHash(passwordHash);
        user.setEmail(userData.getEmail());
        user.setAdmin(userData.getAdmin());
        user.setPhoneNumber(userData.getPhoneNumber());
        User save = userRepository.save(user);
        return getUserById(user.getUserId());
    }

    @Override
    @Transactional
    public UserDTO updateUser(Long userId, UserUpdateDTO userData) {
        User foundUser = userRepository.findByUserId(userId);

        if (!userData.getUsername().equalsIgnoreCase(foundUser.getUsername()) &&
                userRepository.findByUsername(userData.getUsername()) != null) {
            return null;
        } else if (!userData.getEmail().equalsIgnoreCase(foundUser.getEmail()) &&
                userRepository.findByEmail(userData.getEmail()) != null) {
            return null;
        }

        foundUser.setName(userData.getName());
        foundUser.setUsername(userData.getUsername());
        foundUser.setPhoneNumber(userData.getPhoneNumber());
        foundUser.setEmail(userData.getEmail());

        User sessionUser = userRepository.findByUserId(userData.getSessionUserId());
        // sessionUser.getUserId() > 1??
        if (foundUser.getUserId() > 1 && sessionUser.getAdmin() == true) {
            foundUser.setAdmin(userData.getAdmin());
        }

        // Call procedure
        User save = userRepository.save(foundUser);

        // Call class method for get by user id
        return userMapper.userToDTO(save);
    }

    @Override
    public UserDTO updatePassword(Long userId, String newPassword) {
        User foundUser = userRepository.findByUserId(userId);
        foundUser.setPasswordHash(passwordEncoder.encode(newPassword));
        User updatedUser = userRepository.save(foundUser);
        return userMapper.userToDTO(updatedUser);
    }

    @Override
    public UserDTO userLoginMobile(LoginDTO loginData) {
        System.out.println(loginData.getEmail());
        User user = userRepository.findByUsername(loginData.getEmail());
        System.out.println(user);
        if (user == null) {
            return null;
        }
        Boolean successfulLogin = passwordEncoder.matches(loginData.getPassword(), user.getPasswordHash());
        if (!successfulLogin) {
            return null;
        }
        return userMapper.userToDTO(user);
    }
}
