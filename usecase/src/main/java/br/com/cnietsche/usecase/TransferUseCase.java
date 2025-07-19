package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.exception.InternalServerErrorException;
import br.com.cnietsche.core.exception.NotFoundException;
import br.com.cnietsche.core.exception.NotificationException;
import br.com.cnietsche.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(TaxNumber fromTaxNumber, TaxNumber toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException;
}
