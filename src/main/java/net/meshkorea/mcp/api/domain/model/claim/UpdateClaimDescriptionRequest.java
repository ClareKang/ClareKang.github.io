package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;


/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
public class UpdateClaimDescriptionRequest {

    private Long claimDescriptionNo;

    private Long orderId;

    private Long claimNo;

    private String description;

    private String creator;

    private String createDt;
}
