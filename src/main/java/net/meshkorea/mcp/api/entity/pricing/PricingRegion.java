package net.meshkorea.mcp.api.entity.pricing;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jihunlee on 2016. 2. 22..
 */
@Embeddable
public class PricingRegion {

	@Column(name="pricing_regions_name")
    private String name;

    public PricingRegion(String name) {
        this.name = name;
    }

    protected PricingRegion() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
