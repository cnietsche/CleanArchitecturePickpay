CREATE TABLE transaction(
    id                  BIGINT          AUTO_INCREMENT PRIMARY KEY,
    from_wallet         BIGINT          NOT NULL,
    to_wallet           BIGINT          NOT NULL,
    transaction_value   DECIMAL(10, 2)  NOT NULL,
    status              VARCHAR(30)     NOT NULL,
    created_at          DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          DATETIME,

    FOREIGN KEY (from_wallet)           REFERENCES wallet(id),
    FOREIGN KEY (to_wallet)             REFERENCES wallet(id)
);
