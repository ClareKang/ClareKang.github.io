package net.meshkorea.mcp.api.service.common;

import com.vroong.lastmile.api.LastmileManagerPartnerApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerCheckUsernameReq;
import com.vroong.lastmile.api.client.model.ManagerCheckUsernameRes;
import com.vroong.lastmile.api.client.model.ManagerGetBanksRes;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jypark on 2017. 4. 6..
 */
@Service
public class LastmileCommonService {
    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerPartnerApi lastmileManagerPartnerApi;

    public ManagerGetBanksRes getBanks() throws ApiException {
        return lastmileManagerPartnerApi.getBanksUsingGET(lastmileTokenService.getAuthToken());
    }

    public ManagerCheckUsernameRes checkUsername(ManagerCheckUsernameReq req) throws ApiException {
        return lastmileManagerPartnerApi.checkUsernameUsingPOST(lastmileTokenService.getAuthToken(), req);
    }
}
