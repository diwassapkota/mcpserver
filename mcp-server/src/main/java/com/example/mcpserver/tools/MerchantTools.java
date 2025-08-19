package com.example.mcpserver.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MerchantTools {

    private final JdbcTemplate jdbcTemplate;

    public MerchantTools(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Tool(name = "merchant_by_id", description = "Fetch merchant profile by merchant_id from TiDB/MySQL. Returns JSON.")
    public Map<String, Object> merchantById(
            @ToolParam(description = "Merchant ID") long merchantId
    ) {
        String sql = "SELECT * FROM MERCHANT_PROFILE WHERE MERCHANT = ?";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                return Map.of(
                        "ACQUIRER", rs.getLong("ACQUIRER"),
                        "MERCHANT", rs.getLong("MERCHANT"),
                        "TERMINAL_DETAILS", rs.getLong("TERMINAL_DETAILS"),
                        "COUNT", rs.getLong("COUNT"),
                        "AMOUNT", rs.getBigDecimal("AMOUNT")
                );
            }
            return Map.of();
        }, merchantId);
    }

    @Tool(name = "merchant_transactions", description = "Aggregate transactions for a merchant. Returns totals and count.")
    public Map<String, Object> merchantTxnAgg(
            @ToolParam(description = "Merchant ID") long merchantId
    ) {
        String sql = """
                SELECT COUNT(*) AS tx_count, COALESCE(SUM(TXN_AMOUNT),0) AS total_amount
                FROM MERCHANT_PAYMENT_ADVICE
                WHERE MERCHANT = ?
                """;
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                return Map.of(
                        "tx_count", rs.getLong("tx_count"),
                        "total_amount", rs.getBigDecimal("total_amount")
                );
            }
            return Map.of("tx_count", 0, "total_amount", 0);
        }, merchantId);
    }
}
