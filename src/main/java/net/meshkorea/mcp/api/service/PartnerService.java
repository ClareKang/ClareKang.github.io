package net.meshkorea.mcp.api.service;

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
public class PartnerService {

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired
    LastmileManagerPartnerApi lastmileManagerPartnerApi;

    public ManagerFindPartnersRes findPartners(ManagerFindPartnersReq req) throws ApiException {
        return lastmileManagerPartnerApi.findPartnersUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetPartnerDetailRes getPartnerDetail(ManagerGetPartnerDetailReq req) throws ApiException {
        return lastmileManagerPartnerApi.getPartnerDetailUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerAddPartnerRes addPartner(ManagerAddPartnerReq req) throws ApiException {
        return lastmileManagerPartnerApi.addPartnerUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerRemovePartnerRes removePartner(ManagerRemovePartnerReq req) throws  ApiException {
        return lastmileManagerPartnerApi.removePartnerUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerUpdatePartnerRes updatepartner(ManagerUpdatePartnerReq req) throws ApiException {
        return lastmileManagerPartnerApi.updatePartnerUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerListAllPartnersRes listAllPartners() throws ApiException {
        return lastmileManagerPartnerApi.listAllPartnersUsingGET(lastmileTokenService.getAuthToken());
    }
}
