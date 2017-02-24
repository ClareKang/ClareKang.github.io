package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.common.LatLng;
import net.meshkorea.mcp.api.entity.common.Money;
import net.meshkorea.mcp.api.entity.execption.DifferentCurrencyException;
import net.meshkorea.mcp.api.entity.order.OrderAddress;
import net.meshkorea.mcp.api.util.DistUtils;
import net.meshkorea.mcp.api.entity.execption.PricingNotApplicableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by jihunlee on 2016. 2. 23..
 */
@Entity
@Table( name = "distance_pricing_policy")
@DiscriminatorValue(value = "DISTANCE")
public class DistancePricingPolicy extends PricingPolicy implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(DistancePricingPolicy.class);

	@Column(name = "money_decimal_scale")
	private Integer moneyDecimalScale;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "money_rounding_mode")
	private RoundingMode moneyRoundingMode;


	@ElementCollection(fetch = FetchType.EAGER)
	@OrderBy("distFrom")
	@CollectionTable(name="distance_pricing_policy_ranges", joinColumns=@JoinColumn(name="id"))
	@AttributeOverrides({
		@AttributeOverride(name = "baseFee.amount",          column = @Column(name = "base_fee_amount")),
		@AttributeOverride(name = "baseFee.currency",        column = @Column(name = "base_fee_currency")),
		@AttributeOverride(name = "distFrom",                column = @Column(name = "dist_from")),
		@AttributeOverride(name = "distTo",                  column = @Column(name = "dist_to")),
		@AttributeOverride(name = "pricePerUnit.amount",     column = @Column(name = "price_per_unit_amount")),
		@AttributeOverride(name = "pricePerUnit.currency",   column = @Column(name = "price_per_unit_currency")),
		@AttributeOverride(name = "unitDist",                column = @Column(name = "unit_dist"))
	})
	private List<DistancePricingRange> ranges;

	public Integer getMoneyDecimalScale() {
		return moneyDecimalScale;
	}

	public void setMoneyDecimalScale(Integer moneyDecimalScale) {
		this.moneyDecimalScale = moneyDecimalScale;
	}

	public RoundingMode getMoneyRoundingMode() {
		return moneyRoundingMode;
	}

	public void setMoneyRoundingMode(RoundingMode moneyRoundingMode) {
		this.moneyRoundingMode = moneyRoundingMode;
	}

	public List<DistancePricingRange> getRanges() {
		return ranges;
	}

	public void setRanges(List<DistancePricingRange> ranges) {
		this.ranges = ranges;
	}

	@Override
	public Money calculatePrice(OrderAddress origin, OrderAddress dest) throws PricingNotApplicableException {
		try {
			LatLng originLatLng = origin.getLatLng();
			LatLng destLatLng = dest.getLatLng();
			double dist = DistUtils.haversine(originLatLng.getLatitude(), originLatLng.getLongitude(), destLatLng.getLatitude(), destLatLng.getLongitude());

			DistancePricingRange rule = null;
			for (DistancePricingRange range : ranges) {
				if (dist >= range.getDistFrom() && dist < range.getDistTo()) {
					rule = range;
					break;
				}
			}

			if (rule == null) {
				throw new PricingNotApplicableException(this, origin, dest);
			}

			double additionalFeeDist = dist - rule.getDistFrom();
			int multiplyFactor = (int) (additionalFeeDist / rule.getUnitDist());

			return rule.getBaseFee()
				.add(rule.getPricePerUnit().multiply(multiplyFactor))
				.setScale(moneyDecimalScale, moneyRoundingMode);
		} catch (DifferentCurrencyException e) {
			logger.error("", e);
			return null;
		}
	}

	@Override
	public boolean isApplicable(OrderAddress origin, OrderAddress dest) {
		return true;
	}
}
