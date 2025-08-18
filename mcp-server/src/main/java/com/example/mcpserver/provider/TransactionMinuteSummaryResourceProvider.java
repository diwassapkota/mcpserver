package com.example.mcpserver.provider;

import com.example.mcpserver.service.McpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.mcp.server.McpServerFeatures.SyncResourceSpecification;
import org.springframework.ai.mcp.meta.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TransactionMinuteSummaryResourceProvider {

    private final McpService mcpService;
    private final ObjectMapper objectMapper;

    public TransactionMinuteSummaryResourceProvider(McpService mcpService, ObjectMapper objectMapper) {
        this.mcpService = mcpService;
        this.objectMapper = objectMapper;
    }

    @Bean
    public List<SyncResourceSpecification> transactionMinuteSummaryResource() {
        var resource = new McpSchema.Resource("transaction_minute_summary", "Provides transaction minute summary information.", null);
        var resourceSpecification = new SyncResourceSpecification(resource, (exchange, request) -> {
            try {
                var summaries = mcpService.getAllTransactionMinuteSummaries();
                String jsonContent = objectMapper.writeValueAsString(summaries);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), "application/json", jsonContent)));
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate transaction minute summary.", e);
            }
        });
        return List.of(resourceSpecification);
    }
}
