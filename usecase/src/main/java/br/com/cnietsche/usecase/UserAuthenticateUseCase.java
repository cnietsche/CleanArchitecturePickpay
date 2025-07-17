package br.com.cnietsche.usecase;

public interface UserAuthenticateUseCase {

    Boolean authenticate(String username, String password);
}
