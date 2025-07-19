package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);
}
