package com.ehpnp.Backend.controller;
import com.ehpnp.Backend.model.Centers;
import com.ehpnp.Backend.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
@CrossOrigin
public class CenterController {

    @Autowired
    CenterService centerService;

    @PostMapping
    ResponseEntity<Centers> createCenter(@RequestBody Centers center) {
        Centers centersCreated = centerService.createCenter(center);
        return ResponseEntity.status(HttpStatus.OK).body(centersCreated);
    }

    @GetMapping
    ResponseEntity<List<Centers>> getAllCenters(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(centerService.getAllCenters());
    }

    @GetMapping("/{id}")
    ResponseEntity<Centers> getCenterById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(centerService.getCenterById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Centers> updateCenter(@PathVariable Long id, @RequestBody Centers centers) {
        Centers updatedCenter = centerService.updateCenter(id, centers);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCenter);
    }
}
