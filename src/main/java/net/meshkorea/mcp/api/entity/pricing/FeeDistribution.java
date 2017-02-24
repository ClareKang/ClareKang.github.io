package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.common.Money;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Created by suyeong.chae on 2016. 10. 19..
 */
@Embeddable
public class FeeDistribution {

	@Enumerated(value = EnumType.STRING)
	private FeeDistributionPolicy policy;

	private BigDecimal ratio;

	private Money amount;

	public FeeDistributionPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(FeeDistributionPolicy policy) {
		this.policy = policy;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

}
