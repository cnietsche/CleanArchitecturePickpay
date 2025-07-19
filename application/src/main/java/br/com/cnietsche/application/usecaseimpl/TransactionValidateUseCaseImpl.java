package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.TransactionValidateGateway;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.exception.TransferException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
