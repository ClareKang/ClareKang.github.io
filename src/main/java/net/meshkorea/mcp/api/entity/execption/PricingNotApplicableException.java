package net.meshkorea.mcp.api.entity.execption;

import net.meshkorea.mcp.api.entity.order.OrderAddress;
import net.meshkorea.mcp.api.entity.pricing.PricingPolicy;

/**
 * Created by jihunlee on 2016. 2. 22..
 */
public class PricingNotApplicableException extends Exception {
    private final PricingPolicy pricingPolicy;
    private final OrderAddress origin;
    private final OrderAddress dest;

    public PricingNotApplicableException(PricingPolicy pricingPolicy, OrderAddress origin, OrderAddress dest) {
        super();
        this.pricingPolicy = pricingPolicy;
        this.origin = origin;
        this.dest = dest;
    }

    public PricingPolicy getPricingPolicy() {
        return pricingPolicy;
    }

    public OrderAddress getOrigin() {
        return origin;
    }

    public OrderAddress getDest() {
        return dest;
    }
}
