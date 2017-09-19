package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.domain.model.store.CheckStoreName;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(path = "/store/excel")
    public ModelAndView downloadStoreListToExcel(@RequestParam(required = false) String storeType,
                                                 @RequestParam(required = false) String storeCertificationStatus,
                                                 @RequestParam(required = false) String storeOperatingStatus,
                                                 @RequestParam(required = false) String storeName,
                                                 @RequestParam(required = false) String clientName,
                                                 @RequestParam(required = false) String storePhone,
                                                 @RequestParam(required = false) String storeAddress,
                                                 @RequestParam(required = false) String tag,
                                                 @RequestParam(required = false) Integer storeManagementDepartmentId,
                                                 @RequestParam(required = false) Integer vroongMonitoringPartnerId,
                                                 @RequestParam(required = false) Integer size,
                                                 @RequestParam(required = false) Integer page,
                                                 ModelAndView mav) throws Exception {
        List<Store> list = storeService.listStores(storeType, storeCertificationStatus,
                storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag,
                storeManagementDepartmentId, vroongMonitoringPartnerId, size, page).getData();
        List<String> headers = storeService.excelHeader();
        List<List<String>> body = storeService.excelBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, storeService.excelFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    @RequestMapping(value = "/stores/list", method = RequestMethod.GET)
    public List<StoreList> getStoreList(String storeType, String storeName, String clientName, String storePhone, String storeAddress,
                                        String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId
    ) throws ApiException {
        return storeService.getStoreList(storeType, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId, vroongMonitoringPartnerId);
    }

    @GetMapping(value = "/stores/vroong_partners")
    public List<VroongPartner> listVroongPartners() throws ApiException {
        return storeService.listVroongPartners();
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
    public StoreResponse createIndividualStore(@RequestBody CreateIndividualStoreRequest req) throws Exception {
        return storeService.createIndividualStore(req);
    }

    @RequestMapping(value = "/stores/franchise_individual", method = RequestMethod.POST)
    public StoreResponse createFranchiseIndividualStore(@RequestBody CreateFranchiseIndividualStoreRequest req) throws Exception {
        return storeService.createFranchiseIndividualStore(req);
        //return new CreateFranchiseIndividualStoreRequest();
    }

    @RequestMapping(value = "/stores/franchise_corporate", method = RequestMethod.POST)
    public StoreResponse createFranchiseCorporateStore(@RequestBody CreateFranchiseCorporateStoreRequest req) throws Exception {
        return storeService.createFranchiseCorporateStore(req);
        //return new CreateFranchiseCorporateStoreRequest();
    }

    @RequestMapping(value = "/stores/store_users/check", method = RequestMethod.POST)
    public CheckStoreName checkStoreUserExists(@RequestBody CheckStoreUsersRequest req) throws Exception {
        boolean value = storeService.checkStoreUserExists(req);
        CheckStoreName result = new CheckStoreName();
        result.setResult(value);
        return result;
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    public Store getStore(@PathVariable Integer id) throws Exception {
        return storeService.getStore(id.toString());
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateStore(@PathVariable Integer id, @RequestBody StoreRequest store) throws Exception {
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
    public SubscriptionPlan updateSubscriptionPlan(@PathVariable String id, @RequestBody SubscriptionPlan req) throws ApiException {
        return storeService.updateSubscriptionPlan(id, req);
    }

    @PostMapping(value = "/stores/{id}/admin_memo")
    public Store updateAdminMemo(@PathVariable String id, AdminMemoRequest req) throws ApiException {
        return storeService.updateAdminMemo(id, req);
    }

    @PostMapping(value = "/stores/{id}/branch_code")
    public BranchCodesResponse createBranchCode(@PathVariable String id, CreateApiBranchCodeRequest req) throws ApiException {
        return storeService.createBranchCode(id, req);
    }

    @GetMapping(value = "/stores/{id}/branch_code")
    public BranchCodesResponse getBranchCode(@PathVariable String id) throws ApiException {
        return storeService.getBranchCode(id);
    }

    @PutMapping(value = "/stores/{id}/branch_code")
    public BranchCodesResponse updateBranchCode(@PathVariable String id, UpdateApiBranchCodeRequest req) throws ApiException {
        return storeService.updateBranchCode(id, req);
    }

    @GetMapping(value = "/stores/{id}/virtual_bank_accounts")
    public VirtualBankAccount getStoreVirtualBankAccount(@PathVariable String id) throws ApiException {
        return storeService.getStoreVirtualBankAccount(id);
    }

    @PutMapping(value = "/stores/{id}/certification_status")
    public ResponseEntity updateStoreCertificationStatus(@PathVariable String id, @RequestBody ChangeStoreCertificationStatusRequest req) throws ApiException {
        return storeService.updateStoreCertificationStatus(id, req);
    }

    @PutMapping(value = "/stores/{id}/operating_status")
    public ResponseEntity updateStoreOperatingStatus(@PathVariable String id, @RequestBody ChangeStoreOperatingStatusRequest req) throws ApiException {
        return storeService.updateStoreOperatingStatus(id, req);
    }

    @PostMapping(value = "/stores/{id}/subscription/admin_memo")
    public Store addSubscriptionAdminMemo(@PathVariable String id, @RequestBody SubscriptionAdminMemo req) throws ApiException {
        return storeService.addSubscriptionAdminMemo(id, req);
    }

    // 상점 첫 달 가맹비 미리보기
    @GetMapping(value = "/stores/{id}/subscription/plan/preview")
    public StoreSubscriptionPlanPreview getStoreSubscriptionPlanPreview(@PathVariable String id, @RequestParam(required = false) String startAt, @RequestParam(required = false) Integer baseFee) throws ApiException {
        return storeService.getStoreSubscriptionPlanPreview(id, startAt, baseFee);
    }
}
