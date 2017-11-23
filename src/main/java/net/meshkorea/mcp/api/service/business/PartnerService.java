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

    public ManagerUpdatePartnerRes updatePartner(ManagerUpdatePartnerReq req) throws ApiException {
        return lastmileManagerPartnerApi.updatePartnerUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerListAllPartnersRes listAllPartners() throws ApiException {
        return lastmileManagerPartnerApi.listAllPartnersUsingGET(lastmileTokenService.getAuthToken());
    }

    public ManagerFindAgentsWithOrderCountRes findAgentsWithOrderCount(ManagerFindAgentsWithOrderCountReq req) throws ApiException {
        return lastmileManagerPartnerApi.findAgentsWithOrderCountUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerFindClientRes findClients(ManagerFindClientsReq req) throws ApiException {
        return lastmileManagerPartnerApi.findClientsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerFindDepartmentsRes findDepartments(ManagerFindDepartmentsReq req) throws ApiException {
        return lastmileManagerPartnerApi.findDepartmentsUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerAddDepartmentRes addDepartment(ManagerAddDepartmentReq req) throws ApiException {
        return lastmileManagerPartnerApi.addDepartmentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerRemoveDepartmentRes removeDepartment(ManagerRemoveDepartmentReq req) throws ApiException {
        return lastmileManagerPartnerApi.removeDepartmentUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerAddCustomerRes addCustomer(ManagerAddCustomerReq req) throws ApiException {
        return lastmileManagerPartnerApi.addCustomerUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

    public ManagerGetWeatherExtraChargePolicyRes getWeatherExtraChargePolicy(Long partnerId) throws ApiException {
        return lastmileManagerPartnerApi.getWeatherExtraChargePolicyUsingGET(lastmileTokenService.getAuthToken(), partnerId);
    }

    public ManagerSetWeatherExtraChargePolicyRes setWeatherExtraChargePolicy(ManagerSetWeatherExtraChargePolicyReq req) throws ApiException {
        return lastmileManagerPartnerApi.setWeatherExtraChargePolicyUsingPOST(lastmileTokenService.getAuthToken(), req);
    }

}
