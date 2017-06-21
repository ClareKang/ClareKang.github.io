package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
public class ClaimAdjustmentHistory {

    private Long claimAdjustmentHistoryNo;

    private Long claimAdjustmentNo;

    private String creator;

    private String create_dt;

    private String jsonString;
}
