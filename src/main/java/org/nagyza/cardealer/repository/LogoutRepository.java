package org.nagyza.cardealer.repository;

import org.nagyza.cardealer.model.security.Logout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogoutRepository extends JpaRepository<Logout, Long> {
}
