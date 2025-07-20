package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {

    boolean validate(TransactionPin transactionPin);
}
