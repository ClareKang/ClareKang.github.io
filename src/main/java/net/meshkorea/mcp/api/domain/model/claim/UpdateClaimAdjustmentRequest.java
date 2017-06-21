package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
public class UpdateClaimAdjustmentRequest {

    private Long claimAdjustmentNo;

    private Long orderId;

    private Long claimNo;

    private String adjustmentTypeCode;

    private Long adjustmentValue;

    private String deliveryFeeTypeCode;

    private Long deliveryFeeValue;

    private String cancelFeeTypeCode;

    private Long cancelFeeValue;
}
