package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notificate(Transaction transaction, String email);
}
