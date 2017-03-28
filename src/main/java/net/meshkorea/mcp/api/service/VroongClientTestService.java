package net.meshkorea.mcp.api.service;

import com.vroong.lastmile.api.LastmileManagerPartnerApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerGetBanksRes;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Service
public class VroongClientTestService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerPartnerApi lastmileManagerPartnerApi;

    public ManagerGetBanksRes getBanks() throws ApiException {
        return lastmileManagerPartnerApi.getBanksUsingGET(lastmileTokenService.getAuthToken());
    }
}
