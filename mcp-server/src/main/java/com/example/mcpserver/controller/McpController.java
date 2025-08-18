package com.example.mcpserver.controller;

import com.example.mcpserver.service.McpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcp")
public class McpController {

    @Autowired
    private McpService mcpService;

    @PostMapping
    public ResponseEntity<?> query(@RequestBody QueryRequest request) {
        String query = request.getQuery();
        if (query == null) {
            return ResponseEntity.badRequest().body("Query cannot be null.");
        }

        switch (query) {
            case "merchant_payment_advice":
                return ResponseEntity.ok(mcpService.getAllMerchantPaymentAdvices());
            case "customer_profile":
                return ResponseEntity.ok(mcpService.getAllCustomerProfiles());
            case "merchant_profile":
                return ResponseEntity.ok(mcpService.getAllMerchantProfiles());
            case "transaction_minute_summary":
                return ResponseEntity.ok(mcpService.getAllTransactionMinuteSummaries());
            default:
                return ResponseEntity.badRequest().body("Invalid query: " + query);
        }
    }
}
