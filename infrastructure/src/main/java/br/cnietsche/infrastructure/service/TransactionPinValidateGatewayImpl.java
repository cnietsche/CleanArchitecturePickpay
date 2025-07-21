package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.repository.TransactionPinRepository;
import br.com.cnietsche.application.gateway.TransactionPinValidateGateway;
import br.com.cnietsche.core.domain.TransactionPin;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private final TransactionPinRepository transactionPinRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinRepository transactionPinRepository) {
        this.transactionPinRepository = transactionPinRepository;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) {
        var savedTransactionPin = transactionPinRepository.findById(transactionPin.getId());
        if (savedTransactionPin.isEmpty()) {
            return false;
        }
        if (!Objects.equals(savedTransactionPin.get().getPin(), transactionPin.getPin())) {
            return false;
        }
        return true;
    }
}
