package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.TransferGateway;
import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Transaction;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.*;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final TransferGateway transferGateway;
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final UserNotificationUseCase userNotificationUseCase;
    private final TransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCaseImpl(
            TransferGateway transferGateway,
            FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase,
            TransactionValidateUseCase transactionValidateUseCase,
            CreateTransactionUseCase createTransactionUseCase,
            UserNotificationUseCase userNotificationUseCase,
            TransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.transferGateway = transferGateway;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public Boolean transfer(TaxNumber fromTaxNumber, TaxNumber toTaxNumber, BigDecimal value, String pin)
            throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException {
        Wallet from = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);
        if (from.getTransactionPin().getBlocked()) {
            throw new PinException(ErrorCodeEnum.PN0001.getMessage(), ErrorCodeEnum.PN0001.getCode());
        }
        transactionPinValidateUseCase.validate(from.getTransactionPin());
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
