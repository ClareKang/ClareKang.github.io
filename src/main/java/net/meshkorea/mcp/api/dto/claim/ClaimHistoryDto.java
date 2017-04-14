package net.meshkorea.mcp.api.dto.claim;

import lombok.Data;
import net.meshkorea.mcp.api.dto.ModelMapper;
import net.meshkorea.mcp.api.entity.claim.ClaimHistory;

import java.util.Date;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Data
public class ClaimHistoryDto implements ModelMapper<ClaimHistoryDto, ClaimHistory> {

    private Long claimHistoryNo;

    private ClaimDto claimDto;

    private String creator;

    private Date createDt;

    private String jsonString;

    public ClaimHistoryDto from(ClaimHistory claimHistory) {

        if (claimHistory == null) {
            return null;
        }

        setClaimHistoryNo(claimHistory.getClaimHistoryNo());
        if (getClaimDto() == null) {
            setClaimDto(new ClaimDto().from(claimHistory.getClaim()));
        }
        setCreator(claimHistory.getCreator());
        setCreateDt(claimHistory.getCreateDt());
        setJsonString(claimHistory.getJsonString());

        return this;
    }

    public ClaimHistory to(ClaimHistory claimHistory) {

        if (claimHistory == null) {
            claimHistory = new ClaimHistory();
        }

        claimHistory.setClaimHistoryNo(getClaimHistoryNo());
        if (claimHistory.getClaim() == null && getClaimDto() != null) {
            claimHistory.setClaim(getClaimDto().to(claimHistory.getClaim()));
        }
        claimHistory.setCreator(getCreator());
        claimHistory.setCreateDt(getCreateDt());
        claimHistory.setJsonString(getJsonString());

        return claimHistory;
    }

}
