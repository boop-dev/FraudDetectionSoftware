package com.example.FraudDetectionSoftware.adapter;
import com.example.FraudDetectionSoftware.model.Institution;
import com.example.FraudDetectionSoftware.model.Transaction;

import java.util.Map;

public interface InstitutionAdapter {

    Transaction normalize(RawTransactionRecord raw);

    Institution.InstitutionType getInstitution();

}


