package br.com.cnietsche.application.gateway;

public interface UserAuthenticateGateway {

    Boolean authenticate(String username, String password);
}
