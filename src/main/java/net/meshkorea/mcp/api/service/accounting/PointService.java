package net.meshkorea.mcp.api.service.accounting;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.*;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by clare on 9/13/17.
 */
@Service
public class PointService {
    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraPointApi intraPointApi;

    // 예치금 대분류 목록
    public List<PointCategory> getPointCategory() throws ApiException {
        return intraPointApi.getPointCategory(intraTokenService.getAuthToken());
    }

    // 예치금 소분류 목록
    public List<PointSubcategory> getPointSubategory() throws ApiException {
        return intraPointApi.getPointSubcategory(intraTokenService.getAuthToken());
    }

    // 예치금 상태 목록
    public List<PointBalanceStatus> getPointBalanceStatus() throws ApiException {
        return intraPointApi.getPointBalanceStatus(intraTokenService.getAuthToken());
    }

    // 예치금 내역 목록 조회
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
        return intraPointApi.getPointHistory(intraTokenService.getAuthToken(), from, to, subcategory, searchKey, searchValue, isDebit, page, size);
    }

    // 예치금 내역 엑셀다운로드 ------------------------------------------
    public List<String> excelPointHistoryHeader() {
        List<String> result = new ArrayList<>();
        result.add("거래번호");
        result.add("본사명");
        result.add("본사코드");
        result.add("상점명");
        result.add("상점코드");
        result.add("일시");
        result.add("대분류");
        result.add("소분류");
        result.add("적립/차감");
        result.add("금액");
        result.add("거래 후 잔액");
        result.add("관련번호");
        return result;
    }

    public List<List<String>> excelPointHistoryBodies(PointHistoryList pointHistoryList) throws Exception {
        List<List<String>> result = new ArrayList<>();
        pointHistoryList.getData().forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getPointTransactionId().toString());
            row.add(item.getClientName());
            row.add(item.getBusinessOwnerId().toString());
            row.add(item.getStoreName());
            row.add(item.getStoreId().toString());
            row.add(item.getCreatedAt());
            row.add(item.getCategory());
            row.add(item.getSubCategory());
            row.add(item.getAmount().toString());
            row.add(item.getAfterBalance().toString());
            row.add(item.getReference());
            result.add(row);
        });
        return result;
    }

    public String excelPointHistoryFileName() {
        return "예치금_내역_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    // 예치금 단일 내역 조회
    public PointDeposit getPointDeposit(
            String pointTransactionId
    ) throws ApiException {
        return intraPointApi.getPointDeposit(intraTokenService.getAuthToken(), pointTransactionId);
    }

    // 예치금 계좌 조회
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
        return intraPointApi.getPointAccount(intraTokenService.getAuthToken(), clientSearchKey, clientSearchValue, sortDirection, sortColumn, pointAccountIsUsed, balanceStatusId, page, size);
    }

    // 예치금 계좌 엑셀다운로드 ------------------------------------------
    public List<String> excelPointAccountHeader() {
        List<String> result = new ArrayList<>();
        result.add("본사명");
        result.add("본사코드");
        result.add("가상계좌 은행");
        result.add("가상계좌 번호");
        result.add("예치금 잔액");
        result.add("대상 상점");
        result.add("최근 거래 발생 시점");
        result.add("미수금 발생 시점");
        result.add("예치금 사용");
        result.add("예치금 상태");
        return result;
    }

    public List<List<String>> excelPointAccountBodies(PointAccountList pointAccountList) throws Exception {
        List<List<String>> result = new ArrayList<>();
        pointAccountList.getData().forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getClientName());
            row.add(item.getBusinessOwnerId().toString());
            row.add(item.getBankName());
            row.add(item.getVirtualBankAccountNumber());
            row.add(item.getBalance().toString());
            row.add(item.getStoresCount().toString());
            row.add(item.getLatestTransactionCreatedAt());
            row.add(item.getBelowThresholdAt());
            row.add(item.getPointAccountIsUsed() ? "사용" : "미사용");
            row.add(item.getBalanceStatus());
            result.add(row);
        });
        return result;
    }

    public String excelPointAccountFileName() {
        return "예치금_계좌_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    // 예치금 조정 내역 목록
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
        return intraPointApi.getPointAdjustment(intraTokenService.getAuthToken(), from, to, subcategories, adjustingSearchKey, adjustingSearchValue, isDebit, size, page);
    }

    // 예치금 조정 내역 엑셀다운로드 ------------------------------------------
    public List<String> excelPointAdjustmentHeader() {
        List<String> result = new ArrayList<>();
        result.add("거래번호");
        result.add("본사명");
        result.add("상점명");
        result.add("일시");
        result.add("대분류");
        result.add("소분류");
        result.add("적립/차감");
        result.add("금액");
        result.add("거래 후 잔액");
        result.add("관련번호");
        result.add("처리자");
        result.add("신청자");
        return result;
    }

    public List<List<String>> excelPointAdjustmentBodies(PointAdjustmentList pointAdjustmentList) throws Exception {
        List<List<String>> result = new ArrayList<>();
        pointAdjustmentList.getData().forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(item.getPointTransactionId().toString());
            row.add(item.getClientName());
            row.add(item.getStoreName());
            row.add(item.getCreatedAt());
            row.add(item.getCategory());
            row.add(item.getSubcategory());
            row.add(item.getIsDebit() ? "차감" : "적립");
            row.add(item.getAmount().toString());
            row.add(item.getAfterBalance().toString());
            row.add(item.getReference());
            row.add(item.getConfirmedBy());
            row.add(item.getIssuedBy());
            result.add(row);
        });
        return result;
    }

    public String excelPointAdjustmentFileName() {
        return "예치금_조정_내역_" + DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
    }

    // 예치금 조정 내역 생성
    public SuccessResult createPointAdjustment(
            CreatePointAdjustmentRequest req
    ) throws ApiException {
        return intraPointApi.createPointAdjustment(intraTokenService.getAuthToken(), req);
    }

    // 예치금 조정 오더번호 Look Up
    public PointAdjustmentDeliveryLookUp getPointAdjustmentDeliveryLookUp(String vroongOrderNumber) throws ApiException {
        return intraPointApi.getPointAdjustmentDeliveryLookUp(intraTokenService.getAuthToken(), vroongOrderNumber);
    }

    // 예치금 조정 가맹비 Look Up
    public PointAdjustmentSubscriptionLookUp getPointAdjustmentSubscriptionLookUp(String storeId) throws ApiException {
        return intraPointApi.getPointAdjustmentSubscriptionLookUp(intraTokenService.getAuthToken(), storeId);
    }

}
