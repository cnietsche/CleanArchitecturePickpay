package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.EmailAvailableGateway;
import br.com.cnietsche.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
