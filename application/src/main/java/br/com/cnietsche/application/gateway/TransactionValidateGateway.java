package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);
}
