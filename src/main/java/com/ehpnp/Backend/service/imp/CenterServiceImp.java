package com.ehpnp.Backend.service.imp;
import com.ehpnp.Backend.model.Centers;
import com.ehpnp.Backend.repository.CenterRepository;
import com.ehpnp.Backend.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImp implements CenterService {

    @Autowired
    CenterRepository centerRepository;


    @Override
    public Centers createCenter(Centers centers) {
        return centerRepository.save(centers);
    }

    @Override
    public  List<Centers> getAllCenters() {
        return centerRepository.findAll();
    }

    @Override
    public Centers getCenterById(Long id) {
        Optional<Centers> centers = centerRepository.findById(id);
        return centers.get();
    }

    @Override
    public Centers updateCenter(Long id, Centers centers) {
        Optional<Centers> centerOptional = centerRepository.findById(id);

        centerOptional.get().setName(centers.getName());
        centerOptional.get().setAddress(centers.getAddress());
        centerOptional.get().setCity(centers.getCity());

        Centers save = centerRepository.save(centerOptional.get());
        return getCenterById(save.getId());
    }
}
