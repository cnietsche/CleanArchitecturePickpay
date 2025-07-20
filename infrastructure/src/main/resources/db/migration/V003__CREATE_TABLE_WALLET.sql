CREATE TABLE wallet(
    id                  BIGINT          AUTO_INCREMENT PRIMARY KEY,
    balance             DECIMAL(10, 2)  NOT NULL,
    user_id             UUID            NOT NULL UNIQUE,
    transaction_pin_id  BIGINT          NOT NULL UNIQUE,
    created_at          DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          DATETIME,

    FOREIGN KEY (user_id)               REFERENCES app_user(id),
    FOREIGN KEY (transaction_pin_id)    REFERENCES transaction_pin(id)
);
