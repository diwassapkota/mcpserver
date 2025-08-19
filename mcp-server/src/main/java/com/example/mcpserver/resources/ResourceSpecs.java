package com.example.mcpserver.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.schema.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.util.List;

import io.modelcontextprotocol.sdk.server.transport.ServerExchange.McpSyncServerExchange;
import io.modelcontextprotocol.sdk.server.features.McpServerFeatures;

@Configuration
public class ResourceSpecs {

    private static String readResource(String cp) {
        try {
            var res = new ClassPathResource(cp);
            return new String(res.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Example dynamic JSON resource exposing basic system info.
     */
    @Bean
    public List<McpServerFeatures.SyncResourceSpecification> mcpResources(ObjectMapper om) {
        var sys = new McpSchema.Resource(
                "res://system/info",
                "application/json",
                "Basic JVM & app info",
                List.of(),
                null
        );

        var sysSpec = new McpServerFeatures.SyncResourceSpecification(sys, (McpSyncServerExchange exchange, McpSchema.ReadResourceRequest req) -> {
            try {
                var info = java.util.Map.of(
                        "java_version", System.getProperty("java.version"),
                        "app", "fonepay-mcp-server",
                        "uptime_ms", java.lang.management.ManagementFactory.getRuntimeMXBean().getUptime()
                );
                String json = om.writeValueAsString(info);
                return new McpSchema.ReadResourceResult(List.of(
                        new McpSchema.TextResourceContents(req.uri(), "application/json", json)
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Static markdown resource loaded from classpath
        var schema = new McpSchema.Resource(
                "res://docs/merchant_schema",
                "text/markdown",
                "ERD & table notes for merchants",
                List.of(),
                null
        );
        var schemaSpec = new McpServerFeatures.SyncResourceSpecification(schema, (exchange, req) ->
                new McpSchema.ReadResourceResult(List.of(
                        new McpSchema.TextResourceContents(req.uri(), "text/markdown", readResource("docs/merchant_schema.md"))
                ))
        );

        return List.of(sysSpec, schemaSpec);
    }
}
