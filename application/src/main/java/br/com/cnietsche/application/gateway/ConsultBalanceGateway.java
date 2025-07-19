package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);
}
