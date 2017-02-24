package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.common.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by jihunlee on 2016. 2. 23..
 */
@Embeddable
public class DistancePricingRange {

    @Column( name = "dist_from" )
    private double distFrom;

    @Column( name = "dist_to" )
    private double distTo;

    @Column( name = "unit_dist" )
    private double unitDist;

    @Embedded
    private Money baseFee;

    @Embedded
    private Money pricePerUnit;

    public DistancePricingRange(double distFrom, double distTo, double unitDist, Money baseFee, Money pricePerUnit) {
        this.distFrom = distFrom;
        this.distTo = distTo;
        this.unitDist = unitDist;
        this.baseFee = baseFee;
        this.pricePerUnit = pricePerUnit;
    }

    public DistancePricingRange(double distFrom, double distTo, double unitDist, double baseFee,
                                double pricePerUnit, Currency currency) {
        this.distFrom = distFrom;
        this.distTo = distTo;
        this.unitDist = unitDist;
        this.baseFee = new Money(new BigDecimal(baseFee), currency);
        this.pricePerUnit = new Money(new BigDecimal(pricePerUnit), currency);
    }

    protected DistancePricingRange() {
    }

    public double getDistFrom() {
        return distFrom;
    }

    protected void setDistFrom(double from) {
        this.distFrom = from;
    }

    public double getDistTo() {
        return distTo;
    }

    protected void setDistTo(double to) {
        this.distTo = to;
    }

    public double getUnitDist() {
        return unitDist;
    }

    protected void setUnitDist(double unitDist) {
        this.unitDist = unitDist;
    }

    public Money getBaseFee() {
        return baseFee;
    }

    protected void setBaseFee(Money baseFee) {
        this.baseFee = baseFee;
    }

    public Money getPricePerUnit() {
        return pricePerUnit;
    }

    protected void setPricePerUnit(Money pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
