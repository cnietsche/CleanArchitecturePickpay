package br.cnietsche.infrastructure.repository;

import br.cnietsche.infrastructure.entity.AppTransactionPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPinRepository extends JpaRepository<AppTransactionPin, Long> {
}
