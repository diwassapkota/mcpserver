package com.example.mcpserver.prompts;

import io.modelcontextprotocol.schema.McpSchema;
import io.modelcontextprotocol.sdk.server.features.McpServerFeatures;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PromptSpecs {

    @Bean
    public List<McpServerFeatures.SyncPromptSpecification> mcpPrompts() {
        var guardrail = new McpSchema.Prompt(
                "sql_guardrails",
                "System prompt for safe SQL aggregation queries.",
                List.of(
                        new McpSchema.PromptMessage("system", "You are a data analyst. Generate ONLY read-only SQL. Avoid UPDATE/DELETE/INSERT."),
                        new McpSchema.PromptMessage("system", "Prefer indexed columns; add WHERE merchant_id = ? when present; add LIMIT 1000."))
        );

        var style = new McpSchema.Prompt(
                "answer_style",
                "Friendly and concise answer style.",
                List.of(new McpSchema.PromptMessage("system", "Respond briefly. Use bullet lists when helpful."))
        );

        return List.of(
                new McpServerFeatures.SyncPromptSpecification(guardrail),
                new McpServerFeatures.SyncPromptSpecification(style)
        );
    }
}
