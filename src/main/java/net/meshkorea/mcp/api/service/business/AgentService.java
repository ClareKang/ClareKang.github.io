package net.meshkorea.mcp.api.service.business;

import com.vroong.lastmile.api.LastmileManagerPartnerApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chaelee on 2017. 3. 13..
 */
@Service
public class AgentService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerPartnerApi lastmileManagerPartnerApi;

    public ManagerFindAgentsRes findAgent(ManagerFindAgentsReq req) throws ApiException {
        return lastmileManagerPartnerApi.findAgentsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetAgentDetailRes getAgentDetail(ManagerGetAgentDetailReq req) throws ApiException {
        return lastmileManagerPartnerApi.getAgentDetailUsingPOST1(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUpdateAgentRes updateAgent(ManagerUpdateAgentReq req) throws ApiException {
        return lastmileManagerPartnerApi.updateAgentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

}
