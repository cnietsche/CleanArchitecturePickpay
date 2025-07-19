package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.CreateUserGateway;
import br.com.cnietsche.core.domain.TransactionPin;
import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.InternalServerErrorException;
import br.com.cnietsche.core.exception.TaxNumberException;
import br.com.cnietsche.core.exception.TransactionPinException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;
    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;

    public CreateUserUseCaseImpl(
            CreateUserGateway createUserGateway,
            TaxNumberAvailableUseCase taxNumberAvailableUseCase,
            EmailAvailableUseCase emailAvailableUseCase) {
        this.createUserGateway = createUserGateway;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        if (!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransactionPin(user, pin))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
