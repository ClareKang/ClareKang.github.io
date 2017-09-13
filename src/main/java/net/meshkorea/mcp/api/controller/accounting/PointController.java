package net.meshkorea.mcp.api.controller.accounting;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import net.meshkorea.mcp.api.config.excel.ExcelConfig;
import net.meshkorea.mcp.api.domain.model.store.CheckStoreName;
import net.meshkorea.mcp.api.service.accounting.PointService;
import net.meshkorea.mcp.api.service.business.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by clare on 9/13/17.
 */
@RestController
@RequestMapping(value = "/v1/intra")
public class PointController {

    @Autowired
    PointService pointService;

    // 예치금 대분류 목록
    @GetMapping(path = "/points/categories")
    public List<PointCategory> getPointCategory() throws ApiException {
        return pointService.getPointCategory();
    }

    // 예치금 소분류 목록
    @GetMapping(path = "/points/subcategories")
    public List<PointSubcategory> getPointSubategory() throws ApiException {
        return pointService.getPointSubategory();
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
        return pointService.getPointHistory(from, to, subcategory, searchKey, searchValue, isDebit, page, size);
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
        PointHistoryList list = pointService.getPointHistory(from, to, subcategory, searchKey, searchValue, isDebit, page, size);
        List<String> headers = pointService.excelPointHistoryHeader();
        List<List<String>> body = pointService.excelPointHistoryBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, pointService.excelPointHistoryFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 예치금 츙전 내역 조회
    @GetMapping(path = "/points/deposits")
    public PointDeposit getPointDeposit(
            String pointTransactionId
    ) throws ApiException {
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
            String balanceStatusId,
            Integer size,
            Integer page
    ) throws ApiException {
        return pointService.getPointAccount(clientSearchKey, clientSearchValue, sortDirection, sortColumn, pointAccountIsUsed, balanceStatusId, size, page);
    }

    // 예치금 계좌 조회 엑셀 다운로드
    @GetMapping(path = "/points/accounts/excel")
    public ModelAndView downloadPointAccountToExcel(
            @RequestParam(required = false) String clientSearchKey,
            @RequestParam(required = false) String clientSearchValue,
            @RequestParam(required = false) String sortDirection,
            @RequestParam(required = false) String sortColumn,
            @RequestParam(required = false) Boolean pointAccountIsUsed,
            @RequestParam(required = false) String balanceStatusId,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page,
            ModelAndView mav
    ) throws Exception {
        PointAccountList list = pointService.getPointAccount(clientSearchKey, clientSearchValue, sortDirection, sortColumn, pointAccountIsUsed, balanceStatusId, size, page);
        List<String> headers = pointService.excelPointAccountHeader();
        List<List<String>> body = pointService.excelPointAccountBodies(list);

        mav.addObject(ExcelConfig.FILE_NAME, pointService.excelPointAccountFileName());
        mav.addObject(ExcelConfig.HEAD, headers);
        mav.addObject(ExcelConfig.BODY, body);
        mav.setViewName("excelXlsxView");

        return mav;
    }

    // 예치금 조정 내역 목록
    @GetMapping(path = "/points/adjustments")
    public PointAdjustmentList getPointAdjustment(
            String from,
            String to,
            String subcategories,
            String adjustingSearchKey,
            String adjustingSearchValue,
            String isDebit,
            Integer size,
            Integer page
    ) throws ApiException {
        return pointService.getPointAdjustment(from, to, subcategories, adjustingSearchKey, adjustingSearchValue, isDebit, size, page);
    }

    // 예치금 조정 내역 엑셀 다운로드
    @GetMapping(path = "/points/adjustments/excel")
    public ModelAndView downloadPointAdjustmentToExcel(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) String subcategories,
            @RequestParam(required = false) String adjustingSearchKey,
            @RequestParam(required = false) String adjustingSearchValue,
            @RequestParam(required = false) String isDebit,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page,
            ModelAndView mav
    ) throws Exception {
        PointAdjustmentList list = pointService.getPointAdjustment(from, to, subcategories, adjustingSearchKey, adjustingSearchValue, isDebit, size, page);
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
    public SuccessResult createPointAdjustment(
            CreatePointAdjustmentRequest req
    ) throws ApiException {
        return pointService.createPointAdjustment(req);
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

}
