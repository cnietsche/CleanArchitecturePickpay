package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.TransactionPin;
import br.com.cnietsche.core.exception.TransferException;

public interface TransactionPinValidateUseCase {

    Boolean validate(TransactionPin transactionPin) throws TransferException;
}
