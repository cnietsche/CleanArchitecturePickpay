package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.CreateTransactionGateway;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.exception.TransferException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.CreateTransactionUseCase;

import java.util.Objects;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        var createdTransaction = createTransactionGateway.create(transaction);
        if (Objects.isNull(createdTransaction)) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return createdTransaction;
    }
}
