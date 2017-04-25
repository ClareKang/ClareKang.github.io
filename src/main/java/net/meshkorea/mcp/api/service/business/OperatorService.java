package net.meshkorea.mcp.api.service.business;

import com.vroong.lastmile.api.LastmileManagerPartnerApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import com.vroong.lastmile.service.auth.LastmileTokenService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chaelee on 2017. 3. 13..
 */
@Service
public class OperatorService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerPartnerApi lastmileManagerPartnerApi;

    public ManagerFindOperatorsRes findOperators(ManagerFindOperatorsReq req) throws ApiException {
        return lastmileManagerPartnerApi.findOperatorsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetOperatorDetailRes getOperatorDetail(ManagerGetOperatorDetailReq req) throws ApiException {
        return lastmileManagerPartnerApi.getOperatorDetailUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerAddOperatorRes addOperator(ManagerAddOperatorReq req) throws ApiException {
        return lastmileManagerPartnerApi.addOperatorUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerRemoveOperatorRes removeOperator(ManagerRemoveOperatorReq req) throws ApiException {
        return lastmileManagerPartnerApi.removeOperatorUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUpdateOperatorRes updateOperator(ManagerUpdateOperatorReq req) throws ApiException {
        return lastmileManagerPartnerApi.updateOperatorUsingPOST(lastmileTokenService.getAuthToken(), req);
    }
}
