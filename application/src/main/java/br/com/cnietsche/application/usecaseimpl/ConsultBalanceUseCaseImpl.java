package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.ConsultBalanceGateway;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private final ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consultBalance(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
