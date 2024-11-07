package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.MedicalIssue;

import java.util.List;

public interface MedicalService {

    MedicalIssue createIssue(MedicalIssue medicalIssue);

    List<MedicalIssue> getAllMedicals();

    MedicalIssue getMedicalById(Long id);

    MedicalIssue updateMedical(Long id, MedicalIssue medicalIssue);
}
