package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.claim.ClaimHistory;

import java.util.Date;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Getter
@Setter
public class ClaimHistoryDto {

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
        if (getClaimDto() == null && claimHistory.getClaim() != null) {
            setClaimDto(new ClaimDto().from(claimHistory.getClaim()));
        }
        setCreator(claimHistory.getCreator());
        setCreateDt(claimHistory.getCreateDt());
        setJsonString(claimHistory.getJsonString());

        return this;
    }

    public ClaimHistory to(ClaimHistory claimHistory) {

        // 파라미터로 전달된 객체 유효성 확인
        if (claimHistory == null) {
            claimHistory = new ClaimHistory();
        }

        claimHistory.setClaimHistoryNo(getClaimHistoryNo());
        if (claimHistory.getClaim() == null && getClaimDto() != null) {
            claimHistory.setClaim(getClaimDto().to(null));
        }
        claimHistory.setCreator(getCreator());
        claimHistory.setCreateDt(getCreateDt());
        claimHistory.setJsonString(getJsonString());

        return claimHistory;
    }

}
