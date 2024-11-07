package com.ehpnp.Backend.repository;

import com.ehpnp.Backend.model.MedicalIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRepository extends JpaRepository<MedicalIssue, Long> {

}
