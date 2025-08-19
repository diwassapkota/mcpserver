package com.example.mcpserver.tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class HealthTools {

    @Tool(name = "ping", description = "Simple health check. Returns 'pong'.")
    public String ping() {
        return "pong";
    }
}
