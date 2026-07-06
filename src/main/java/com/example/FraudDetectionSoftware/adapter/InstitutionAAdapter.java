package com.example.FraudDetectionSoftware.adapter;

import com.example.FraudDetectionSoftware.model.Institution;
import com.example.FraudDetectionSoftware.model.Transaction;

import java.math.BigDecimal;

public class InstitutionAAdapter implements InstitutionAdapter {
    @Override
    public Transaction normalize(RawTransactionRecord raw) {

        Transaction transaction = new Transaction();

        transaction.setAmount(
                new BigDecimal(raw.get("amount"))
        );

        transaction.setCurrency(raw.get("currency"));

        transaction.setSourceAccount(
                raw.get("account")
        );
    }

    @Override
    public Institution.InstitutionType getInstitution() {
        return null;
    }
}
