package com.example.mcpserver.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionMinuteSummaryId implements Serializable {
    private Date summaryDate;
    private Time summaryMinute;
}
