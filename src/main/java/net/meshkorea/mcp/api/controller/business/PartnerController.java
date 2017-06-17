package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import io.swagger.annotations.Api;
import net.meshkorea.mcp.api.service.business.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/partner")
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @PostMapping("/findPartners")
    public ManagerFindPartnersRes findPartners(ManagerFindPartnersReq req) throws ApiException {
        return partnerService.findPartners(req);
    }

    @PostMapping("/getPartnerDetail")
    public ManagerGetPartnerDetailRes getPartnerDetail(ManagerGetPartnerDetailReq req) throws ApiException {
        return partnerService.getPartnerDetail(req);
    }

    @PostMapping("/addPartner")
    public ManagerAddPartnerRes addPartner(@RequestBody ManagerAddPartnerReq req) throws ApiException {
        return partnerService.addPartner(req);
    }

    @PostMapping("/removePartner")
    public ManagerRemovePartnerRes removePartner(ManagerRemovePartnerReq req) throws ApiException {
        return partnerService.removePartner(req);
    }

    @PostMapping("/updatePartner")
    public ManagerUpdatePartnerRes updatePartner(@RequestBody ManagerUpdatePartnerReq req) throws ApiException {
        return partnerService.updatePartner(req);
    }

    @GetMapping("/listAllPartners")
    public ManagerListAllPartnersRes listAllPartners() throws ApiException {
        return partnerService.listAllPartners();
    }

    @PostMapping("/findAgentsWithOrderCount")
    public ManagerFindAgentsWithOrderCountRes findAgentsWithOrderCount(@RequestBody ManagerFindAgentsWithOrderCountReq req) throws ApiException {
        return partnerService.findAgentsWithOrderCount(req);
    }

    @PostMapping("/findClients")
    public ManagerFindClientRes findClients(@RequestBody ManagerFindClientsReq req) throws ApiException {
        return partnerService.findClients(req);
    }

    @PostMapping("/findDepartments")
    public ManagerFindDepartmentsRes findDepartments(ManagerFindDepartmentsReq req) throws  ApiException {
        return partnerService.findDepartments(req);
    }

    @PostMapping("/addDepartment")
    public ManagerAddDepartmentRes addDepartment(ManagerAddDepartmentReq req) throws ApiException {
        return partnerService.addDepartment(req);
    }

    @PostMapping("/removeDepartment")
    public ManagerRemoveDepartmentRes removeDepartment(ManagerRemoveDepartmentReq req) throws ApiException {
        return partnerService.removeDepartment(req);
    }

    @PostMapping("/addCustomer")
    public ManagerAddCustomerRes addCustomer(@RequestBody ManagerAddCustomerReq req) throws ApiException {
        return partnerService.addCustomer(req);
    }

}
