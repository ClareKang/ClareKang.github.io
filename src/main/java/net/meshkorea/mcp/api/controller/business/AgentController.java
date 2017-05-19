package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.business.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/agent")
public class AgentController {

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/findAgents", method = RequestMethod.POST)
    public ManagerFindAgentsRes findAgent(@RequestBody ManagerFindAgentsReq req) throws ApiException {
        return agentService.findAgent(req);
    }

    @RequestMapping(value = "/getAgentDetail", method = RequestMethod.POST)
    public ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return agentService.getAgentDetail(req);
    }

    @RequestMapping(value = "/updateAgent", method = RequestMethod.POST)
    public ManagerUpdateAgentRes updateAgent(@RequestBody ManagerUpdateAgentReq req) throws ApiException {
        return agentService.updateAgent(req);
    }

    @RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    public ManagerAddAgentRes addAgent(@RequestBody ManagerAddAgentReq req) throws ApiException {
        return agentService.addAgent(req);
    }

    @RequestMapping(value = "/removeAgent", method = RequestMethod.POST)
    public ManagerRemoveAgentRes removeAgent(ManagerRemoveAgentReq req) throws ApiException {
        return agentService.removeAgent(req);
    }
}
