package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.ChildBirth;

import java.util.List;

public interface ChildBirthService {
    List<ChildBirth> getAll();

    ChildBirth getChildBirthById(Long id);

    ChildBirth create(ChildBirth childBirth);

    ChildBirth updateCenter(Long id, ChildBirth childBirth);
}
