package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.InternalServerErrorException;
import br.com.cnietsche.core.exception.TaxNumberException;
import br.com.cnietsche.core.exception.TransactionPinException;

public interface CreateUserUseCase {

    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
