package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.TransferGateway;
import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.InternalServerErrorException;
import br.com.cnietsche.core.exception.NotFoundException;
import br.com.cnietsche.core.exception.NotificationException;
import br.com.cnietsche.core.exception.TransferException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final TransferGateway transferGateway;
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final UserNotificationUseCase userNotificationUseCase;

    public TransferUseCaseImpl(
            TransferGateway transferGateway,
            FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase,
            TransactionValidateUseCase transactionValidateUseCase,
            CreateTransactionUseCase createTransactionUseCase, UserNotificationUseCase userNotificationUseCase) {
        this.transferGateway = transferGateway;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public Boolean transfer(TaxNumber fromTaxNumber, TaxNumber toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);
        from.transfer(value);
        to.receive(value);
        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));
        transactionValidateUseCase.validate(transaction);
        if (transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }
        return true;
    }
}
