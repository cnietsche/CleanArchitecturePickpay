package br.com.cnietsche.usecase;

import br.com.cnietsche.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {

    Boolean authenticate(String username, String password) throws AuthenticateException;
}
