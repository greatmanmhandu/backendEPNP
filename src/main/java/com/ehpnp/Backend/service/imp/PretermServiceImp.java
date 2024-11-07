package com.ehpnp.Backend.service.imp;

import com.ehpnp.Backend.model.PretermDetails;
import com.ehpnp.Backend.repository.PretermRepository;
import com.ehpnp.Backend.service.PretermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PretermServiceImp implements PretermService {

    @Autowired
    PretermRepository pretermRepository;



    @Override
    public PretermDetails createPreterm(PretermDetails pretermDetails) {
        return pretermRepository.save(pretermDetails);
    }

    @Override
    public  List<PretermDetails> getAllPreterms() {
        return pretermRepository.findAll();
    }

    @Override
    public PretermDetails getPretermById(Long id) {
        Optional<PretermDetails> pretermDetails = pretermRepository.findById(id);
        return pretermDetails.get();
    }

    @Override
    public PretermDetails updatePreterm(Long id, PretermDetails pretermDetails) {
        Optional<PretermDetails> pretermDetailOptional = pretermRepository.findById(id);

        pretermDetailOptional.get().setDescription(pretermDetails.getDescription());

        PretermDetails save = pretermRepository.save(pretermDetailOptional.get());
        return getPretermById(save.getId());
    }
}
