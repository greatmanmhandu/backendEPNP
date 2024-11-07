package com.ehpnp.Backend.repository;

import com.ehpnp.Backend.model.Centers;
import com.ehpnp.Backend.model.ChildBirth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildBirthRepository extends JpaRepository<ChildBirth, Long> {

}
