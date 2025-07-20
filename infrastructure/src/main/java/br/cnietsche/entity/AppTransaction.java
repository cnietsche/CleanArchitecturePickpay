package br.cnietsche.entity;

import br.com.cnietsche.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "APP_TRANSACTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTransaction {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FROM_WALLET", nullable = false)
    private Wallet fromWallet;

    @ManyToOne
    @JoinColumn(name = "TO_WALLET", nullable = false)
    private Wallet toWallet;

    @Column(name = "TRANSACTION_VALUE", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
