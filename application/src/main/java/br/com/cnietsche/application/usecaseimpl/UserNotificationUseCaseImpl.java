package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.UserNotificationGateway;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
