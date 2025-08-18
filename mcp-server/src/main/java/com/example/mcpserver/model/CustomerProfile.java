package com.example.mcpserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "CUSTOMER_PROFILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CustomerProfileId.class)
public class CustomerProfile {

    @Id
    @Column(name = "ISSUER_NAME")
    private String issuerName;

    @Id
    private String initiator;

    private Long count;

    private BigDecimal amount;
}
