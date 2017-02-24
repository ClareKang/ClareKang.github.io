package net.meshkorea.mcp.api.entity.pricing;

import net.meshkorea.mcp.api.entity.order.OrderAddress;

import javax.persistence.*;

/**
 * Created by suyeong.chae on 2016. 10. 20..
 */
@Entity
@Table(name = "pricing_plan_policy_map")
@IdClass(PricingPlanPolicyMapId.class)
public class PricingPlanPolicyMap {

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "pricing_plan_id" )
	private PricingPlan pricingPlan;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "pricing_policy_id" )
	private PricingPolicy pricingPolicy;

	@Column(name = "priority")
	private Integer priority;

	@Id
	@Enumerated(value = EnumType.STRING)
	@Column(name = "origin_region_type")
	private RegionType originRegionType;

	@Column(name = "origin_region")
	private String originRegion;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "dest_region_type")
	private RegionType destRegionType;

	@Column(name = "dest_region")
	private String destRegion;

	public PricingPlan getPricingPlan() {
		return pricingPlan;
	}

	public void setPricingPlan(PricingPlan pricingPlan) {
		this.pricingPlan = pricingPlan;
	}

	public PricingPolicy getPricingPolicy() {
		return pricingPolicy;
	}

	public void setPricingPolicy(PricingPolicy pricingPolicy) {
		this.pricingPolicy = pricingPolicy;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public RegionType getOriginRegionType() {
		return originRegionType;
	}

	public void setOriginRegionType(RegionType originRegionType) {
		this.originRegionType = originRegionType;
	}

	public String getOriginRegion() {
		return originRegion;
	}

	public void setOriginRegion(String originRegion) {
		this.originRegion = originRegion;
	}

	public RegionType getDestRegionType() {
		return destRegionType;
	}

	public void setDestRegionType(RegionType destRegionType) {
		this.destRegionType = destRegionType;
	}

	public String getDestRegion() {
		return destRegion;
	}

	public void setDestRegion(String destRegion) {
		this.destRegion = destRegion;
	}

	public boolean isApplicable(OrderAddress origin, OrderAddress dest) {
		if(originRegion == null && destRegion == null) {
			// 출/도착지 모두 설정 하지 않은 경우 PricingPolicy 에서 결정
			return pricingPolicy.isApplicable(origin, dest);
		} else if(destRegion == null) {
			// 도착지가 없는 경우 출발지만 확인
			return matches(origin, originRegionType, originRegion);
		} else if(originRegion == null) {
			// 출발지가 없는 경우 도착지만 확인
			return matches(dest, destRegionType, destRegion);
		} else {
			// 둘 다 있는 경우 둘 다 확인
			return (matches(origin, originRegionType, originRegion) && matches(dest, destRegionType, destRegion));
		}
	}

	public boolean matches(OrderAddress address, RegionType regionType, String region) {
		String[] regionArr	= region.split("\\|");
		String[] addressArr	= new String[] {address.getCityDo(), address.getGuGun(), address.getEupMyunDong(), address.getRi()};

		boolean match = (regionArr.length == regionType.getDepth() + 1);
		for (int i = 0; match && i < regionArr.length; i++) {
			match &= regionArr[i].equals(addressArr[i]);
		}

		return match;
	}
}
