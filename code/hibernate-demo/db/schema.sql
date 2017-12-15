USE test;

CREATE TABLE IF NOT EXISTS person(
    id VARCHAR(36) PRIMARY KEY,
    name TEXT NOT NULL,
    salary INTEGER NOT NULL
) CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS bank_account(
    id VARCHAR(36) PRIMARY KEY,
    account VARCHAR(36) NOT NULL,
    balance INTEGER NOT NULL
) CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS person_bank_account(
    person_id VARCHAR(36) NOT NULL ,
    bank_account_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (bank_account_id) REFERENCES bank_account(id)
) CHARACTER SET utf8;