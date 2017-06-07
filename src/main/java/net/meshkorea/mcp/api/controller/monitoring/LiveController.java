package net.meshkorea.mcp.api.controller.monitoring;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.monitoring.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/live")
public class LiveController {

    @Autowired
    LiveService liveService;

    @PostMapping("/assignAgent")
    public ManagerAssignAgentRes assignAgent(@RequestBody ManagerAssignAgentReq req) throws ApiException {
        return liveService.assignAgent(req);
    }

    @PostMapping("/findOrders")
    public ManagerFindOrdersRes findOrders(@RequestBody ManagerFindOrdersReq req) throws ApiException {
        System.out.println(req);
        return liveService.findOrders(req);
    }

    @PostMapping("/getOrderDetail")
    public ManagerGetOrderDetailRes getOrderDetail(ManagerGetOrderDetailReq req) throws ApiException {
        return liveService.getOrderDetail(req);
    }

    @PostMapping("/pricingPlan")
    public ManagerPricingPlanRes pricingPlan() throws ApiException {
        return liveService.pricingPlan();
    }

    @PostMapping("/getBaseCharge")
    public ManagerGetBaseChargeRes getBaseCharge(ManagerGetBaseChargeReq req) throws ApiException {
        return liveService.getBaseCharge(req);
    }
}


