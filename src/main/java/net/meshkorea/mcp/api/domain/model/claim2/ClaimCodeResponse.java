package net.meshkorea.mcp.api.domain.model.claim2;

import lombok.Data;
import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;

import java.util.List;

public class ClaimCodeResponse {
    
    @Data
    public static class ClaimCodeList {
        private List<ClaimCode> claimCodeList;
    }

}
