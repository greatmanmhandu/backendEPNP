package com.ehpnp.Backend.controller;
import com.ehpnp.Backend.model.Vaccination;
import com.ehpnp.Backend.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
@CrossOrigin
public class VaccinationController {

    @Autowired
    VaccinationService vaccinationService;

    @PostMapping
    ResponseEntity<Vaccination> createCenter(@RequestBody Vaccination vaccination) {
        Vaccination vaccinationCreated = vaccinationService.create(vaccination);
        return ResponseEntity.status(HttpStatus.OK).body(vaccinationCreated);
    }

    @GetMapping
    ResponseEntity<List<Vaccination>> getAllVaccination(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vaccinationService.getVaccinationById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Vaccination> updateVaccination(@PathVariable Long id, @RequestBody Vaccination vaccination) {
        Vaccination updatedVaccination = vaccinationService.updateCenter(id, vaccination);
        return ResponseEntity.status(HttpStatus.OK).body(updatedVaccination);
    }
}
