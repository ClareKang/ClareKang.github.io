package net.meshkorea.mcp.api.domain.model.claim2;

import lombok.Data;
import net.meshkorea.mcp.api.domain.entity.claim2.Claim2Code;

import java.util.List;

public class Claim2CodeResponse {
    
    @Data
    public static class Claim2CodeList {
        private List<Claim2Code> claim2CodeList;
    }

}
