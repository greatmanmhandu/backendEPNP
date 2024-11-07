package com.ehpnp.Backend.mapper;

import com.ehpnp.Backend.dto.user.UserDTO;
import com.ehpnp.Backend.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {
    @Autowired
    ModelMapper modelMapper;

    public UserDTO userToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
