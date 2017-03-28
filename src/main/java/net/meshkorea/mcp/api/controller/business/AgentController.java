package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
public class AgentController {

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/findAgents", method = RequestMethod.POST)
    public @ResponseBody
    ManagerFindAgentsRes findAgent(ManagerFindAgentsReq req) throws ApiException {
        return agentService.findAgent(req);
    }

    @RequestMapping(value = "/getAgentDetail", method = RequestMethod.POST)
    public @ResponseBody
    ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return agentService.getAgentDetail(req);
    }

    @RequestMapping(value = "/updateAgent", method = RequestMethod.POST)
    public @ResponseBody
    ManagerUpdateAgentRes updateAgent(ManagerUpdateAgentReq req) throws ApiException {
        return agentService.updateAgent(req);
    }
}
