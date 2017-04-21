package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.IntraBusinessClientsApi;
import com.meshprime.intra.api.IntraDeliveriesApi;
import com.meshprime.intra.api.IntraRegionsApi;
import com.meshprime.intra.api.IntraStoresApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by chaelee on 2017. 3. 23..
 */
@Service
public class StoreService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraStoresApi intraStoresApi;

    @Autowired
    IntraDeliveriesApi intraDeliveriesApi;

    @Autowired
    IntraBusinessClientsApi intraBusinessClientsApi;

    @Autowired
    IntraRegionsApi intraRegionsApi;

    public List<StoreManagementDepartment> getStoreManagementDepartmentList() throws Exception {
        return intraStoresApi.getStoreManagementDepartmentsList(intraTokenService.getAuthToken());
    }

    public StoresResult listStores(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                                   String storeName, String clientName, String storePhone, String storeAddress,
                                   String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                                   Integer size, Integer page) throws Exception {
        return intraStoresApi.listStores(intraTokenService.getAuthToken(), storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId,
            vroongMonitoringPartnerId, size, page);
    }

    public List<MonitoringPartner> listPartners() throws Exception {
        return intraStoresApi.listMonitoringPartners(intraTokenService.getAuthToken());
    }

    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return intraBusinessClientsApi.getBusinessClientList(intraTokenService.getAuthToken(), clientType);
    }

    public List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return intraStoresApi.listVroongServicePricingTypes(intraTokenService.getAuthToken());
    }

    public List<StoreSalesDepartment> getSalesDepartments() throws Exception {
        return intraStoresApi.salesDepartments(intraTokenService.getAuthToken());
    }

    public List<Bank> getBanks() throws Exception {
        return intraStoresApi.listBanks(intraTokenService.getAuthToken());
    }

    public List<Regions> listSiDo() throws Exception {
        return intraRegionsApi.listRegionsSiDo(intraTokenService.getAuthToken());
    }

    public List<Regions> listSiGunGU(Integer parentCode, String siDo) throws Exception {
        return intraRegionsApi.listSiGunGuByCode(intraTokenService.getAuthToken(), parentCode, siDo);
    }

    public List<Regions> listEupMyeonDongRi(Integer parentCode, String siDo, String siGunGu, Boolean onlyAdminDong, Boolean onlyLegalDong) throws Exception {
        return intraRegionsApi.listEupMyeonDongByCode(intraTokenService.getAuthToken(), parentCode, siDo, siGunGu, onlyAdminDong, onlyLegalDong);
    }

    public Store createIndividualStore(CreateIndividualStoreRequest req) throws Exception {
        return intraStoresApi.createIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public Store createFranchiseIndividualStore(CreateFranchiseIndividualStoreRequest req) throws Exception {
        return intraStoresApi.createFranchiseIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public Store createFranchiseCorporateStore(CreateFranchiseCorporateStoreRequest req) throws Exception {
        return intraStoresApi.createFranchiseCorporateStore(intraTokenService.getAuthToken(), req);
    }

    public Boolean checkStoreUserExists(CheckStoreUsersRequest req) throws Exception {
        return intraStoresApi.checkStoreUserExists(intraTokenService.getAuthToken(), req);
    }

    public BusinessClient updateBusinessClientFiles(Integer clientId, MultipartFile[] files) throws Exception {

        File enterpriseRegistrationCopy;
        File bankAccountCopy;
        File ceoIdCardCopy;

        enterpriseRegistrationCopy = new File(files[0].getOriginalFilename());
        files[0].transferTo(enterpriseRegistrationCopy);

        bankAccountCopy = new File(files[1].getOriginalFilename());
        files[1].transferTo(bankAccountCopy);

        ceoIdCardCopy = new File(files[2].getOriginalFilename());
        files[2].transferTo(ceoIdCardCopy);

        return intraBusinessClientsApi.updateBusinessClientFiles(intraTokenService.getAuthToken(), clientId,
            enterpriseRegistrationCopy, bankAccountCopy, ceoIdCardCopy);
    }

    public Store getStore(String id) throws Exception {
        return intraStoresApi.getStore(intraTokenService.getAuthToken(), id);
    }

    public Store updateStore(String id, Store store) throws Exception {
        return intraStoresApi.updateStore(intraTokenService.getAuthToken(), id, store);
    }
}
