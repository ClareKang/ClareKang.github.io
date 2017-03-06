package net.meshkorea.mcp.api.service;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.api.ManagerpartnercontrollerimplApi;
import com.vroong.lastmile.api.client.api.SystemstatuscontrollerApi;
import com.vroong.lastmile.api.client.model.ManagerGetBanksRes;
import com.vroong.lastmile.api.client.model.SystemStatusRes;
import com.vroong.lastmile.api.service.LastmileTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Service
public class VroongClientTestService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    private static String BASE_PATH = "https://demo.api-v2.vroong.com";

    public String getSystemStatus() throws ApiException {
        SystemstatuscontrollerApi api = new SystemstatuscontrollerApi();
        api.getApiClient().setBasePath(BASE_PATH);
        SystemStatusRes systemStatusRes = api.statusUsingGET(lastmileTokenService.getAuthorizationToken());
        System.out.println(systemStatusRes.toString());
        return systemStatusRes.toString();
    }

    public ManagerGetBanksRes getBanks() throws ApiException {
        ManagerpartnercontrollerimplApi api = new ManagerpartnercontrollerimplApi();
        api.getApiClient().setBasePath(BASE_PATH);
        return api.getBanksUsingGET(lastmileTokenService.getAuthorizationToken());
    }
}
