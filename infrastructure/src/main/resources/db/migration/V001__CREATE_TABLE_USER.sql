CREATE TABLE app_user(
    id                  UUID            NOT NULL PRIMARY KEY,
    email               VARCHAR(70)     NOT NULL UNIQUE,
    password            VARCHAR(50)     NOT NULL,
    tax_number          VARCHAR(15)     NOT NULL UNIQUE,
    full_name           VARCHAR(70)     NOT NULL,
    type                VARCHAR(30)     NOT NULL,
    created_at          DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          DATETIME
);
