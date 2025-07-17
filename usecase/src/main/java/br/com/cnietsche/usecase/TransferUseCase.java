package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Transaction;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction);
}
