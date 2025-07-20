package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.core.domain.TransactionPin;
import br.com.cnietsche.core.exception.TransferException;
import br.com.cnietsche.usecase.TransactionPinValidateUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransferException {
        return null;
    }
}
