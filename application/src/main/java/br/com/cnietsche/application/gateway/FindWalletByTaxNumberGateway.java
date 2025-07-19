package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(TaxNumber taxNumber);
}
