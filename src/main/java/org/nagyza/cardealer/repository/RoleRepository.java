package org.nagyza.cardealer.repository;

import java.util.Optional;

import org.nagyza.cardealer.model.security.ERole;
import org.nagyza.cardealer.model.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
