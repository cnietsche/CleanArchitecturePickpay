package br.com.cnietsche.core.domain;

import br.com.cnietsche.core.domain.enums.UserTypeEnum;
import br.com.cnietsche.core.exception.TransferException;
import br.com.cnietsche.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Wallet {

    private UUID id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet() {
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet(UUID id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }
        if (this.balance.compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }
        this.balance = this.balance.subtract(value);
    }

    public void receive(BigDecimal value) {
        this.balance = this.balance.add(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
