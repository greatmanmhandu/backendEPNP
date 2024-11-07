package com.ehpnp.Backend.repository;


import com.ehpnp.Backend.model.PretermDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretermRepository extends JpaRepository<PretermDetails, Long> {

}
