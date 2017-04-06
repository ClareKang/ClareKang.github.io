package net.meshkorea.mcp.api.controller.business;

import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    List<BusinessClientShort> getBusinessClientList(GetBusinessClientListRequest req) throws Exception {
        return storeService.getBusinessClientList(req);
    }

    @RequestMapping(value = "/deliveries/vroong_partners", method = RequestMethod.GET)
    public @ResponseBody List<VroongPartner> getVroongPartners() throws Exception {
        return storeService.getVroongPartners();
    }

    @RequestMapping(value = "/stores/vroong_service_pricing_types", method = RequestMethod.GET)
    public @ResponseBody List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return storeService.listVroongServicePricingTypes();
    }
}
