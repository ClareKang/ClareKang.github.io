package net.meshkorea.mcp.api.entity.pricing;

import lombok.*;
import net.meshkorea.mcp.api.entity.common.Money;
import net.meshkorea.mcp.api.entity.execption.NoApplicablePricingPolicyExistException;
import net.meshkorea.mcp.api.entity.order.OrderAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
@Table(name = "pricing_plan")
public class PricingPlan {

    private static final Logger logger = LoggerFactory.getLogger(PricingPlan.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_class_id")
    private DeliveryClass deliveryClass;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pricingPlan", cascade = {CascadeType.PERSIST})
    private List<PricingPlanPolicyMap> pricingPolicyMaps;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "policy"			, column = @Column(name = "management_fee_policy"	)),
		@AttributeOverride(name = "ratio"			, column = @Column(name = "management_fee_ratio"	)),
		@AttributeOverride(name = "amount.amount"	, column = @Column(name = "management_fee_amount"	)),
		@AttributeOverride(name = "amount.currency"	, column = @Column(name = "management_fee_currency"	))
	})
	private FeeDistribution managementFeeDistribution;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "policy"			, column = @Column(name = "monitoring_fee_policy"	)),
		@AttributeOverride(name = "ratio"			, column = @Column(name = "monitoring_fee_ratio"	)),
		@AttributeOverride(name = "amount.amount"	, column = @Column(name = "monitoring_fee_amount"	)),
		@AttributeOverride(name = "amount.currency"	, column = @Column(name = "monitoring_fee_currency"	))
	})
	private FeeDistribution monitoringFeeDistribution;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "policy"			, column = @Column(name = "agent_fee_policy"		)),
		@AttributeOverride(name = "ratio"			, column = @Column(name = "agent_fee_ratio"			)),
		@AttributeOverride(name = "amount.amount"	, column = @Column(name = "agent_fee_amount"		)),
		@AttributeOverride(name = "amount.currency"	, column = @Column(name = "agent_fee_currency"		))
	})
	private FeeDistribution agentFeeDistribution;

	@Column(name = "fee_decimal_scale")
	private Integer feeDecimalScale;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "fee_rounding_mode")
	private RoundingMode feeRoundingMode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DeliveryClass getDeliveryClass() {
		return deliveryClass;
	}

	public void setDeliveryClass(DeliveryClass deliveryClass) {
		this.deliveryClass = deliveryClass;
	}

	public List<PricingPlanPolicyMap> getPricingPolicyMaps() {
		return pricingPolicyMaps;
	}

	public void setPricingPolicyMaps(List<PricingPlanPolicyMap> pricingPolicyMaps) {
		this.pricingPolicyMaps = pricingPolicyMaps;
	}

	public FeeDistribution getManagementFeeDistribution() {
		return managementFeeDistribution;
	}

	public void setManagementFeeDistribution(FeeDistribution managementFeeDistribution) {
		this.managementFeeDistribution = managementFeeDistribution;
	}

	public FeeDistribution getMonitoringFeeDistribution() {
		return monitoringFeeDistribution;
	}

	public void setMonitoringFeeDistribution(FeeDistribution monitoringFeeDistribution) {
		this.monitoringFeeDistribution = monitoringFeeDistribution;
	}

	public FeeDistribution getAgentFeeDistribution() {
		return agentFeeDistribution;
	}

	public void setAgentFeeDistribution(FeeDistribution agentFeeDistribution) {
		this.agentFeeDistribution = agentFeeDistribution;
	}

	public Integer getFeeDecimalScale() {
		return feeDecimalScale;
	}

	public void setFeeDecimalScale(Integer feeDecimalScale) {
		this.feeDecimalScale = feeDecimalScale;
	}

	public RoundingMode getFeeRoundingMode() {
		return feeRoundingMode;
	}

	public void setFeeRoundingMode(RoundingMode feeRoundingMode) {
		this.feeRoundingMode = feeRoundingMode;
	}

	public PricingPolicy searchPricingPolicy(OrderAddress origin, OrderAddress dest) throws NoApplicablePricingPolicyExistException {
		PricingPolicy firstApplicable = null;
		if(pricingPolicyMaps != null) {
			for (PricingPlanPolicyMap pricingPolicyMap : pricingPolicyMaps) {
				if (pricingPolicyMap.isApplicable(origin, dest)) {
					firstApplicable = pricingPolicyMap.getPricingPolicy();
					break;
				}
			}
		}

		if (firstApplicable == null) {
			throw new NoApplicablePricingPolicyExistException(deliveryClass);
		}

		return firstApplicable;
	}

	public Money getManagementFee(Money baseCharge) {
		return getFee(managementFeeDistribution, baseCharge);
	}

	public Money getMonitoringFee(Money baseCharge) {
		return getFee(monitoringFeeDistribution, baseCharge);
	}

	public Money getAgentFee(Money baseCharge) {
		return getFee(agentFeeDistribution, baseCharge);
	}

	public Money getFee(FeeDistribution feeDistribution, Money baseCharge) {
		List<FeeDistribution> fixedFeeDistribution = null;
		List<FeeDistribution> ratioFeeDistribution = null;

		Money amount = null;
		switch (feeDistribution.getPolicy()) {
			case RATIO:
				fixedFeeDistribution = getFeeDistributions(FeeDistributionPolicy.FIXED);
				amount = baseCharge;
				if(fixedFeeDistribution != null) {
					for (FeeDistribution distribution : fixedFeeDistribution) {
						amount = amount.subtract(getFee(distribution, baseCharge));
					}
				}

				return amount.multiply(feeDistribution.getRatio()).setScale(this.getFeeDecimalScale(), this.getFeeRoundingMode());
			case FIXED:
				return feeDistribution.getAmount();
			case REMAIN:
				fixedFeeDistribution = getFeeDistributions(FeeDistributionPolicy.FIXED);
				amount = baseCharge;
				if(fixedFeeDistribution != null) {
					for (FeeDistribution distribution : fixedFeeDistribution) {
						amount = amount.subtract(getFee(distribution, baseCharge));
					}
				}

				ratioFeeDistribution = getFeeDistributions(FeeDistributionPolicy.RATIO);
				if(ratioFeeDistribution != null) {
					for (FeeDistribution distribution : ratioFeeDistribution) {
						amount = amount.subtract(getFee(distribution, baseCharge));
					}
				}

				return amount;
		}
		return null;
	}

	public List<FeeDistribution> getFeeDistributions(FeeDistributionPolicy feeDistributionPolicy) {
		FeeDistribution[] feeDistributions = new FeeDistribution[] {managementFeeDistribution, monitoringFeeDistribution, agentFeeDistribution};

		List<FeeDistribution> result = null;
		for (FeeDistribution feeDistribution : feeDistributions) {
			if(feeDistribution.getPolicy() == feeDistributionPolicy) {
				if(result == null) {
					result = new ArrayList<>();
				}
				result.add(feeDistribution);
			}
		}

		return result;
	}
}
