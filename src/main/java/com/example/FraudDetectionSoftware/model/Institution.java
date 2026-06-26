package com.example.FraudDetectionSoftware.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data // automatic getters and setters
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", columnDefinition = "uuid")
    private UUID id;

    @NotNull
    @Column(name="id")
    private String name;

    @NotNull
    @Column(name="institution_code")
    private int institutionCode;

    @NotNull
    @Column(name="institution_type")
    private institutionType type;

    @NotNull
    @Column(name="created at")
    private LocalDateTime created_at;

    public enum institutionType{
        BANK,
        CREDIT_UNION,
        FINTECH
    }
}
