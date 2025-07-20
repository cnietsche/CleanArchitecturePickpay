CREATE TABLE transaction_pin(
    id                  BIGINT          AUTO_INCREMENT PRIMARY KEY,
    pin                 VARCHAR(50)     NOT NULL,
    attempt             INT             NOT NULL,
    blocked             BOOL            NOT NULL,
    created_at          DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          DATETIME
);
