package net.meshkorea.mcp.api.controller.fee;

import com.vroong.admin.api.client.model.*;
import net.meshkorea.mcp.api.service.fee.DistributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yjhan on 2017. 2. 14..
 */
@RestController
@RequestMapping(value = "/v1/lastmile/fee")
public class DistributionController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DistributionService distributionService;


    @RequestMapping(value = "/pricingPlans", method = RequestMethod.GET)
    public AdminPricingPlanListRes findPricingPlans(String name) throws Exception {
        AdminPricingPlanListRes res = distributionService.findPricingPlans(name);
        return res;
    }

    @RequestMapping(value = "/pricingPlans", method = RequestMethod.POST)
    public AddPricingPlanRes addPricingPlans(@RequestBody AddPricingPlanReq req) throws Exception {
        return distributionService.addPricingPlans(req);
        //return new AddPricingPlanRes();
    }

    @RequestMapping(value = "/pricingPlans/{id}", method = RequestMethod.GET)
    public AdminPricingPlanRes findPricingPlanById(@PathVariable int id) throws Exception {
        return distributionService.findPricingPlanById(id);
    }

    @RequestMapping(value = "/pricingPlans/{id}", method = RequestMethod.PUT)
    public UpdatePricingPlanRes updatePricingPlan(@RequestBody UpdatePricingPlanReq req, @PathVariable int id) throws Exception {
        return distributionService.updatePricingPlan(req, id);
        //return new UpdatePricingPlanRes();
    }

    @RequestMapping(value = "/pricingPolicies", method = RequestMethod.GET)
    public AdminPricingPolicyListRes findPricingPolicies(String name) throws Exception {
        return distributionService.findPricingPolicies(name);
        //return new AdminPricingPolicyListRes();
    }

    @RequestMapping(value = "/pricingPolicies", method = RequestMethod.POST)
    public AddPricingPolicyRes addPricingPolicy(@RequestBody AddPricingPolicyReq req) throws Exception {
        return distributionService.addPricingPolicy(req);
        //return new AddPricingPolicyRes();
    }

    @RequestMapping(value = "/pricingPolicies/{id}", method = RequestMethod.GET)
    public AdminPricingPolicyRes findPricingPolicyById(@PathVariable int id) throws Exception {
        return distributionService.findPricingPolicyById(id);
        //return new AdminPricingPolicyRes();
    }

    @RequestMapping(value = "/pricingPolicies/{id}", method = RequestMethod.PUT)
    public UpdatePricingPolicyRes updatePricingPolicy(@RequestBody UpdatePricingPolicyReq req, @PathVariable int id) throws Exception {
        return distributionService.updatePricingPolicy(req, id);
        //return new UpdatePricingPolicyRes();
    }

}
