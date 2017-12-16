USE test;

CREATE TABLE IF NOT EXISTS person(
    id VARCHAR(36) PRIMARY KEY,
    name TEXT NOT NULL,
    salary INTEGER NOT NULL
) CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS bank_account(
    id VARCHAR(36) PRIMARY KEY,
    account VARCHAR(36) NOT NULL,
    balance INTEGER NOT NULL,
    person_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id),
    CONSTRAINT account_unq UNIQUE(account)
) CHARACTER SET utf8;