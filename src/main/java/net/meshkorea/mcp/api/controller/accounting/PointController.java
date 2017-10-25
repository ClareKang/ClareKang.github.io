package net.meshkorea.mcp.api.controller.accounting;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.domain.model.store.CheckStoreName;
import net.meshkorea.mcp.api.service.accounting.PointService;
import net.meshkorea.mcp.api.service.business.VirtualBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by clare on 9/13/17.
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class PointController {

    @Autowired
    PointService pointService;

    @Autowired
    VirtualBankAccountService virtualBankAccountService;

    // 예치금 대분류 목록
    @GetMapping(path = "/points/categories")
    public List<PointCategory> getPointCategory() throws ApiException {
        return pointService.getPointCategory();
    }

    // 예치금 소분류 목록
    @GetMapping(path = "/points/subcategories")
    public List<PointSubcategory> getPointSubcategory() throws ApiException {
        return pointService.getPointSubcategory();
    }

    // 예치금 상태 목록
    @GetMapping(path = "/points/balance_status")
    public List<PointBalanceStatus> getPointBalanceStatus() throws ApiException {
        return pointService.getPointBalanceStatus();
    }

    // 예치금 내역 목록 조회
    @GetMapping(path = "/points/history")
    public PointHistoryList getPointHistory(
            String from,
            String to,
            String subcategory,
            String searchKey,
            String searchValue,
            String isDebit,
            Integer size,
            Integer page
    ) throws ApiException {
        PointHistoryList list = pointService.getPointHistory(from, to, subcategory, searchKey, searchValue, isDebit, size, page);
        setExternalInformationInPointHistory(list.getData());

        return list;
    }

    // 예치금 내역 엑셀 다운로드
    @GetMapping(path = "/points/history/excel")
    public ModelAndView downloadPointHistoryToExcel(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String subcategory,
            @RequestParam(required = false) String searchKey,
            @RequestParam(required = false) String searchValue,
            @RequestParam(required = false) String isDebit,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page,
            ModelAndView mav
    ) throws Exception {
        PointHistoryList list = pointService.getPointHistory(from, to, subcategory, searchKey, searchValue, isDebit, size, page);
        setExternalInformationInPointHistory(list.getData());
        List<String> headers = pointService.excelPointHistoryHeader();
        List<List<String>> body = pointService.excelPointHistoryBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, pointService.excelPointHistoryFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 예치금 내역 조회
    @PostMapping(path = "/points/transaction_amounts")
    public List<PointTransactionAmount> getPointTransactionAmount(GetPointTransactionAmountsRequest req) throws ApiException {
        return pointService.getPointTransactionAmounts(req);
    }

    // 예치금 츙전 내역 조회
    @GetMapping(path = "/points/deposits")
    public PointDeposit getPointDeposit(Integer pointTransactionId) throws ApiException {
        return pointService.getPointDeposit(pointTransactionId);
    }

    // 예치금 계좌 조회
    @GetMapping(path = "/points/accounts")
    public PointAccountList getPointAccount(
            String clientSearchKey,
            String clientSearchValue,
            String sortDirection,
            String sortColumn,
            Boolean pointAccountIsUsed,
            String balanceStatusIds,
            Integer size,
            Integer page
    ) throws ApiException {
        PointAccountList list = pointService.getPointAccount(clientSearchKey, clientSearchValue, sortDirection, sortColumn, pointAccountIsUsed, balanceStatusIds, size, page);
        setExternalInformationInPointAccount(list.getData());

        return list;
    }

    // 예치금 계좌 조회 엑셀 다운로드
    @GetMapping(path = "/points/accounts/excel")
    public ModelAndView downloadPointAccountToExcel(
            @RequestParam(required = false) String clientSearchKey,
            @RequestParam(required = false) String clientSearchValue,
            @RequestParam(required = false) String sortDirection,
            @RequestParam(required = false) String sortColumn,
            @RequestParam(required = false) Boolean pointAccountIsUsed,
            @RequestParam(required = false) String balanceStatusIds,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page,
            ModelAndView mav
    ) throws Exception {
        PointAccountList list = pointService.getPointAccount(clientSearchKey, clientSearchValue, sortDirection, sortColumn, pointAccountIsUsed, balanceStatusIds, size, page);
        setExternalInformationInPointAccount(list.getData());
        List<String> headers = pointService.excelPointAccountHeader();
        List<List<String>> body = pointService.excelPointAccountBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, pointService.excelPointAccountFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 예치금 잔액 조회
    @PostMapping(path = "/points/balances")
    public List<PointBalance> getPointBalance(GetPointBalanceRequest req) throws ApiException {
        return pointService.getPointBalance(req);
    }

    // 예치금 조정 내역 목록
    @GetMapping(path = "/points/adjustments")
    public PointAdjustmentList getPointAdjustment(
            String from,
            String to,
            String subcategories,
            String adjustmentSearchKey,
            String adjustmentSearchValue,
            String isDebit,
            Integer size,
            Integer page
    ) throws ApiException {
        return pointService.getPointAdjustment(from, to, subcategories, adjustmentSearchKey, adjustmentSearchValue, isDebit, size, page);
    }

    // 예치금 조정 내역 엑셀 다운로드
    @GetMapping(path = "/points/adjustments/excel")
    public ModelAndView downloadPointAdjustmentToExcel(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String subcategories,
            @RequestParam(required = false) String adjustmentSearchKey,
            @RequestParam(required = false) String adjustmentSearchValue,
            @RequestParam(required = false) String isDebit,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page,
            ModelAndView mav
    ) throws Exception {
        PointAdjustmentList list = pointService.getPointAdjustment(from, to, subcategories, adjustmentSearchKey, adjustmentSearchValue, isDebit, size, page);
        List<String> headers = pointService.excelPointAdjustmentHeader();
        List<List<String>> body = pointService.excelPointAdjustmentBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, pointService.excelPointAdjustmentFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 예치금 조정 내역 생성
    @PostMapping(path = "/points/adjustments")
    public void createPointAdjustment(CreatePointAdjustmentRequest req) throws ApiException {
        pointService.createPointAdjustment(req);
    }

    // 예치금 조정 내역 상세
    @GetMapping(path = "/points/adjustments/id")
    public PointAdjustmentDetail getPointAdjustmentDetail(@PathVariable Integer id) throws ApiException {
        return pointService.getPointAdjustmentDetail(id);
    }

    // 예치금 조정 오더번호 Look Up
    @GetMapping(path = "/points/adjustment/delivery_lookup")
    public PointAdjustmentDeliveryLookUp getPointAdjustmentDeliveryLookUp(String vroongOrderNumber) throws ApiException {
        return pointService.getPointAdjustmentDeliveryLookUp(vroongOrderNumber);
    }

    // 예치금 조정 가맹비 Look Up
    @GetMapping(path = "/points/adjustments/subscription_lookup")
    public PointAdjustmentSubscriptionLookUp getPointAdjustmentSubscriptionLookUp(String storeId) throws ApiException {
        return pointService.getPointAdjustmentSubscriptionLookUp(storeId);
    }

    private void setExternalInformationInPointHistory(List<PointHistory> list) throws ApiException {
        if(!list.isEmpty()) {
            List<Integer> pointTransactionIds = list.stream().map(d -> d.getPointTransactionId()).collect(Collectors.toList());

            // get PointTransactionAmount list
            List<PointTransactionAmount> pointTransactionAmountList = pointService.getPointTransactionAmounts(
                    new GetPointTransactionAmountsRequest().pointTransactionIds(pointTransactionIds));

            for(PointHistory history : list) {
                PointTransactionAmount pointTransactionAmount = pointTransactionAmountList.stream()
                        .filter(p -> p.getPointTransactionId() == history.getPointTransactionId()).findFirst().orElse(null);

                if(pointTransactionAmount != null) {
                    history.setAmount(pointTransactionAmount.getAmount());
                    history.setAfterBalance(pointTransactionAmount.getAfterBalance());
                }
            }
        }
    }

    private void setExternalInformationInPointAccount(List<PointAccount> list) throws ApiException {
        if(!list.isEmpty()) {
            List<Integer> businessOwnerIds = list.stream().map(d -> d.getBusinessOwnerId()).collect(Collectors.toList());

            // get VirtualBankAccount list
            List<BusinessClientVirtualBankAccount> virtualBankAccountList = virtualBankAccountService.getVirtualBankAccountsByBusinessClientIds(
                    new GetBusinessClientVirtualBankAccountsRequest().businessOwnerIds(businessOwnerIds));

            // get PointBalance list
            List<PointBalance> balanceList = pointService.getPointBalance(
                    new GetPointBalanceRequest().businessOwnerIds(businessOwnerIds));

            // combine two list in PointAccount list
            for(PointAccount account : list) {
                BusinessClientVirtualBankAccount virtualBankAccount = virtualBankAccountList.stream()
                        .filter(v -> v.getBusinessOwnerId() == account.getBusinessOwnerId()).findFirst().orElse(null);
                PointBalance balance = balanceList.stream()
                        .filter(b -> b.getBusinessOwnerId() == account.getBusinessOwnerId()).findFirst().orElse(null);

                if(virtualBankAccount != null) {
                    account.setVirtualBankAccountNumber(virtualBankAccount.getVirtualBankAccountNumber());
                    account.setBankName(virtualBankAccount.getBankName());
                }
                if(balance != null) {
                    account.setBalance(balance.getBalance());
                }
            }
        }
    }
}
