package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.User;

public interface FindUserByTaxNumberUseCase {

    User findByTaxNumber(TaxNumber taxNumber);
}
