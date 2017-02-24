package net.meshkorea.mcp.api.service;

import net.meshkorea.mcp.api.entity.pricing.DeliveryClass;
import net.meshkorea.mcp.api.repository.PricingPlanRepository;
import net.meshkorea.mcp.api.entity.pricing.PricingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by yjhan on 2017. 2. 6..
 */
@Service
public class JpaTestService {

    @Autowired
    private PricingPlanRepository pricingPlanRepository;

    @Transactional
    public String getDeliveryClassCode(Long deliveryClassId) {
        PricingPlan pricingPlan = pricingPlanRepository.getOne(deliveryClassId);
        DeliveryClass deliveryClass = pricingPlan.getDeliveryClass();
        return deliveryClass.getClassCode();
    }

}
