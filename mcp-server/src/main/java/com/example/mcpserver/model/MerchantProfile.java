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
@Table(name = "MERCHANT_PROFILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MerchantProfileId.class)
public class MerchantProfile {

    @Id
    private Long acquirer;

    @Id
    private Long merchant;

    @Id
    @Column(name = "TERMINAL_DETAILS")
    private Long terminalDetails;

    private Long count;

    private BigDecimal amount;
}
