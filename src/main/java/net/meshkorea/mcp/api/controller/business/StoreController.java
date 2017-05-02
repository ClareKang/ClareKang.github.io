package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.model.*;
import io.swagger.annotations.ApiParam;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
@RequestMapping(value = "/intra/v1")
public class StoreController {
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/store_management_departments/list", method = RequestMethod.GET)
    public @ResponseBody
    List<StoreManagementDepartment> getStoreManagementDepartmentList() throws Exception {
        return storeService.getStoreManagementDepartmentList();
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public @ResponseBody
    StoresResult listStores(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                            String storeName, String clientName, String storePhone, String storeAddress,
                            String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                            Integer size, Integer page) throws Exception {
        return storeService.listStores(storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag,
            storeManagementDepartmentId, vroongMonitoringPartnerId, size, page);
    }

    @RequestMapping(value = "/stores/monitoring_partners", method = RequestMethod.GET)
    public @ResponseBody
    List<MonitoringPartner> listPartners() throws Exception {
        return storeService.listPartners();
    }

    @RequestMapping(value = "/stores/business_clients/list", method = RequestMethod.GET)
    public @ResponseBody
    List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return storeService.getBusinessClientList(clientType);
    }

    @RequestMapping(value = "/stores/vroong_service_pricing_types", method = RequestMethod.GET)
    public @ResponseBody List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return storeService.listVroongServicePricingTypes();
    }

    @RequestMapping(value = "/stores/sales_departments", method = RequestMethod.GET)
    public @ResponseBody List<StoreSalesDepartment> getSalesDeparments() throws Exception {
        return storeService.getSalesDepartments();
    }

    @RequestMapping(value = "/stores/individual", method = RequestMethod.POST)
    public Store createIndividualStore(@RequestBody CreateIndividualStoreRequest req) throws Exception {
        return storeService.createIndividualStore(req);
    }

    @RequestMapping(value = "/stores/franchise_individual", method = RequestMethod.POST)
    public @ResponseBody Store createFranchiseIndividualStore(@RequestBody CreateFranchiseIndividualStoreRequest req) throws Exception {
        return storeService.createFranchiseIndividualStore(req);
    }

    @RequestMapping(value = "/stores/franchise_corporate", method = RequestMethod.POST)
    public @ResponseBody Store createFranchiseCorporateStore(@RequestBody CreateFranchiseCorporateStoreRequest req) throws Exception {
        return storeService.createFranchiseCorporateStore(req);
    }

    @RequestMapping(value = "/stores/store_users/check", method = RequestMethod.POST)
    public @ResponseBody Boolean checkStoreUserExists(@RequestBody CheckStoreUsersRequest req) throws Exception {
        return storeService.checkStoreUserExists(req);
    }

    @RequestMapping(value = "/businessClients/{id}/files", method = RequestMethod.POST)
    public @ResponseBody BusinessClient updateBusinessClientFiles(@PathVariable Integer id, @RequestPart MultipartFile[] files) throws Exception {
        return storeService.updateBusinessClientFiles(id, files);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public @ResponseBody Store getStore(@PathVariable Integer id) throws Exception {
        return storeService.getStore(id.toString());
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    public @ResponseBody Store updateStore(@PathVariable Integer id, @RequestBody Store store) throws Exception {
        return storeService.updateStore(id.toString(), store);
    }
}
