package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.Vaccination;

import java.util.List;

public interface VaccinationService {

    Vaccination create(Vaccination vaccination);

    List<Vaccination> getAll();

    Vaccination getVaccinationById(Long id);

    Vaccination updateCenter(Long id, Vaccination vaccination);
}
