package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consultBalance(Wallet wallet);
}
