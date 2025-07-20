package br.cnietsche.repository;

import br.cnietsche.entity.TransactionPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPinRepository extends JpaRepository<TransactionPin, Long> {
}
