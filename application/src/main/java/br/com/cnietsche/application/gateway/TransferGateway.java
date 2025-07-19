package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.Transaction;

public interface TransferGateway {

    Boolean transfer(Transaction transaction);
}
