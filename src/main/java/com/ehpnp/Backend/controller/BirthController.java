package com.ehpnp.Backend.controller;
import com.ehpnp.Backend.model.ChildBirth;
import com.ehpnp.Backend.service.ChildBirthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birth")
@CrossOrigin
public class BirthController {

    @Autowired
    ChildBirthService childBirthService;

    @PostMapping
    ResponseEntity<ChildBirth> create(@RequestBody ChildBirth childBirth) {
        ChildBirth created = childBirthService.create(childBirth);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @GetMapping
    ResponseEntity<List<ChildBirth>> getAllChildBirth(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(childBirthService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ChildBirth> getChildBirthById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(childBirthService.getChildBirthById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<ChildBirth> updateChildBirth(@PathVariable Long id, @RequestBody ChildBirth childBirth) {
        ChildBirth updatedChildBirth = childBirthService.updateCenter(id, childBirth);
        return ResponseEntity.status(HttpStatus.OK).body(updatedChildBirth);
    }
}
