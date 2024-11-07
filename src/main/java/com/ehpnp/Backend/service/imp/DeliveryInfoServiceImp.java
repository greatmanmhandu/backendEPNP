package com.ehpnp.Backend.service.imp;
import com.ehpnp.Backend.model.DeliveryInfo;
import com.ehpnp.Backend.model.DeliveryInfo;
import com.ehpnp.Backend.repository.DeliveryInfoRepository;
import com.ehpnp.Backend.repository.DeliveryInfoRepository;
import com.ehpnp.Backend.service.DeliveryInfoService;
import com.ehpnp.Backend.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryInfoServiceImp implements DeliveryInfoService {

    @Autowired
    DeliveryInfoRepository deliveryInfoRepository;


    @Override
    public DeliveryInfo create(DeliveryInfo deliveryInfo) {
        return deliveryInfoRepository.save(deliveryInfo);
    }



    @Override
    public  List<DeliveryInfo> getAll() {
        return deliveryInfoRepository.findAll();
    }

    @Override
    public DeliveryInfo getDeliveryInfoById(Long id) {
        Optional<DeliveryInfo> deliveryInfo = deliveryInfoRepository.findById(id);
        return deliveryInfo.get();
    }

    @Override
    public DeliveryInfo updateDelivery(Long id, DeliveryInfo deliveryInfo) {
        Optional<DeliveryInfo> optionalDelivery = deliveryInfoRepository.findById(id);

//        optionalDelivery.get().setName(deliveryInfo.getName());

        DeliveryInfo save = deliveryInfoRepository.save(optionalDelivery.get());
        return getDeliveryInfoById(save.getId());
    }
}
