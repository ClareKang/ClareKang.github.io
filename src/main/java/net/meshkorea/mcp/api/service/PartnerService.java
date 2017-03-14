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
public class PartnerService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    private static String BASE_PATH = "https://demo.api-v2.vroong.com";
    private ManagerpartnercontrollerimplApi api;

    public PartnerService() {
        this.api = new ManagerpartnercontrollerimplApi();
        this.api.getApiClient().setBasePath(BASE_PATH);
    }

    public ManagerFindPartnersRes findPartners(ManagerFindPartnersReq req) throws ApiException {
        return this.api.findPartnersUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerGetPartnerDetailRes getPartnerDetail(ManagerGetPartnerDetailReq req) throws ApiException {
        return this.api.getPartnerDetailUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerUpdatePartnerRes updatepartner(ManagerUpdatePartnerReq req) throws ApiException {
        return this.api.updatePartnerUsingPOST(lastmileTokenService.getAuthorizationToken(), req);
    }

    public ManagerListAllPartnersRes listAllPartners() throws ApiException {
        return this.api.listAllPartnersUsingGET(lastmileTokenService.getAuthorizationToken());
    }
}
