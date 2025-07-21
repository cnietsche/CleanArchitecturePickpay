package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.mapper.WalletMapper;
import br.cnietsche.infrastructure.repository.AppWalletRepository;
import br.com.cnietsche.application.gateway.FindWalletByTaxNumberGateway;
import br.com.cnietsche.core.domain.TaxNumber;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.TaxNumberException;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private final AppWalletRepository appWalletRepository;
    private final WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(
            AppWalletRepository appWalletRepository,
            WalletMapper walletMapper) {
        this.appWalletRepository = appWalletRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(TaxNumber taxNumber) throws TaxNumberException {
        return walletMapper.toEntity(appWalletRepository.findByAppUserTaxNumber(taxNumber.getValue()));
    }
}
