package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by sungjae.hong on 2017. 6. 13..
 */
@Getter
@Setter
@ToString
public class ClaimOrderRelationDto {
    private Long orderId;
    private Long claimNo;
    private Long claimOrderId;
    private String orderNumber;
    private String claimOrderNumber;
}
