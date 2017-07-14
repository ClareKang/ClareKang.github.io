package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
public class ClaimAdjustment {

    private Long claimAdjustmentNo;

    private Long orderId;

    private Long claimNo;

    private String adjustmentTypeCode;

    private Long adjustmentValue;

    private String deliveryFeeTypeCode;

    private Long deliveryFeeValue;

    private String cancelFeeTypeCode;

    private Long cancelFeeValue;

    private String creator;

    private String createDt;

    private String updater;

    private String updateDt;
}
