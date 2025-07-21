package br.cnietsche.infrastructure.mapper;

import br.cnietsche.infrastructure.entity.AppTransactionPin;
import br.com.cnietsche.core.domain.TransactionPin;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public AppTransactionPin toEntity(TransactionPin transactionPin) {
        return new AppTransactionPin(
                transactionPin.getPin(),
                transactionPin.getAttempt(),
                transactionPin.getBlocked(),
                transactionPin.getCreatedAt(),
                transactionPin.getUpdatedAt());
    }

    public TransactionPin toEntity(AppTransactionPin appTransactionPin) {
        return new TransactionPin(
                appTransactionPin.getId(),
                appTransactionPin.getPin(),
                appTransactionPin.getAttempt(),
                appTransactionPin.getBlocked(),
                appTransactionPin.getCreatedAt(),
                appTransactionPin.getUpdatedAt());
    }
}
