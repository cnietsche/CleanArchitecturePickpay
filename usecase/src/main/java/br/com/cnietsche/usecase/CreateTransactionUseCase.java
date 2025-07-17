package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.Transaction;

public interface CreateTransactionUseCase {

    void create(Transaction transaction);
}
