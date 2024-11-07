package com.ehpnp.Backend.service;

import com.ehpnp.Backend.model.PretermDetails;

import java.util.List;

public interface PretermService {

    PretermDetails createPreterm(PretermDetails pretermDetails);

    List<PretermDetails> getAllPreterms();

    PretermDetails getPretermById(Long id);


    PretermDetails updatePreterm(Long customerId, PretermDetails pretermDetails);
}
