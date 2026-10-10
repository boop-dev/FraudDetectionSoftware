package com.example.FraudDetectionSoftware.adapter;

import com.example.FraudDetectionSoftware.model.Account;
import com.example.FraudDetectionSoftware.model.Institution;
import com.example.FraudDetectionSoftware.model.Transaction;

import java.math.BigDecimal;
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

        Account sourceAccount = new Account();
        UUID sourceAccountID = UUID.fromString(values.get("account_id"));
        sourceAccount.setId(sourceAccountID);

        transaction.setSourceAccount(
                sourceAccount
        );

        return transaction;
    }

    @Override
    public Institution.InstitutionType getInstitution(RawTransactionRecord raw) {
       return raw.getInstitution().getType();
    }
}
