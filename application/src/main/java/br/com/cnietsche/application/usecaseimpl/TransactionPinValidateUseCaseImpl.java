package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.TransactionPinValidateGateway;
import br.com.cnietsche.core.domain.TransactionPin;
import br.com.cnietsche.core.exception.PinException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.TransactionPinValidateUseCase;
import br.com.cnietsche.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final TransactionPinValidateGateway transactionPinValidateGateway;
    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(
            TransactionPinValidateGateway transactionPinValidateGateway,
            UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PN0001.getMessage(), ErrorCodeEnum.PN0001.getCode());
        }
        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            var updatedTransactionPin = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.getPN0002Message(updatedTransactionPin.getAttempt()), ErrorCodeEnum.PN0002.getCode());
        }
        if (transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
