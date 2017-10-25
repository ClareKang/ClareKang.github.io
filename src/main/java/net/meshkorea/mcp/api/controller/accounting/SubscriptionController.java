package net.meshkorea.mcp.api.controller.accounting;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.service.accounting.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by clarekang on 2017. 8. 21..
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    // 상점별 가맹비 목록 조회
    @GetMapping(value = "/subscriptions/by_store")
    public ResponseEntity<SubscriptionList> getSubscriptionListByStore(
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
    ) throws Exception {
        return subscriptionService.getSubscriptionListByStore(
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

    // 상점의 월별 가맹비 목록
    @GetMapping(value = "/subscriptions/by_month")
    public ResponseEntity<SubscriptionList> getSubscriptionListByMonth(
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
        return subscriptionService.getSubscriptionListByMonth(
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

    @GetMapping(path = "/subscription/excel")
    public ModelAndView downloadSubscriptionListToExcel(
            @RequestParam(required = false) String term,
            @RequestParam(required = false) String all,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) String storeId,
            @RequestParam(required = false) String enterpriseRegistrationNumber,
            @RequestParam(required = false) String storePhone,
            @RequestParam(required = false) String ceoName,
            @RequestParam(required = false) Integer storeSalesDepartmentId,
            @RequestParam(required = false) String storeOperatingStatus,
            @RequestParam(required = false) Integer vroongMonitoringPartnerId,
            @RequestParam(required = false) Integer storeManagementDepartmentId,
            @RequestParam(required = false) String managerName,
            @RequestParam(required = false) String fulfilled,
            @RequestParam(required = false) String pointAccountIsUsed,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            ModelAndView mav
    ) throws Exception {
        ResponseEntity<SubscriptionList> list = subscriptionService.getSubscriptionListByStore(
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

        SubscriptionList subcriptionList = new SubscriptionList();

        for( Subscription subscription : list.getBody().getData() ) {
            subcriptionList.addDataItem(subscription);
        }

        List<String> headers = subscriptionService.excelSubscriptionHeader();
        List<List<String>> body = subscriptionService.excelSubscriptionBodies(subcriptionList);
        mav.addObject(ExcelConfig.FILE_NAME, subscriptionService.excelSubscriptionFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    @GetMapping(path = "/subscription/store/excel")
    public ModelAndView downloadStoreSubscriptionListToExcel(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String all,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) String storeId,
            @RequestParam(required = false) String enterpriseRegistrationNumber,
            @RequestParam(required = false) String storePhone,
            @RequestParam(required = false) String ceoName,
            @RequestParam(required = false) String fulfilled,
            @RequestParam(required = false) String pointAccountIsUsed,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            ModelAndView mav
    ) throws Exception {
        ResponseEntity<SubscriptionList> list = subscriptionService.getSubscriptionListByMonth(
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

        SubscriptionList subcriptionList = new SubscriptionList();

        for( Subscription subscription : list.getBody().getData() ) {
            subcriptionList.addDataItem(subscription);
        }

        List<String> headers = subscriptionService.excelStoreSubscriptionHeader();
        List<List<String>> body = subscriptionService.excelStoreSubscriptionBodies(subcriptionList);

        mav.addObject(ExcelConfig.FILE_NAME, subscriptionService.excelStoreSubscriptionFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 상점 월가맹비 입금 처리
    @PutMapping(value = "/stores/{storeId}/subscriptions/{subscriptionId}")
    public Subscription updateStoreSubscription(
            @PathVariable Integer storeId,
            @PathVariable Integer subscriptionId,
            @RequestBody UpdateStoreSubscriptionRequest subscription
    ) throws Exception {
        return subscriptionService.updateStoreSubscription(storeId, subscriptionId, subscription);
    }

    // 상점 월가맹비 입금 취소 처리
    @DeleteMapping(value = "/stores/{storeId}/subscriptions/{subscriptionId}")
    public Subscription deleteStoreSubscription(
            @PathVariable Integer storeId,
            @PathVariable Integer subscriptionId
    ) throws Exception {
        return subscriptionService.deleteStoreSubscription(storeId, subscriptionId);
    }

    // 상점 가맹비 잔액 내역 조회
    @GetMapping(value = "/stores/{storeId}/deposits")
    public StoreDepositList getStoreDepositList(
            @PathVariable Integer storeId,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page
    ) throws Exception {
        return subscriptionService.getStoreDepositList(
                storeId,
                size,
                page
        );
    }

    // 상점 가맹비 잔액 변경
    @PutMapping(value = "/stores/{storeId}/deposits")
    public StoreDepositList updateStoreDeposit(
            @PathVariable Integer storeId,
            @RequestBody UpdateStoreDepositRequest storeDeposit
    ) throws Exception {
        return subscriptionService.updateStoreDeposit(
                storeId,
                storeDeposit
        );
    }
}
