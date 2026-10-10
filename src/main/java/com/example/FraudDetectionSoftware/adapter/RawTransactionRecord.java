package com.example.FraudDetectionSoftware.adapter;

import com.example.FraudDetectionSoftware.model.Institution;
import lombok.Data;

import java.util.Map;

@Data
public class RawTransactionRecord {

    private String institution; // institution code

    private Map<String, String> values;

}
