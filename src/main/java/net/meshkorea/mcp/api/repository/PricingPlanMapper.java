package net.meshkorea.mcp.api.repository;

import net.meshkorea.mcp.api.config.data.VroongDbConfig;

import java.util.Map;

@VroongDbConfig.VroongData
public interface PricingPlanMapper {

	Map<String, Object> getPricingPlan(Map params);

	Map<String, Object> getPricingPlanAndDeliveryClass(Map params);

}
