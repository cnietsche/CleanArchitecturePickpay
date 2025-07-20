package br.cnietsche.infrastructure.repository;

import br.cnietsche.infrastructure.entity.TransactionPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPinRepository extends JpaRepository<TransactionPin, Long> {
}
