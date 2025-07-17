package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.TaxNumberException;

public interface CreateUserUseCase {

    void create(User user) throws TaxNumberException, EmailException;
}
