package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.DeliveryInfo;
import com.ehpnp.Backend.model.Vaccination;

import java.util.List;

public interface DeliveryInfoService {


    DeliveryInfo create(DeliveryInfo deliveryInfo);

    List<DeliveryInfo> getAll();

    DeliveryInfo getDeliveryInfoById(Long id);

    DeliveryInfo updateDelivery(Long id, DeliveryInfo deliveryInfo);
}
