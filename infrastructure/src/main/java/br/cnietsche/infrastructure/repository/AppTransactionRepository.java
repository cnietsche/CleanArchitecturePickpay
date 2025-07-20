package br.cnietsche.infrastructure.repository;

import br.cnietsche.infrastructure.entity.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTransactionRepository extends JpaRepository<AppTransaction, Long> {
}
