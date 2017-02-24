package net.meshkorea.mcp.api.service;

import net.meshkorea.mcp.api.repository.PricingPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjhan on 2017. 2. 8..
 */
@Service
public class MapperTestService {

    @Autowired
    PricingPlanMapper pricingPlanMapper;

    @Transactional
    public Map<String, Object> getPricingPlanAndDeliveryClass(Long pricingPlanId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", pricingPlanId);
        return pricingPlanMapper.getPricingPlanAndDeliveryClass(params);
    }

    public String getDeliveryClassNameByPricingPlan(Long pricingPlanId) {
        Map<String, Object> pricingPlanAndDeliveryClass = getPricingPlanAndDeliveryClass(pricingPlanId);
        return (String) pricingPlanAndDeliveryClass.get("classCode");
    }
}
