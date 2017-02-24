package net.meshkorea.mcp.api.dto;

import lombok.*;

@ToString
@EqualsAndHashCode(of = "id")
@Builder
@Setter
@Getter
public class PricingPlanDto {

	private Long id;

	private String name;

	private Integer deliveryClassId;

	private String managementFeePolicy;

	private Double managementFeeRatio;

	private Double managementFeeAmount;

	private String managementFeeCurrency;

	private String monitoringFeePolicy;

	private Double monitoringFeeRatio;

	private Double monitoringFeeAmount;

	private String monitoringFeeCurrency;

	private String agentFeePolicy;

	private Double agentFeeRatio;

	private Double agentFeeAmount;

	private String agentFeeCurrency;

	private Integer feeDecimalScale;

	private String feeRoundingMode;

	private String description;

}


