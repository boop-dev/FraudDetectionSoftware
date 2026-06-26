package com.example.FraudDetectionSoftware.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data // automatic getters and setters
@Table(name = "institutions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", columnDefinition = "uuid")
    private UUID id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="institution_code")
    private String institutionCode;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="institution_type")
    private InstitutionType type;

    @NotNull
    @Column(name="created_at")
    private LocalDateTime createdAt;

    public enum InstitutionType{
        BANK,
        CREDIT_UNION,
        FINTECH
    }
}
