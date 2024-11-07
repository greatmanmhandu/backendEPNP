package com.ehpnp.Backend.service.imp;

import com.ehpnp.Backend.model.MedicalIssue;
import com.ehpnp.Backend.repository.MedicalRepository;
import com.ehpnp.Backend.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceImp implements MedicalService {

    @Autowired
    MedicalRepository medicalRepository;



    @Override
    public MedicalIssue createIssue(MedicalIssue medicalIssue) {
        return medicalRepository.save(medicalIssue);
    }

    @Override
    public  List<MedicalIssue> getAllMedicals() {
        return medicalRepository.findAll();
    }

    @Override
    public MedicalIssue getMedicalById(Long id) {
        Optional<MedicalIssue> medicalIssue = medicalRepository.findById(id);
        return medicalIssue.get();
    }

    @Override
    public MedicalIssue updateMedical(Long id, MedicalIssue medicalIssue) {
        Optional<MedicalIssue> medicalOptional = medicalRepository.findById(id);

        medicalOptional.get().setDescription(medicalIssue.getDescription());

        MedicalIssue save = medicalRepository.save(medicalOptional.get());
        return getMedicalById(save.getId());
    }
}
