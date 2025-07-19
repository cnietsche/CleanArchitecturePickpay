package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.exception.TransferException;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction) throws TransferException;
}
