package br.cnietsche.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION_PIN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTransactionPin {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PIN", nullable = false)
    private String pin;

    @Column(name = "ATTEMPT", nullable = false)
    private Integer attempt;

    @Column(name = "BLOCKED", nullable = false)
    private Boolean blocked;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public AppTransactionPin(String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
