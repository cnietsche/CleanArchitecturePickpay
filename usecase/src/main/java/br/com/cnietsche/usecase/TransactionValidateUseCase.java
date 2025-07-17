package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Transaction;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction);
}
