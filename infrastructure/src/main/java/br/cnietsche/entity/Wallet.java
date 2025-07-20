package br.cnietsche.entity;

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
public class Wallet {

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
    private TransactionPin transactionPin;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
