package com.ehpnp.Backend.repository;

import com.ehpnp.Backend.model.Centers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Centers, Long> {

}
