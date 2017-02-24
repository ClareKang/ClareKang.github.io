package net.meshkorea.mcp.api.entity.execption;

import net.meshkorea.mcp.api.entity.pricing.DeliveryClass;

/**
 * Created by jihunlee on 2016. 2. 25..
 */
public class NoApplicablePricingPolicyExistException extends Exception {
    private final DeliveryClass deliveryClass;

    private String deliveryClassName;

    public NoApplicablePricingPolicyExistException(String deliveryClassName) {
        super(deliveryClassName);
        this.deliveryClass = null;
        this.deliveryClassName = deliveryClassName;
    }

    public NoApplicablePricingPolicyExistException(DeliveryClass deliveryClass) {
        super();
        this.deliveryClass = deliveryClass;
    }

    public NoApplicablePricingPolicyExistException(DeliveryClass deliveryClass, String message) {
        super(message);
        this.deliveryClass = deliveryClass;
    }

    public NoApplicablePricingPolicyExistException(DeliveryClass deliveryClass, String message, Throwable throwable) {
        super(message, throwable);
        this.deliveryClass = deliveryClass;
    }
}
