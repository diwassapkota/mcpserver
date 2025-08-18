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
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION_MINUTE_SUMMARY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TransactionMinuteSummaryId.class)
public class TransactionMinuteSummary {

    @Id
    @Column(name = "SUMMARY_DATE")
    private Date summaryDate;

    @Id
    @Column(name = "SUMMARY_MINUTE")
    private Time summaryMinute;

    @Column(name = "TXN_COUNT")
    private Long txnCount;

    @Column(name = "TXN_AMOUNT")
    private BigDecimal txnAmount;
}
