package br.cnietsche.infrastructure.service;

import br.cnietsche.infrastructure.mapper.TransactionPinMapper;
import br.cnietsche.infrastructure.mapper.UserMapper;
import br.cnietsche.infrastructure.mapper.WalletMapper;
import br.cnietsche.infrastructure.repository.AppUserRepository;
import br.cnietsche.infrastructure.repository.TransactionPinRepository;
import br.cnietsche.infrastructure.repository.WalletRepository;
import br.com.cnietsche.application.gateway.CreateUserGateway;
import br.com.cnietsche.core.domain.User;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.EmailException;
import br.com.cnietsche.core.exception.TaxNumberException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.cnietsche.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final AppUserRepository appUserRepository;
    private final TransactionPinRepository transactionPinRepository;
    private final WalletRepository walletRepository;
    private final UserMapper userMapper;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletMapper walletMapper;

    public CreateUserGatewayImpl(
            AppUserRepository appUserRepository,
            TransactionPinRepository transactionPinRepository,
            WalletRepository walletRepository,
            UserMapper userMapper,
            TransactionPinMapper transactionPinMapper,
            WalletMapper walletMapper) {
        this.appUserRepository = appUserRepository;
        this.transactionPinRepository = transactionPinRepository;
        this.walletRepository = walletRepository;
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) throws TaxNumberException, EmailException {
        try {
            log.info("Start of user creation::CreateUserGatewayImpl");
            var savedUser = appUserRepository.save(userMapper.toEntity(user));
            var savedTransactionPin = transactionPinRepository.save(transactionPinMapper.toEntity(wallet.getTransactionPin()));
            walletRepository.save(walletMapper.toEntity(wallet, savedUser, savedTransactionPin));
            log.info("End of user creation::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.info("Error at user creation::CreateUserGatewayImpl");
            return false;
        }
    }
}
