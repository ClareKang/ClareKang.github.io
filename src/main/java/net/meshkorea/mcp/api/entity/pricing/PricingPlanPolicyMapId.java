package net.meshkorea.mcp.api.entity.pricing;

import java.io.Serializable;

/**
 * Created by suyeong.chae on 2016. 10. 20..
 */
public class PricingPlanPolicyMapId implements Serializable {
	private Long pricingPlan;
	private Long pricingPolicy;
	private Integer priority;

	public Long getPricingPlan() {
		return pricingPlan;
	}

	public void setPricingPlan(Long pricingPlan) {
		this.pricingPlan = pricingPlan;
	}

	public Long getPricingPolicy() {
		return pricingPolicy;
	}

	public void setPricingPolicy(Long pricingPolicy) {
		this.pricingPolicy = pricingPolicy;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PricingPlanPolicyMapId that = (PricingPlanPolicyMapId) o;

		if (pricingPlan != null ? !pricingPlan.equals(that.pricingPlan) : that.pricingPlan != null) return false;
		if (pricingPolicy != null ? !pricingPolicy.equals(that.pricingPolicy) : that.pricingPolicy != null)
			return false;
		return priority != null ? priority.equals(that.priority) : that.priority == null;

	}

	@Override
	public int hashCode() {
		int result = pricingPlan != null ? pricingPlan.hashCode() : 0;
		result = 31 * result + (pricingPolicy != null ? pricingPolicy.hashCode() : 0);
		result = 31 * result + (priority != null ? priority.hashCode() : 0);
		return result;
	}
}
