package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
@ToString
public class CreateClaimRequest {

    private Claim claimInfo;

    private Long orderId;

    private Long claimNo;

    private Long claimOrderId;

    private String orderNumber;

    private String claimOrderNumber;

    private String creator;

    private String updater;

    private String createDt;

    private String updateDt;

}
