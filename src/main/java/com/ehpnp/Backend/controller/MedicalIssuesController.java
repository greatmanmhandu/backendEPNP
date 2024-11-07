package com.ehpnp.Backend.controller;

import com.ehpnp.Backend.model.MedicalIssue;
import com.ehpnp.Backend.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical")
@CrossOrigin("*")
public class MedicalIssuesController {

    @Autowired
    MedicalService medicalService;

    @PostMapping
    ResponseEntity<MedicalIssue> createIssue(@RequestBody MedicalIssue medicalIssue) {
        MedicalIssue createdMedical = medicalService.createIssue(medicalIssue);
        return ResponseEntity.status(HttpStatus.OK).body(createdMedical);
    }

    @GetMapping
    ResponseEntity<List<MedicalIssue>> getAllMedical(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(medicalService.getAllMedicals());
    }

    @GetMapping("/{id}")
    ResponseEntity<MedicalIssue> getMedicalById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicalService.getMedicalById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<MedicalIssue> updateMedical(@PathVariable Long id, @RequestBody MedicalIssue categoryData) {
        MedicalIssue updatedCategory = medicalService.updateMedical(id, categoryData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }
}
