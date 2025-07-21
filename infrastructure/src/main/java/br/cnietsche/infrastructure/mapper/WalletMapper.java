package br.cnietsche.infrastructure.mapper;

import br.cnietsche.infrastructure.entity.AppTransactionPin;
import br.cnietsche.infrastructure.entity.AppUser;
import br.cnietsche.infrastructure.entity.AppWallet;
import br.com.cnietsche.core.domain.Wallet;
import br.com.cnietsche.core.exception.TaxNumberException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WalletMapper {

    private final TransactionPinMapper transactionPinMapper;
    private final UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public AppWallet toEntity(Wallet wallet, AppUser appUser, AppTransactionPin appTransactionPin) {
        return new AppWallet(
                wallet.getBalance(),
                appUser,
                appTransactionPin,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt());
    }

    public Wallet toEntity(AppWallet appWallet) throws TaxNumberException {
        if (Objects.isNull(appWallet)) {
            return null;
        }
        return new Wallet(
                appWallet.getId(),
                transactionPinMapper.toEntity(appWallet.getAppTransactionPin()),
                appWallet.getBalance(),
                userMapper.toEntity(appWallet.getAppUser()),
                appWallet.getCreatedAt(),
                appWallet.getUpdatedAt());
    }
}
