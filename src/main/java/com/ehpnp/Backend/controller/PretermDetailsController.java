package com.ehpnp.Backend.controller;

import com.ehpnp.Backend.model.PretermDetails;
import com.ehpnp.Backend.service.PretermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preterm")
@CrossOrigin
public class PretermDetailsController {

    @Autowired
    PretermService pretermService;


    @PostMapping
    ResponseEntity<PretermDetails> createPreterm(@RequestBody PretermDetails pretermDetails) {
        // Exceptions
        PretermDetails createdPreterm = pretermService.createPreterm(pretermDetails);
        return ResponseEntity.status(HttpStatus.OK).body(createdPreterm);
    }

    @GetMapping
    ResponseEntity<List<PretermDetails>> getAllPreterms(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(pretermService.getAllPreterms());
    }

    @GetMapping("/{id}")
    ResponseEntity<PretermDetails> getPretermById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pretermService.getPretermById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<PretermDetails> updateCustomer(@PathVariable Long id, @RequestBody PretermDetails pretermDetails) {
        PretermDetails updatedPreterm = pretermService.updatePreterm(id, pretermDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPreterm);
    }
}
