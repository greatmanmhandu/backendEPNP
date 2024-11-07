package com.ehpnp.Backend.service.imp;
import com.ehpnp.Backend.model.Vaccination;
import com.ehpnp.Backend.repository.VaccinationRepository;
import com.ehpnp.Backend.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinationServiceImp implements VaccinationService {

    @Autowired
    VaccinationRepository vaccinationRepository;


    @Override
    public Vaccination create(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }

    @Override
    public  List<Vaccination> getAll() {
        return vaccinationRepository.findAll();
    }

    @Override
    public Vaccination getVaccinationById(Long id) {
        Optional<Vaccination> vaccination = vaccinationRepository.findById(id);
        return vaccination.get();
    }

    @Override
    public Vaccination updateCenter(Long id, Vaccination vaccination) {
        Optional<Vaccination> veccinationOptional = vaccinationRepository.findById(id);

        veccinationOptional.get().setName(vaccination.getName());

        Vaccination save = vaccinationRepository.save(veccinationOptional.get());
        return getVaccinationById(save.getId());
    }
}
