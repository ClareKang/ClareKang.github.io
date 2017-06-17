package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.business.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/agent")
public class AgentController {

    @Autowired
    AgentService agentService;

    @PostMapping("/findAgents")
    public ManagerFindAgentsRes findAgent(@RequestBody ManagerFindAgentsReq req) throws ApiException {
        return agentService.findAgent(req);
    }

    @PostMapping("/getAgentDetail")
    public ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return agentService.getAgentDetail(req);
    }

    @PostMapping("/updateAgent")
    public ManagerUpdateAgentRes updateAgent(@RequestBody ManagerUpdateAgentReq req) throws ApiException {
        return agentService.updateAgent(req);
    }

    @PostMapping("/addAgent")
    public ManagerAddAgentRes addAgent(@RequestBody ManagerAddAgentReq req) throws ApiException {
        return agentService.addAgent(req);
    }

    @PostMapping("/removeAgent")
    public ManagerRemoveAgentRes removeAgent(ManagerRemoveAgentReq req) throws ApiException {
        return agentService.removeAgent(req);
    }
}
