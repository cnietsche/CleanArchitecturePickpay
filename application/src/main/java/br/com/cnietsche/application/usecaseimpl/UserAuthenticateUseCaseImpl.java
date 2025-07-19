package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.UserAuthenticateGateway;
import br.com.cnietsche.core.exception.AuthenticateException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {

    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if (!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticateException(ErrorCodeEnum.AU0001.getMessage(), ErrorCodeEnum.AU0001.getCode());
        }
        return true;
    }
}
