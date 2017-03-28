package net.meshkorea.mcp.api.controller.monitoring;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
public class LiveController {

    @RequestMapping(value = "/assignAgent", method = RequestMethod.POST)
    public @ResponseBody
    ManagerAssignAgentRes assignAgent(ManagerAssignAgentReq req) throws ApiException {
        return new ManagerAssignAgentRes();
    }

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    public @ResponseBody
    ManagerCancelOrderRes cancelOrder(ManagerCancelOrderReq req) throws ApiException {
        return new ManagerCancelOrderRes();
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public @ResponseBody
    ManagerChangeStatusRes changeStatus(ManagerChangeStatusReq req) throws ApiException {
        return new ManagerChangeStatusRes();
    }

    
}
