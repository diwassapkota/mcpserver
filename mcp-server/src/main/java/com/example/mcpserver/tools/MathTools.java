package com.example.mcpserver.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class MathTools {

    @Tool(name = "sum", description = "Add two numbers and return the total.")
    public long sum(
            @ToolParam(description = "First number") long a,
            @ToolParam(description = "Second number") long b
    ) {
        return a + b;
    }
}
