package com.example.mcpserver.provider;

import com.example.mcpserver.service.McpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.mcp.server.McpServerFeatures.SyncResourceSpecification;
import org.springframework.ai.mcp.meta.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerProfileResourceProvider {

    private final McpService mcpService;
    private final ObjectMapper objectMapper;

    public CustomerProfileResourceProvider(McpService mcpService, ObjectMapper objectMapper) {
        this.mcpService = mcpService;
        this.objectMapper = objectMapper;
    }

    @Bean
    public List<SyncResourceSpecification> customerProfileResource() {
        var resource = new McpSchema.Resource("customer_profile", "Provides customer profile information.", null);
        var resourceSpecification = new SyncResourceSpecification(resource, (exchange, request) -> {
            try {
                var profiles = mcpService.getAllCustomerProfiles();
                String jsonContent = objectMapper.writeValueAsString(profiles);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), "application/json", jsonContent)));
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate customer profile.", e);
            }
        });
        return List.of(resourceSpecification);
    }
}
