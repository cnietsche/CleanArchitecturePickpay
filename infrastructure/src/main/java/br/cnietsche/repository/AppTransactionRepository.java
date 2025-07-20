package br.cnietsche.repository;

import br.cnietsche.entity.AppTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTransactionRepository extends JpaRepository<AppTransaction, Long> {
}
