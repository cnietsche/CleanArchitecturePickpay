package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {

    Wallet findByTaxNumber(TaxNumber taxNumber) throws NotFoundException;
}
