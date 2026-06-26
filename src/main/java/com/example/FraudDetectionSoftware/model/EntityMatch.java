package com.example.FraudDetectionSoftware.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.JsonJdbcType;

import java.util.UUID;

@Entity
@Table(name = "entity_matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_account_id")
    private Account primaryAccount;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matched_account_id")
    private Account matchedAccount;

    @Column
    private double confidenceScore;

    @Column(name = "matched_fields", columnDefinition = "jsonb")
    @JdbcType(JsonJdbcType.class)
    private String matchedFields;

}
