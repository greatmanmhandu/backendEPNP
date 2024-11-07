package com.ehpnp.Backend.repository;

import com.ehpnp.Backend.model.DeliveryInfo;
import com.ehpnp.Backend.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long> {

}