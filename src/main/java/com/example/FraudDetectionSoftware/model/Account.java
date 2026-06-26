package com.example.FraudDetectionSoftware.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @NotNull
    @Column(name = "account_number_hash")
    private String accountNumberHash;

    @NotNull
    @Column(name = "account_holder_name")
    private String accountHolderName;

    @NotNull
    @Column(name = "account_holder_dob")
    private LocalDate accountHolderDob;

    @NotNull
    @Column(name = "account_holder_tax_id_hash")
    private String accountHolderTaxIdHash;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @NotNull
    @Column(name = "date_opened")
    private Date dateOpened;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum AccountType{
        CHECKING,
        SAVINGS,
        BUSINESS,
    }

    public enum Status{
        ACTIVE,
        CLOSED,
        FROZEN,
    }

}
