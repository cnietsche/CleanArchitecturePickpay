package br.com.cnietsche.application.gateway;

import br.com.cnietsche.core.domain.Transaction;

public interface UserNotificationGateway {

    Boolean notificate(Transaction transaction, String email);
}
