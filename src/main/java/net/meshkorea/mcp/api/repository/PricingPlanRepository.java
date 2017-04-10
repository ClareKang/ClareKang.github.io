package net.meshkorea.mcp.api.repository;

import net.meshkorea.mcp.api.config.data.VroongDbConfig;
import net.meshkorea.mcp.api.entity.pricing.PricingPlan;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by yjhan on 2017. 2. 3..
 */
@VroongDbConfig.VroongData
public interface PricingPlanRepository extends JpaSpecificationRepository<PricingPlan, Long> {
}
