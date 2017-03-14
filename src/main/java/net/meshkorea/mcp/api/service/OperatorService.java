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
public class OperatorService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    private static String BASE_PATH = "https://demo.api-v2.vroong.com";
    private ManagerpartnercontrollerimplApi api;

    public OperatorService() {
        this.api = new ManagerpartnercontrollerimplApi();
        this.api.getApiClient().setBasePath(BASE_PATH);
    }

    public ManagerFindOperatorsRes findOperators(ManagerFindOperatorsReq req) throws ApiException {
        return this.api.findOperatorsUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerGetOperatorDetailRes getOperatorDetail(ManagerGetOperatorDetailReq req) throws ApiException {
        return this.api.getOperatorDetailUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerUpdateOperatorRes updateOperator(ManagerUpdateOperatorReq req) throws ApiException {
        return this.api.updateOperatorUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }
}
