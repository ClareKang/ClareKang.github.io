package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Getter
@Setter
@ToString
public class ClaimHistory {

    private Long claimDescriptionNo;

    private Long orderId;

    private Long claimNo;

    private String creator;

    private String createDt;

    private String jsonString;
}
