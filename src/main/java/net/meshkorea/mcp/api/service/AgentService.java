package net.meshkorea.mcp.api.service;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.api.ManagerpartnercontrollerimplApi;
import com.vroong.lastmile.api.client.model.*;
import com.vroong.lastmile.api.service.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chaelee on 2017. 3. 13..
 */
@Service
public class AgentService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    private static String BASE_PATH = "https://demo.api-v2.vroong.com";
    private ManagerpartnercontrollerimplApi api;

    public AgentService() {
        this.api = new ManagerpartnercontrollerimplApi();
        this.api.getApiClient().setBasePath(BASE_PATH);
    }
    public ManagerFindAgentsRes findAgent(ManagerFindAgentsReq req) throws ApiException {
        return this.api.findAgentsUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return this.api.getAgentDetailUsingPOST1(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerUpdateAgentRes updateAgent(ManagerUpdateAgentReq req) throws ApiException {
        return this.api.updateAgentUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

}
