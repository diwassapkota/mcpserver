package com.example.mcpserver.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfileId implements Serializable {
    private String issuerName;
    private String initiator;
}
