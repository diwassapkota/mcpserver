package com.example.mcpserver.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.mcpserver.tools.HealthTools;
import com.example.mcpserver.tools.MathTools;
import com.example.mcpserver.tools.MerchantTools;

@Configuration
public class McpConfig {

    /**
     * Register all @Tool-bearing beans as MCP tools.
     */
    @Bean
    public ToolCallbackProvider toolCallbacks(HealthTools health,
                                              MathTools math,
                                              MerchantTools merchant) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(health, math, merchant)
                .build();
    }
}
