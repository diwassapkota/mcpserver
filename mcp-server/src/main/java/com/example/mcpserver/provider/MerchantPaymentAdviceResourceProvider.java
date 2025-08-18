package com.example.mcpserver.provider;

import com.example.mcpserver.service.McpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.mcp.server.McpServerFeatures;
import org.springframework.ai.mcp.server.McpServerFeatures.SyncResourceSpecification;
import org.springframework.ai.mcp.meta.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class MerchantPaymentAdviceResourceProvider {

    private final McpService mcpService;
    private final ObjectMapper objectMapper;

    public MerchantPaymentAdviceResourceProvider(McpService mcpService, ObjectMapper objectMapper) {
        this.mcpService = mcpService;
        this.objectMapper = objectMapper;
    }

    @Bean
    public List<SyncResourceSpecification> merchantPaymentAdviceResource() {
        var resource = new McpSchema.Resource("merchant_payment_advice", "Provides merchant payment advice information.", null);
        var resourceSpecification = new SyncResourceSpecification(resource, (exchange, request) -> {
            try {
                var advices = mcpService.getAllMerchantPaymentAdvices();
                String jsonContent = objectMapper.writeValueAsString(advices);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), "application/json", jsonContent)));
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate merchant payment advice.", e);
            }
        });
        return List.of(resourceSpecification);
    }
}
