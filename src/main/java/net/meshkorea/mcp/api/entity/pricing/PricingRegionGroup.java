package net.meshkorea.mcp.api.entity.pricing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 2. 22..
 */
@Entity
@Table( name = "pricing_region_group" )
public class PricingRegionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name="pricing_region_group_regions", joinColumns=@JoinColumn(name="pricing_region_group_id"))
    @Column(name="pricing_regions_name")
    private Set<PricingRegion> pricingRegions = new HashSet<>();

    public PricingRegionGroup(String name) {
        this.name = name;
    }

    protected PricingRegionGroup() {

    }

    public Long getId() {
        return id;
    }

    public Set<PricingRegion> getPricingRegions() {
        return pricingRegions;
    }

    public void setPricingRegions(Set<PricingRegion> pricingRegions) {
        this.pricingRegions = pricingRegions;
    }
}
