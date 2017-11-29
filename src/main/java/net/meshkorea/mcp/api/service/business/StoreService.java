package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.common.constant.IntraApiTypeEnum;
import com.meshprime.intra.api.IntraBusinessClientsApi;
import com.meshprime.intra.api.IntraDeliveriesApi;
import com.meshprime.intra.api.IntraRegionsApi;
import com.meshprime.intra.api.IntraStoresApiFactory;
import com.meshprime.intra.service.auth.IntraTokenService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaelee on 2017. 3. 23..
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreService {

    private final IntraTokenService intraTokenService;

    private final IntraStoresApiFactory intraStoresApiFactory;

    private final IntraBusinessClientsApi intraBusinessClientsApi;

    private final IntraRegionsApi intraRegionsApi;

    private final IntraDeliveriesApi intraDeliveriesApi;

    private final VirtualBankAccountService virtualBankAccountService;

    public List<StoreManagementDepartment> getStoreManagementDepartmentList() throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreManagementDepartmentsList(intraTokenService.getAuthToken());
    }

    public StoresResult listStores(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                                   String storeName, String clientName, String storePhone, String storeAddress,
                                   String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                                   Integer size, Integer page) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).listStores(
            intraTokenService.getAuthToken(), storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId,
            vroongMonitoringPartnerId, size, page);
    }

    public StoresResult getStoresForExcel(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                                          String storeName, String clientName, String storePhone, String storeAddress,
                                          String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                                          Integer size, Integer page) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.ACCOUNTING).listStores(
            intraTokenService.getAuthToken(), storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId,
            vroongMonitoringPartnerId, size, page);
    }

    public List<String> excelHeader() {
        List<String> result = new ArrayList<>();
        result.add("상점 id(#)");
        result.add("상점명");
        result.add("본사(정산대상) id(#)");
        result.add("본사(정산대상)");
        result.add("본사(프랜차이즈) id(#)");
        result.add("본사(프랜차이즈)");
        result.add("기업/개별상점");
        result.add("운영상태");
        result.add("상점전화번호");
        result.add("상점ID");
        result.add("상점주소_시도");
        result.add("상점주소_시구");
        result.add("상점주소_동");
        result.add("상점주소_번지주소");
        result.add("상점주소_상세주소");
        result.add("상점 API 점포코드");
        result.add("관제위탁사");
        result.add("영업구분값");
        result.add("관리구분");
        result.add("부릉 원가 요금제");
        result.add("고객전화번호 필수입력 여부");
        result.add("기사매입");
        result.add("픽업지연");
        result.add("카드 수수료율(%)");
        result.add("더존코드");
        result.add("상점 담당자");
        result.add("상점 담당자 전화번호");
        result.add("상점 담당자 이메일주소");
        result.add("상점 사업자명");
        result.add("상점 사업자 등록번호");
        result.add("상점 기업 대표자명");
        result.add("상점 예금주");
        result.add("상점 은행명");
        result.add("상점 계좌번호");
        result.add("본사 담당자 이메일주소");
        result.add("본사 사업자명");
        result.add("본사 사업자 등록번호");
        result.add("본사 기업 대표자명");
        result.add("본사 예금주");
        result.add("본사 은행명");
        result.add("본사 계좌번호");
        result.add("상점 가상계좌 예금주");
        result.add("상점 가상계좌 은행명");
        result.add("상점 가상계좌 계좌번호");
        return result;
    }

    public List<List<String>> excelBodies(List<Store> storeList) throws Exception {
        List<List<String>> result = new ArrayList<>();
        List<VroongServicePricingType> pricingTypes = listVroongServicePricingTypes();
        List<VroongPartner> partners = listVroongPartners();

        HashMap<String, String> pricingTypeMap = new HashMap<>();
        HashMap<Integer, String> partnerMap = new HashMap<>();

        for (VroongServicePricingType pricingType : pricingTypes) {
            pricingTypeMap.put(pricingType.getDeliveryClass(), pricingType.getName());
        }

        for (VroongPartner partner : partners) {
            partnerMap.put(partner.getId(), partner.getName());
        }

        // get virtual bank accounts
        List<Integer> businessOwnerIds = new ArrayList<>();
        storeList.forEach(item -> businessOwnerIds.add(item.getBusinessOwnerId()));
        List<BusinessClientVirtualBankAccount> virtualBankAccounts = virtualBankAccountService.getVirtualBankAccountsByBusinessClientIdsForExcel(businessOwnerIds);
        Map<Integer, BusinessClientVirtualBankAccount> virtualBankMap = virtualBankAccountService.convertToMap(virtualBankAccounts);

        storeList.forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getId().toString());
            row.add(item.getStoreName());
            row.add(item.getBusinessOwnerId().toString());
            row.add(item.getBusinessOwner().getClientName());
            row.add(item.getFranchiseId().toString());
            row.add(item.getFranchise().getClientName());
            row.add(item.getStoreType());
            row.add(getOperationStatus(item));
            row.add(item.getStorePhone());
            row.add(item.getStoreUser() == null ? StringUtils.EMPTY : item.getStoreUser().getName());
            row.add(item.getStoreAddress().getBeonjiAddress().getSiDo());
            row.add(item.getStoreAddress().getBeonjiAddress().getSiGunGu());
            row.add(item.getStoreAddress().getBeonjiAddress().getEupMyeonDongRi());
            row.add(item.getStoreAddress().getBeonjiAddress().getBeonji());
            row.add(item.getStoreAddress().getBeonjiAddress().getDetailAddress());
            row.add(item.getBranchCode());
            if (item.getVroongMonitoringPartnerId() != null) {
                row.add(partnerMap.get(item.getVroongMonitoringPartnerId()));
            } else {
                row.add("");
            }
            row.add(item.getStoreSalesDepartment().getName());
            row.add(item.getStoreManagementDepartment().getDepartmentName());
            row.add(pricingTypeMap.get(item.getVroongServicePricingType()));
            row.add(item.getDestPhoneRequired() ? "필수" : "비필수");
            row.add(item.getAgentBuyingPossible() ? "허용" : "불허용");
            row.add(item.getVroongPickUpDelayPossible() != 0 ? "허용" : "불허용");
            row.add(item.getCardFeeRate().toString());
            row.add(item.getDuzonCode());
            row.add(item.getStoreContactName());
            row.add(item.getStoreContactPhone());
            row.add(item.getStoreContactEmail());
            if (item.getStoreType().equals("FRANCHISE_CORPORATE")) {
                for (int i = 0; i < 6; i++)
                    row.add("-");
            } else {
                row.add(item.getBusinessOwner().getEnterpriseName());
                row.add(item.getBusinessOwner().getEnterpriseRegistrationNumber());
                row.add(item.getBusinessOwner().getCeoName());
                row.add(item.getBusinessOwner().getBankAccount().getAccountOwner());
                row.add(item.getBusinessOwner().getBankAccount().getBankName());
                row.add(item.getBusinessOwner().getBankAccount().getAccountNumber());
            }
            row.add(item.getFranchise().getClientContactEmail());
            row.add(item.getFranchise().getEnterpriseName());
            row.add(item.getFranchise().getEnterpriseRegistrationNumber());
            row.add(item.getFranchise().getCeoName());
            row.add(item.getFranchise().getBankAccount().getAccountOwner());
            row.add(item.getFranchise().getBankAccount().getBankName());
            row.add(item.getFranchise().getBankAccount().getAccountNumber());

            BusinessClientVirtualBankAccount virtualBankAccount = virtualBankMap.get(item.getBusinessOwnerId());
            row.add(virtualBankAccount != null ? virtualBankAccount.getAccountOwner() : "");
            row.add(virtualBankAccount != null ? virtualBankAccount.getBankName() : "");
            row.add(virtualBankAccount != null ? virtualBankAccount.getVirtualBankAccountNumber() : "");

            result.add(row);
        });
        return result;
    }

    private String getOperationStatus(Store item) {
        String returnStatus = "";
        switch (item.getStoreOperatingStatus()) {
            case "INACTIVE":
                returnStatus = "비활성화";
                break;
            case "OPERATING":
                returnStatus = "운영중";
                break;
            case "NOT_OPERATING":
                returnStatus = "운영중지";
                break;
            case "OUT_OF_BUSINESS":
                returnStatus = "폐점";
                break;
            case "NOT_OPERATING_BAD_WEATHER":
                returnStatus = "악천후로 인한 일시 중지";
                break;
            case "NOT_OPERATING_BALANCE_UNSETTLED":
                returnStatus = "미수금 한도 초과로 인한 일시 중지";
                break;
            case "NOT_OPERATING_REQUESTED_BY_STORE":
                returnStatus = "상점 신청으로 인한 일시 중지";
                break;
            case "NOT_OPERATING_ORDER_OVERLOAD":
                returnStatus = "배송량 폭주로 인한 배송지연";
                break;
            case "NOT_OPERATING_OTHER":
                returnStatus = "기타 사유로 인한 일시 중지 (POS 안내문구 직접 작성)";
                break;
            default:
                returnStatus = "-";
                break;
        }
        return returnStatus;
    }

    public String excelFileName() {
        return "상점목록_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    public List<VroongPartner> listVroongPartners() throws ApiException {
        return intraDeliveriesApi.getVroongPartners(intraTokenService.getAuthToken());
    }

    public List<MonitoringPartner> listPartners() throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).listMonitoringPartners(intraTokenService.getAuthToken());
    }

    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return intraBusinessClientsApi.getBusinessClientList(intraTokenService.getAuthToken(), clientType);
    }

    public List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).listVroongServicePricingTypes(intraTokenService.getAuthToken());
    }

    public List<StoreSalesDepartment> getSalesDepartments() throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).salesDepartments(intraTokenService.getAuthToken());
    }

    public StoreResponse createIndividualStore(CreateIndividualStoreRequest req) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).createIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public StoreResponse createFranchiseIndividualStore(CreateFranchiseIndividualStoreRequest req) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).createFranchiseIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public StoreResponse createFranchiseCorporateStore(CreateFranchiseCorporateStoreRequest req) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).createFranchiseCorporateStore(intraTokenService.getAuthToken(), req);
    }

    public Boolean checkStoreUserExists(CheckStoreUsersRequest req) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).checkStoreUserExists(intraTokenService.getAuthToken(), req);
    }

    public Store getStore(String id) throws Exception {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStore(intraTokenService.getAuthToken(), id);
    }

    public ResponseEntity updateStore(String id, StoreRequest store) throws Exception {
        try {
            CancelPricingPolicy cancelPricingPolicy = store.getCancelPricingPolicy();
            if (cancelPricingPolicy.getAssigned() == null && cancelPricingPolicy.getPickedUp() == null && cancelPricingPolicy.getSubmitted() == null) {
                cancelPricingPolicy.setNullSerialize(true);
            }
            return ResponseEntity.ok(this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStore(intraTokenService.getAuthToken(), id, store));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }
    }

    public List<StoreList> getStoreList(String storeType, String storeName, String clientName, String storePhone, String storeAddress,
                                        String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreList(intraTokenService.getAuthToken(), storeType, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId, vroongMonitoringPartnerId);
    }

    public UpdatePricingPolicyResponse updateStorePricingPolicy(Integer id, PricingPolicy pricingPolicy) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStorePricingPolicy(intraTokenService.getAuthToken(), id.toString(), pricingPolicy);
    }

    public List<Regions> getDetailRegions(String detail) throws ApiException {
        return intraRegionsApi.listRegions(intraTokenService.getAuthToken(), "", "", detail, 0, "0");
    }

    public List<Regions> updateStoreRegions(Integer id, UpdateStoreRegionsRequest req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStoreRegions(intraTokenService.getAuthToken(), id, req);
    }

    public SubscriptionPlan updateSubscriptionPlan(String id, SubscriptionPlan req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateSubscriptionsPlan(intraTokenService.getAuthToken(), id, req);
    }

    public Store updateAdminMemo(String id, AdminMemoRequest req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).addStoreAdminMemo(intraTokenService.getAuthToken(), id, req);
    }

    public BranchCodesResponse createBranchCode(String id, CreateApiBranchCodeRequest req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).createStoreBranchCode(intraTokenService.getAuthToken(), id, req);
    }

    public BranchCodesResponse getBranchCode(String id) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreBranchCode(intraTokenService.getAuthToken(), id);
    }

    public BranchCodesResponse updateBranchCode(String id, UpdateApiBranchCodeRequest req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStoreBranchCode(intraTokenService.getAuthToken(), id, req);
    }

    public StoreVirtualBankAccount getStoreVirtualBankAccount(String id) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreVirtualBankAccount(intraTokenService.getAuthToken(), id);
    }

    public ResponseEntity updateStoreCertificationStatus(String id, ChangeStoreCertificationStatusRequest req) throws ApiException {
        try {
            return ResponseEntity.ok(this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).changeStoreCertificationStatus(intraTokenService.getAuthToken(), id, req));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }
    }

    public ResponseEntity updateStoreOperatingStatus(String id, ChangeStoreOperatingStatusRequest req) throws ApiException {
        try {
            return ResponseEntity.ok(this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).changeStoreOperatingStatus(intraTokenService.getAuthToken(), id, req));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }
    }

    public Store addSubscriptionAdminMemo(String id, SubscriptionAdminMemo req) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).addSubscriptionAdminMemo(intraTokenService.getAuthToken(), id, req);
    }

    // 상점 첫 달 가맹비 미리보기
    public StoreSubscriptionPlanPreview getStoreSubscriptionPlanPreview(String id, String startAt, Integer baseFee) throws ApiException {
        return this.intraStoresApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreSubscriptionPlanPreview(intraTokenService.getAuthToken(), id, startAt, baseFee);
    }
}
