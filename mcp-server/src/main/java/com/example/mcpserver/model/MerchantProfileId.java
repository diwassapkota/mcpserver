package com.example.mcpserver.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantProfileId implements Serializable {
    private Long acquirer;
    private Long merchant;
    private Long terminalDetails;
}
