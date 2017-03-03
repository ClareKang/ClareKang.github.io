package net.meshkorea.mcp.api.service;

import com.vroong.api.client.ApiException;
import com.vroong.api.client.api.ManagerpartnercontrollerimplApi;
import com.vroong.api.client.api.SystemstatuscontrollerApi;
import com.vroong.api.client.model.ManagerGetBanksRes;
import com.vroong.api.client.model.SystemStatusRes;
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

    public String getBanks() throws ApiException {
        ManagerpartnercontrollerimplApi api = new ManagerpartnercontrollerimplApi();
        api.getApiClient().setBasePath(BASE_PATH);
        ManagerGetBanksRes result = api.getBanksUsingGET(lastmileTokenService.getAuthorizationToken());
        System.out.println(result.toString());
        return result.toString();
    }
}
