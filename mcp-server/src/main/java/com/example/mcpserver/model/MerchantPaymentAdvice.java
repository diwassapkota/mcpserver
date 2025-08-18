package com.example.mcpserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "MERCHANT_PAYMENT_ADVICE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantPaymentAdvice {

    @Id
    private Long id;

    private Long acquirer;

    private Long merchant;

    @Column(name = "TERMINAL_DETAILS")
    private Long terminalDetails;

    @Column(name = "RETRIEVAL_REFERENCE_NUMBER")
    private String retrievalReferenceNumber;

    @Column(name = "TXN_AMOUNT")
    private BigDecimal txnAmount;

    private String initiator;

    @Column(name = "FONEPAY_SESSION_ID")
    private Long fonepaySessionId;

    @Column(name = "REQUEST_LOG")
    private String requestLog;
}
