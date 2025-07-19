package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.TransactionPin;
import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.TaxNumberException;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet, TransactionPin transactionPin) throws TaxNumberException, EmailException;
}
