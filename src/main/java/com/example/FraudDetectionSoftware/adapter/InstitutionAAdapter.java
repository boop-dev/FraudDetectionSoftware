package com.example.FraudDetectionSoftware.adapter;

import com.example.FraudDetectionSoftware.model.Account;
import com.example.FraudDetectionSoftware.model.Institution;
import com.example.FraudDetectionSoftware.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;


public class InstitutionAAdapter implements InstitutionAdapter {

    @Override
    public Transaction normalize(RawTransactionRecord raw) {

        Transaction transaction = new Transaction();
        Map<String, String> values = raw.getValues();

        transaction.setAmount(
                new BigDecimal(values.get("amount"))
        );

        transaction.setCurrency(values.get("currency"));

        Institution institution = new Institution();
        institution.setInstitutionCode(raw.getInstitution());
        transaction.setInstitution(institution);

        String rawType = values.get("type").trim().toUpperCase();
        Transaction.TransactionType type = switch (rawType) {
            case "TRANSFER", "WIRE" -> Transaction.TransactionType.TRANSFER;
            case "DEPOSIT" -> Transaction.TransactionType.DEPOSIT;
            case "WITHDRAWAL" -> Transaction.TransactionType.WITHDRAWAL;
            case "PAYMENT" -> Transaction.TransactionType.PAYMENT;
            default -> throw new IllegalArgumentException("Unknown transaction type from Institution A: " + rawType);
        };
        transaction.setTransactionType(type);

        String rawStatus = values.get("status").trim().toUpperCase();
        Transaction.TransactionStatus status = switch (rawStatus) {
            case "PENDING" -> Transaction.TransactionStatus.PENDING;
            case "FAILED" -> Transaction.TransactionStatus.FAILED;
            case "COMPLETED" -> Transaction.TransactionStatus.COMPLETED;
            case "CANCELLED" -> Transaction.TransactionStatus.CANCELLED;
            default -> throw new IllegalArgumentException("Unknown transaction status from Institution A: " + rawStatus);
        };
        transaction.setStatus(status);


        transaction.setTimestamp(LocalDateTime.parse(values.get("timestamp")));

        Account sourceAccount = new Account();
        UUID sourceAccountID = UUID.fromString(values.get("account_id"));
        sourceAccount.setId(sourceAccountID);

        transaction.setSourceAccount(
                sourceAccount
        );

        return transaction;
    }

    @Override
    public Institution.InstitutionType getInstitution() {
       return Institution.InstitutionType.BANK;
    }
}
