package net.meshkorea.mcp.api.service.accounting;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.common.constant.IntraApiTypeEnum;
import com.meshprime.intra.api.IntraDeliveriesApi;
import com.meshprime.intra.api.IntraSubscriptionApiFactory;
import com.meshprime.intra.service.auth.IntraTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by clarekang on 2017. 8. 21..
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubscriptionService {

    private final IntraTokenService intraTokenService;

    private final IntraSubscriptionApiFactory intraSubscriptionApiFactory;

    private final IntraDeliveriesApi intraDeliveriesApi;

    public List<VroongPartner> listVroongPartners() throws ApiException {
        return intraDeliveriesApi.getVroongPartners(intraTokenService.getAuthToken());
    }

    public ResponseEntity getSubscriptionListByStore(
            String term,
            String all,
            String storeName,
            String storeId,
            String enterpriseRegistrationNumber,
            String storePhone,
            String ceoName,
            Integer storeSalesDepartmentId,
            String storeOperatingStatus,
            Integer vroongMonitoringPartnerId,
            Integer storeManagementDepartmentId,
            String managerName,
            String fulfilled,
            String pointAccountIsUsed,
            Integer page,
            Integer size
    ) throws ApiException {
        try {
            return ResponseEntity.ok(intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getSubscriptionListByStore(
                    intraTokenService.getAuthToken(),
                    term,
                    all,
                    storeName,
                    storeId,
                    enterpriseRegistrationNumber,
                    storePhone,
                    ceoName,
                    storeSalesDepartmentId,
                    storeOperatingStatus,
                    vroongMonitoringPartnerId,
                    storeManagementDepartmentId,
                    managerName,
                    fulfilled,
                    pointAccountIsUsed,
                    page,
                    size
            ));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }
    }

    public SubscriptionList getSubscriptionListByStoreForExcel(
            String term,
            String all,
            String storeName,
            String storeId,
            String enterpriseRegistrationNumber,
            String storePhone,
            String ceoName,
            Integer storeSalesDepartmentId,
            String storeOperatingStatus,
            Integer vroongMonitoringPartnerId,
            Integer storeManagementDepartmentId,
            String managerName,
            String fulfilled,
            String pointAccountIsUsed,
            Integer page,
            Integer size
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.ACCOUNTING).getSubscriptionListByStore(
                intraTokenService.getAuthToken(),
                term,
                all,
                storeName,
                storeId,
                enterpriseRegistrationNumber,
                storePhone,
                ceoName,
                storeSalesDepartmentId,
                storeOperatingStatus,
                vroongMonitoringPartnerId,
                storeManagementDepartmentId,
                managerName,
                fulfilled,
                pointAccountIsUsed,
                page,
                size
        );
    }

    public ResponseEntity getSubscriptionListByMonth(
            String from,
            String to,
            String all,
            String storeName,
            String storeId,
            String enterpriseRegistrationNumber,
            String storePhone,
            String ceoName,
            String fulfilled,
            String pointAccountIsUsed,
            Integer page,
            Integer size
    ) throws ApiException {
        try {
            return ResponseEntity.ok(intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getSubscriptionListByMonth(
                    intraTokenService.getAuthToken(),
                    from,
                    to,
                    all,
                    storeName,
                    storeId,
                    enterpriseRegistrationNumber,
                    storePhone,
                    ceoName,
                    fulfilled,
                    pointAccountIsUsed,
                    page,
                    size
            ));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(e.getResponseBody());
        }
    }

    public SubscriptionList getSubscriptionListByMonthForExcel(
            String from,
            String to,
            String all,
            String storeName,
            String storeId,
            String enterpriseRegistrationNumber,
            String storePhone,
            String ceoName,
            String fulfilled,
            String pointAccountIsUsed,
            Integer page,
            Integer size
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.ACCOUNTING).getSubscriptionListByMonth(
                intraTokenService.getAuthToken(),
                from,
                to,
                all,
                storeName,
                storeId,
                enterpriseRegistrationNumber,
                storePhone,
                ceoName,
                fulfilled,
                pointAccountIsUsed,
                page,
                size
        );
    }

    // 상점 월가맹비 입금 처리
    public Subscription updateStoreSubscription(
            Integer storeId,
            Integer subscriptionId,
            UpdateStoreSubscriptionRequest req
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStoreSubscription(intraTokenService.getAuthToken(), storeId, subscriptionId, req);
    }

    // 상점 월가맹비 입금 취소 처리
    public Subscription deleteStoreSubscription(
            Integer storeId,
            Integer subscriptionId
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).deleteStoreSubscription(intraTokenService.getAuthToken(), storeId, subscriptionId);
    }

    // 상점 가맹비 잔액 내역 조회
    public StoreDepositList getStoreDepositList(
            Integer id,
            Integer size,
            Integer page
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).getStoreDepositList(intraTokenService.getAuthToken(), id, size, page);
    }

    // 상점 가맹비 잔액 변경
    public StoreDepositList updateStoreDeposit(
            Integer id,
            UpdateStoreDepositRequest req
    ) throws ApiException {
        return intraSubscriptionApiFactory.getApiClient(IntraApiTypeEnum.MAIN).updateStoreDeposit(intraTokenService.getAuthToken(), id, req);
    }

    // 가맹비 정보 엑셀 다운로드
    public List<String> excelSubscriptionHeader() {
        List<String> result = new ArrayList<>();
        result.add("상점명");
        result.add("사업자등록번호");
        result.add("대표자명");
        result.add("영업구분");
        result.add("관제위탁사");
        result.add("기본가맹비");
        result.add("배송건수");
        result.add("추가금액");
        result.add("할인금액");
        result.add("가맹비");
        result.add("관리자");
        result.add("가맹비 총 미수금");
        result.add("예금주");
        result.add("계좌이체");
        result.add("처리자");
        result.add("사업자명");
        result.add("본사담당자명");
        result.add("상점담당자명");
        return result;
    }

    public List<List<String>> excelSubscriptionBodies(SubscriptionList list) throws Exception {
        List<List<String>> result = new ArrayList<>();
        List<VroongPartner> partners = listVroongPartners();

        HashMap<Integer, String> partnerMap = new HashMap<>();

        for( VroongPartner partner : partners ) {
            partnerMap.put(partner.getId(), partner.getName());
        }

        list.getData().forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getStoreName());
            row.add(item.getEnterpriseRegistrationNumber());
            row.add(item.getCeoName());
            row.add(item.getStoreManagementDepartment());
            if (item.getVroongMonitoringPartnerId() != null) {
                row.add(partnerMap.get(item.getVroongMonitoringPartnerId()));
            } else {
                row.add("");
            }
            row.add(item.getBaseFee().toString());
            row.add(item.getDeliveryCountLastMonth().toString());
            row.add(item.getAdditionalFee().toString());
            row.add(item.getDiscountAmount().toString());
            row.add(item.getSubscriptionFee().toString());
            row.add(item.getManagerName());
            row.add(item.getTotalUncollectedByStore().toString());
            row.add(item.getAccountOwner());
            row.add(item.getConfirmedBy());
            row.add(item.getEnterpriseName());
            row.add(item.getClientContactName());
            row.add(item.getStoreContactName());
            result.add(row);
        });
        return result;
    }

    public String excelSubscriptionFileName() {
        return "가맹비_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    // 상점별 가맹비 정보 엑셀 다운로드
    public List<String> excelStoreSubscriptionHeader() {
        List<String> result = new ArrayList<>();
        result.add("정산월");
        result.add("상점명");
        result.add("사업자등록번호");
        result.add("대표자명");
        result.add("상점 전화번호");
        result.add("산정형태");
        result.add("기본가맹비");
        result.add("배송건수");
        result.add("추가금액");
        result.add("할인금액");
        result.add("가맹비");
        result.add("관리자");
        result.add("예금주");
        result.add("계좌이체");
        result.add("처리자");
        return result;
    }

    public List<List<String>> excelStoreSubscriptionBodies(SubscriptionList list) throws Exception {
        List<List<String>> result = new ArrayList<>();
        list.getData().forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getTerm());
            row.add(item.getStoreName());
            row.add(item.getEnterpriseRegistrationNumber());
            row.add(item.getCeoName());
            row.add(item.getStorePhone());
            row.add(getSubscriptionType(item));
            row.add(item.getBaseFee().toString());
            row.add(item.getDeliveryCountLastMonth().toString());
            row.add(item.getAdditionalFee().toString());
            row.add(item.getDiscountAmount().toString());
            row.add(item.getSubscriptionFee().toString());
            row.add(item.getManagerName());
            row.add(item.getAccountOwner());
            row.add(item.getFulfilled() == "true" ? DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(item.getFulfilledAt()) : "미입금");
            row.add(item.getConfirmedBy());
            result.add(row);
        });
        return result;
    }

    public String excelStoreSubscriptionFileName() {
        return "상점별_가맹비_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    public String getSubscriptionType(Subscription item) {
        String returnType = "";
        switch (item.getSubscriptionType()) {
            case "PREPAID":
                returnType = "선불";
                break;
            case "BILLED_LATER":
                returnType = "후불";
                break;
        }
        return returnType;
    }
}