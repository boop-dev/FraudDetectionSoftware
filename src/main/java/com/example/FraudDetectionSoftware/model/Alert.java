package com.example.FraudDetectionSoftware.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.JsonJdbcType;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(name = "alerts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_id", nullable = false)
    private Account entityId;

    @NotNull
    @Column
    private String ruleTriggered;

    @NotNull
    @Column(name = "severity")
    @Enumerated(EnumType.STRING)
    private Severity severity;

    @NotNull
    @Column(name = "triggered_at")
    private Instant triggeredAt;

    @NotNull
    @Column(name = "evidence", columnDefinition = "jsonb")
    @JdbcType(JsonJdbcType.class)
    private String evidence;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AlertStatus status;

    public enum AlertStatus{
        OPEN,
        REVIEWED,
        FALSE_POSITIVE,
        CONFIRMED_FRAUD,
    }

    public enum Severity{
        LOW,
        MEDIUM,
        HIGH,
    }

}
