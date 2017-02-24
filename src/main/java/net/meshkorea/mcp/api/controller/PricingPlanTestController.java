package net.meshkorea.mcp.api.controller;

import net.meshkorea.mcp.api.service.JpaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yjhan on 2017. 2. 14..
 */
@RestController
public class PricingPlanTestController {

    @Autowired
    JpaTestService jpaTestService;

    @RequestMapping(value = "/pricingPlan/{deliveryClassId}", method = RequestMethod.GET)
    public String getPricingPlan(@PathVariable Long deliveryClassId) {
        return jpaTestService.getDeliveryClassCode(deliveryClassId);
        // return "VROONG_DEFAULT";
    }
}
