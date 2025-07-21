package br.com.cnietsche.usecase;

import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(TaxNumber fromTaxNumber, TaxNumber toTaxNumber, BigDecimal value, String pin)
            throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException, TaxNumberException;
}
