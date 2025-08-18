package com.example.mcpserver.provider;

import com.example.mcpserver.service.McpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.mcp.server.McpServerFeatures.SyncResourceSpecification;
import org.springframework.ai.mcp.meta.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MerchantProfileResourceProvider {

    private final McpService mcpService;
    private final ObjectMapper objectMapper;

    public MerchantProfileResourceProvider(McpService mcpService, ObjectMapper objectMapper) {
        this.mcpService = mcpService;
        this.objectMapper = objectMapper;
    }

    @Bean
    public List<SyncResourceSpecification> merchantProfileResource() {
        var resource = new McpSchema.Resource("merchant_profile", "Provides merchant profile information.", null);
        var resourceSpecification = new SyncResourceSpecification(resource, (exchange, request) -> {
            try {
                var profiles = mcpService.getAllMerchantProfiles();
                String jsonContent = objectMapper.writeValueAsString(profiles);
                return new McpSchema.ReadResourceResult(
                        List.of(new McpSchema.TextResourceContents(request.uri(), "application/json", jsonContent)));
            } catch (Exception e) {
                throw new RuntimeException("Failed to generate merchant profile.", e);
            }
        });
        return List.of(resourceSpecification);
    }
}
