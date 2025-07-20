package br.cnietsche.infrastructure.mapper;

import br.cnietsche.infrastructure.entity.AppTransactionPin;
import br.cnietsche.infrastructure.entity.AppUser;
import br.cnietsche.infrastructure.entity.AppWallet;
import br.com.cnietsche.core.domain.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public AppWallet toEntity(Wallet wallet, AppUser appUser, AppTransactionPin appTransactionPin) {
        return new AppWallet(
                wallet.getBalance(),
                appUser,
                appTransactionPin,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt());
    }
}
