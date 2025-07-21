package br.com.cnietsche.application.usecaseimpl;

import br.com.cnietsche.application.gateway.FindWalletByTaxNumberGateway;
import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.NotFoundException;
import br.com.cnietsche.core.exception.TaxNumberException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;
import br.com.cnietsche.usecase.FindWalletByTaxNumberUseCase;

import java.util.Objects;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(TaxNumber taxNumber) throws NotFoundException, TaxNumberException {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if (Objects.isNull(wallet)) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
