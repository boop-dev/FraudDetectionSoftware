

CREATE TABLE IF NOT EXISTS institution (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    institution_code VARCHAR(4) NOT NULL,
    institution_type VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
)

CREATE TABLE IF NOT EXISTS accounts (
    id UUID PRIMARY KEY,
    institution_id UUID NOT NULL REFERENCES institution(id),
    account_number_hash VARCHAR(255) NOT NULL,
    account_holder_name VARCHAR(255) NOT NULL,
    account_holder_dob VARCHAR(255) NOT NULL,
    account_holder_tax_id_hash VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    date_opened DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
)

CREATE TABLE IF NOT EXISTS transactions (
    id UUID PRIMARY KEY,
    source_account_id VARCHAR(255) NOT NULL REFERENCES accounts(id),
    destination_account_id VARCHAR(255) NOT NULL REFERENCES accounts(id),
    institution_id VARCHAR(255) NOT NULL REFERENCES institution(id),
    amount NUMERIC(19,2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    transaction_type VARCHAR(255) NOT NULL,
    time_stamp TIMESTAMP NOT NULL,
    counterparty_institution VARCHAR(255) NOt NULL,
    counterparty_account_number VARCHAR(255) NOt NULL,
    status VARCHAR(255) NOT NULL,
    metadata JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
)

CREATE TABLE IF NOT EXISTS alerts (
    id UUID PRIMARY KEY,
    entity_id UUID NOT NULL REFERENCES accounts(id),
    rule_triggered VARCHAR(255) NOT NULL,
    severity VARCHAR(255) NOT NULL,
    triggered_at TIMESTAMP NOT NULL,
    evidence JSONB NOT NULL,
    status VARCHAR(255) NOT NULL
)

CREATE TABLE IF NOT EXISTS entity_matches(
    id UUID PRIMARY KEY,
    primary_account_id UUID NOT NULL REFERENCES accounts(id),
    matched_account_id UUID NOT NULL REFERENCES accounts(id),
    confidence_score DOUBLE NOT NULL,
    matched_fields JSONB NOT NULL,
)


