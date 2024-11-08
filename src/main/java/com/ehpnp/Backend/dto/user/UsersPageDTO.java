package com.ehpnp.Backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersPageDTO {
    private Integer page;
    private Integer pageSize;
    private Long totalRecords;
    private Integer totalPages;
    private List<UserDTO> users;
}
