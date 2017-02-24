package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.common.Money;
import net.meshkorea.mcp.api.entity.execption.PricingNotApplicableException;
import net.meshkorea.mcp.api.entity.order.OrderAddress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jihunlee on 2016. 2. 22..
 */
@Entity
@Table( name ="region_pricing_policy" )
@DiscriminatorValue(value = "REGION")
public class RegionPricingPolicy extends PricingPolicy {

	private static final String REGION_GROUP_DELIMITER = "|";

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "region_pricing_plan_group_map",
		joinColumns         = @JoinColumn(name = "region_pricing_policy_id"	, referencedColumnName = "id"),
		inverseJoinColumns  = @JoinColumn(name = "pricing_region_group_id"	, referencedColumnName = "id")
	)
    private Set<PricingRegionGroup> pricingRegionGroups;

    @NotNull
    @AttributeOverrides({
            @AttributeOverride(name = "amount",     column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency",   column = @Column(name = "price_currency"))
    })
    private Money price;

    @Column( name = "region_type" )
    private RegionType regionType = RegionType.EUP_MYEON_DONG;

    @Column( name = "adapt_to_same_group" )
    private Boolean adaptToSameGroup = false;

    @Transient
    private Map<String, PricingRegionGroup> map;

	protected RegionPricingPolicy() {
	}

    public RegionPricingPolicy(Money price, RegionType regionType, boolean adaptToSameGroup) {
        this.price = price;
        this.regionType = regionType;
        this.adaptToSameGroup = adaptToSameGroup;
    }

    @PostLoad
    public void init() {
        map = new HashMap<>();
        pricingRegionGroups.forEach(x -> x.getPricingRegions().forEach(y -> map.put(y.getName(), x)));
    }

	public Set<PricingRegionGroup> getPricingRegionGroups() {
		return pricingRegionGroups;
	}

	public void setPricingRegionGroups(Set<PricingRegionGroup> pricingRegionGroups) {
		this.pricingRegionGroups = pricingRegionGroups;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public RegionType getRegionType() {
		return regionType;
	}

	public void setRegionType(RegionType regionType) {
		this.regionType = regionType;
	}

	public Boolean getAdaptToSameGroup() {
		return adaptToSameGroup;
	}

	public void setAdaptToSameGroup(Boolean adaptToSameGroup) {
		this.adaptToSameGroup = adaptToSameGroup;
	}

	@Override
	public boolean isApplicable(OrderAddress origin, OrderAddress dest) {
        switch (regionType) {
            case CITY_DO:
                return isCityDoApplicable(origin, dest);
            case GU_GUN:
                return isGuGunApplicable(origin, dest);
            case EUP_MYEON_DONG:
                return isEupMyeonDongApplicable(origin, dest);
            case RI:
                return isEupMyeonDongRiApplicable(origin, dest);
        }

        return false;
    }

    @Override
    public Money calculatePrice(OrderAddress origin, OrderAddress dest) throws PricingNotApplicableException {
        if (isApplicable(origin, dest)) {
            return price;
        }

        throw new PricingNotApplicableException(this, origin, dest);
    }

    private boolean isCityDoApplicable(
            OrderAddress origin,
            OrderAddress dest) {
        String originRegion = origin.getCityDo();
        String destRegion = dest.getCityDo();

        return areRegionsSame(originRegion, destRegion);
    }

    private boolean isGuGunApplicable(
            OrderAddress origin,
            OrderAddress dest) {
        String originRegion = origin.getCityDo() + REGION_GROUP_DELIMITER + origin.getGuGun();
        String destRegion = dest.getCityDo() + REGION_GROUP_DELIMITER + dest.getGuGun();

        return areRegionsSame(originRegion, destRegion);
    }

    private boolean isEupMyeonDongApplicable(
            OrderAddress origin,
            OrderAddress dest) {
        String originRegion = origin.getCityDo() + REGION_GROUP_DELIMITER + origin.getGuGun() + REGION_GROUP_DELIMITER + origin.getEupMyunDong();
        String destRegion = dest.getCityDo() + REGION_GROUP_DELIMITER + dest.getGuGun() + REGION_GROUP_DELIMITER + dest.getEupMyunDong();

        return areRegionsSame(originRegion, destRegion);
    }

    private boolean isEupMyeonDongRiApplicable(
            OrderAddress origin,
            OrderAddress dest) {
        String originRegion = origin.getCityDo() + REGION_GROUP_DELIMITER + origin.getGuGun() + REGION_GROUP_DELIMITER + origin.getEupMyunDong() + REGION_GROUP_DELIMITER + origin.getRi();
        String destRegion = dest.getCityDo() + REGION_GROUP_DELIMITER + dest.getGuGun() + REGION_GROUP_DELIMITER + dest.getEupMyunDong() + REGION_GROUP_DELIMITER + dest.getRi();

        return areRegionsSame(originRegion, destRegion);
    }

    private boolean areRegionsSame(
            String originRegion,
            String destRegion) {
        PricingRegionGroup originGroup = map.get(originRegion);
        PricingRegionGroup destGroup = map.get(destRegion);

        if (adaptToSameGroup) {
            return originGroup != null && destGroup != null;
        } else {
            return originGroup != null && destGroup != null && originGroup.getId() != destGroup.getId();
        }
    }

}

