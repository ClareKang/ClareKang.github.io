package net.meshkorea.mcp.api.controller.monitoring;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import io.swagger.annotations.Api;
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

    @RequestMapping(value= "/assignAgent", method = RequestMethod.POST)
    public ManagerAssignAgentRes assignAgent(@RequestBody ManagerAssignAgentReq req) throws ApiException {
        return liveService.assignAgent(req);
    }

    @RequestMapping(value= "/findOrders", method = RequestMethod.POST)
    public ManagerFindOrdersRes findOrders(@RequestBody ManagerFindOrdersReq req) throws ApiException {
        System.out.println(req);
        return liveService.findOrders(req);
    }

    @RequestMapping(value= "/getOrderDetail", method = RequestMethod.POST)
    public ManagerGetOrderDetailRes getOrderDetail(ManagerGetOrderDetailReq req) throws ApiException {
        return liveService.getOrderDetail(req);
    }

}
