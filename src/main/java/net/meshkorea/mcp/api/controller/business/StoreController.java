package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/store_management_departments/list", method = RequestMethod.GET)
    public List<StoreManagementDepartment> getStoreManagementDepartmentList() throws Exception {
        return storeService.getStoreManagementDepartmentList();
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public StoresResult listStores(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                            String storeName, String clientName, String storePhone, String storeAddress,
                            String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                            Integer size, Integer page) throws Exception {
        return storeService.listStores(storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag,
            storeManagementDepartmentId, vroongMonitoringPartnerId, size, page);
    }

    @RequestMapping(value = "/stores/list", method = RequestMethod.GET)
    public List<StoreList> getStoreList(String storeType, String storeName, String clientName, String storePhone, String storeAddress,
                                           String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId
                                         ) throws ApiException{
        System.out.println(storeType + ", " + storeName + ", " + clientName + ", " + storePhone + ", " + storeAddress + ", " + tag + ", " + storeManagementDepartmentId + ", " + vroongMonitoringPartnerId);
        return storeService.getStoreList(storeType, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId, vroongMonitoringPartnerId);
    }

    @RequestMapping(value = "/stores/monitoring_partners", method = RequestMethod.GET)
    public List<MonitoringPartner> listPartners() throws Exception {
        return storeService.listPartners();
    }

    @RequestMapping(value = "/stores/vroong_service_pricing_types", method = RequestMethod.GET)
    public List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return storeService.listVroongServicePricingTypes();
    }

    @RequestMapping(value = "/stores/sales_departments", method = RequestMethod.GET)
    public List<StoreSalesDepartment> getSalesDeparments() throws Exception {
        return storeService.getSalesDepartments();
    }

    @RequestMapping(value = "/stores/individual", method = RequestMethod.POST)
    public Store createIndividualStore(@RequestBody CreateIndividualStoreRequest req) throws Exception {
        return storeService.createIndividualStore(req);
    }

    @RequestMapping(value = "/stores/franchise_individual", method = RequestMethod.POST)
    public Store createFranchiseIndividualStore(@RequestBody CreateFranchiseIndividualStoreRequest req) throws Exception {
        return storeService.createFranchiseIndividualStore(req);
    }

    @RequestMapping(value = "/stores/franchise_corporate", method = RequestMethod.POST)
    public Store createFranchiseCorporateStore(@RequestBody CreateFranchiseCorporateStoreRequest req) throws Exception {
        return storeService.createFranchiseCorporateStore(req);
    }

    @RequestMapping(value = "/stores/store_users/check", method = RequestMethod.POST)
    public Boolean checkStoreUserExists(@RequestBody CheckStoreUsersRequest req) throws Exception {
        return storeService.checkStoreUserExists(req);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public Store getStore(@PathVariable Integer id) throws Exception {
        return storeService.getStore(id.toString());
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    public Store updateStore(@PathVariable Integer id, @RequestBody Store store) throws Exception {
        return storeService.updateStore(id.toString(), store);
    }

    @PutMapping(value = "/stores/{id}/pricingPolicy")
    public UpdatePricingPolicyResponse updateStorePricingPolicy(@PathVariable Integer id,
                                             @RequestBody PricingPolicy pricingPolicy) throws ApiException {
        return storeService.updateStorePricingPolicy(id, pricingPolicy);
    }

    @GetMapping(value = "/stores/regions")
    public List<Regions> getDetailRegions(String detail) throws ApiException {
        return storeService.getDetailRegions(detail);
    }

    @PutMapping(value = "/stores/{id}/regions")
    public List<Regions> updateStoreRegions(@PathVariable Integer id, @RequestBody UpdateStoreRegionsRequest req) throws ApiException {
        return storeService.updateStoreRegions(id, req);
    }

    @PutMapping(value = "/stores/{id}/subscription/plan")
    public SubscriptionPlan updateSubscriptionPlan(@PathVariable Integer id, @RequestBody SubscriptionPlan req) throws ApiException {
        return storeService.updateSubscriptionPlan(id, req);
    }

}
