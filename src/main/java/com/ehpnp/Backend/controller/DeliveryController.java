package com.ehpnp.Backend.controller;
import com.ehpnp.Backend.model.DeliveryInfo;
import com.ehpnp.Backend.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin
public class DeliveryController {

    @Autowired
    DeliveryInfoService deliveryInfoService;

    @PostMapping
    ResponseEntity<DeliveryInfo> create(@RequestBody DeliveryInfo deliveryInfo) {
        DeliveryInfo deliveryInfoCreated = deliveryInfoService.create(deliveryInfo);
        return ResponseEntity.status(HttpStatus.OK).body(deliveryInfoCreated);
    }

    @GetMapping
    ResponseEntity<List<DeliveryInfo>> getAllDeliveryInfo(
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryInfoService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<DeliveryInfo> getDeliveryInfoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveryInfoService.getDeliveryInfoById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<DeliveryInfo> updateDeliveryInfo(@PathVariable Long id, @RequestBody DeliveryInfo deliveryInfo) {
        DeliveryInfo updatedDeliveryInfo = deliveryInfoService.updateDelivery(id, deliveryInfo);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDeliveryInfo);
    }
}
