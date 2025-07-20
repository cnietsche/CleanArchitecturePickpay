package br.cnietsche.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "WALLET")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppWallet {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;

    @OneToOne
    @JoinColumn(name = "TRANSACTION_PIN_ID")
    private AppTransactionPin appTransactionPin;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public AppWallet(BigDecimal balance, AppUser appUser, AppTransactionPin appTransactionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.balance = balance;
        this.appUser = appUser;
        this.appTransactionPin = appTransactionPin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
