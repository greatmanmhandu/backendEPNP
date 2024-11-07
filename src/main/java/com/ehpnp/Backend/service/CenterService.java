package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.Centers;
import com.ehpnp.Backend.model.Vaccination;

import java.util.List;

public interface CenterService {


    List<Centers> getAllCenters();

    Centers getCenterById(Long id);

    Centers updateCenter(Long id, Centers centers);

    Centers createCenter(Centers center);

}
