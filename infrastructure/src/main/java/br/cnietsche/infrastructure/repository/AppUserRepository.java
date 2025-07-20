package br.cnietsche.infrastructure.repository;

import br.cnietsche.infrastructure.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    Boolean existsByTaxNumber(String taxNumber);

    Boolean existsByEmail(String email);
}
