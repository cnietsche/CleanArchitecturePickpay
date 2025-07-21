package br.cnietsche.infrastructure.repository;

import br.cnietsche.infrastructure.entity.AppWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppWalletRepository extends JpaRepository<AppWallet, Long> {

    AppWallet findByAppUserTaxNumber(String taxNumber);
}
