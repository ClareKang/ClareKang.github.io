package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.business.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    ManagerFindAgentsRes findAgent(@RequestBody ManagerFindAgentsReq req) throws ApiException {
        return agentService.findAgent(req);
    }

    @RequestMapping(value = "/getAgentDetail", method = RequestMethod.POST)
    public @ResponseBody
    ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return agentService.getAgentDetail(req);
    }

    @RequestMapping(value = "/updateAgent", method = RequestMethod.POST)
    public @ResponseBody
    ManagerUpdateAgentRes updateAgent(@RequestBody ManagerUpdateAgentReq req) throws ApiException {
        return agentService.updateAgent(req);
    }

    @RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    public @ResponseBody
    ManagerAddAgentRes addAgent(@RequestBody ManagerAddAgentReq req) throws ApiException {
        return agentService.addAgent(req);
    }

    @RequestMapping(value = "/removeAgent", method = RequestMethod.POST)
    public @ResponseBody
    ManagerRemoveAgentRes removeAgent(ManagerRemoveAgentReq req) throws ApiException {
        return agentService.removeAgent(req);
    }
}
