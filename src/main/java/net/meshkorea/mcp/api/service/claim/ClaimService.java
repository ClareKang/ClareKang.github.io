package net.meshkorea.mcp.api.service.claim;

import com.google.gson.Gson;
import com.vroong.lastmile.api.LastmileManagerOrderApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerFindOrdersRes;
import com.vroong.lastmile.api.client.model.ManagerGetOrderDetailReq;
import com.vroong.lastmile.api.client.model.ManagerGetOrderDetailRes;
import com.vroong.lastmile.api.client.model.OrderDto;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import net.meshkorea.mcp.api.domain.dao.ClaimDao;
import net.meshkorea.mcp.api.domain.model.claim.*;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;
import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by reverof on 2017. 3. 24..
 */
@Service
public class ClaimService {

    @Autowired
    private ClaimDao claimDao;

    @Autowired
    private LastmileManagerOrderApi lastmileManagerOrderApi;

    @Autowired
    LastmileTokenService lastmileTokenService;

    @Autowired

    private OAuthUserService oAuthUserService;

    @Transactional
    public ClaimDetailResponse getClaimDetail(Long claimNo) throws ApiException {
        ClaimDetail claimDetail = new ClaimDetail();
        Claim claim = claimDao.getClaimDetail(claimNo);
        claimDetail.setClaim(claim);
        claimDetail.setOrder(setOrderDto(claim.getOrderId()));
        claimDetail.setClaimOrder(setOrderDto(claim.getClaimOrderId()));
        claimDetail.setClaimDescriptions(claimDao.getClaimDescription(claim.getOrderId()));
        claimDetail.setClaimAdjustment(claimDao.getClaimAdjustment(claim.getOrderId()));

        return new ClaimDetailResponse(claimDetail);
    }

    public OrderDto setOrderDto(Long orderId) throws ApiException {
        ManagerGetOrderDetailReq vroongReq = new ManagerGetOrderDetailReq();
        vroongReq.setOrderId(orderId);
        ManagerGetOrderDetailRes orderDto = lastmileManagerOrderApi.getOrderDetailUsingPOST1(lastmileTokenService.getAuthToken(), vroongReq);
        return orderDto.getOrder();
    }

    @Transactional
    public ClaimHistoryResponse getClaimHistory(Long claimNo) {
        return new ClaimHistoryResponse(claimDao.getClaimHistory(claimNo));
    }

    @Transactional
    public ClaimAdjustmentHistoryResponse getClaimAdjustmentHistory(Long orderId) {
        return new ClaimAdjustmentHistoryResponse(claimDao.getClaimAdjustmentHistory(orderId));
    }

    @Transactional
    public ClaimListResponse findClaims(ClaimSearchDto claimSearchDto) throws ApiException {
        ClaimListResponse returnObj = new ClaimListResponse();
        ClaimCount claimCount = new ClaimCount();
        List<ClaimList> list = new ArrayList<>();

                claimCount.setAccept(0);
        claimCount.setInProgress(0);
        claimCount.setHold(0);
        claimCount.setResolve(0);
        claimCount.setRetraction(0);
        claimCount.setTransfer(0);
        claimCount.setUnprocessed(0);

        if ("originOrderNumber".equals(claimSearchDto.getSearchType())
                || "claimNo".equals(claimSearchDto.getSearchType())
                || "claimOrderNumber".equals(claimSearchDto.getSearchType())
                || claimSearchDto.getSearchString().isEmpty()
                || claimSearchDto.getSearchType().isEmpty()) {
        } else {
            ManagerFindOrdersRes response = new ManagerFindOrdersRes();
            response = lastmileManagerOrderApi.findOrdersUsingPOST(lastmileTokenService.getAuthToken(), claimSearchDto.getRequest());
            List<Long> orderIds = new ArrayList<>();
            for (OrderDto o : response.getOrders()) {
                orderIds.add(o.getId());
            }
            if (response.getOrders().size() >= 100) {
                IntraErrorDto intraErrorDto = new IntraErrorDto(HttpStatus.NO_CONTENT, "해당 조건의 오더가 100건을 초과하여 조회가 불가능합니다. 조회 조건을 좀더 상세히 입력하여 재시도하세요.");
                return new ClaimListResponse(intraErrorDto);
            } else if (response.getOrders().size() == 0) {
                returnObj.setData(list);
                returnObj.setClaimCount(claimCount);
                return returnObj;
            }
            claimSearchDto.setOrderIds(orderIds);
        }
        list = claimDao.findClaims(claimSearchDto);
        returnObj.setData(list);



        for(ClaimList item: list) {
            switch (item.getStatusCode()){
                case "ACCEPT":
                    claimCount.setAccept(claimCount.getAccept() + 1);
                    break;
                case "IN_PROGRESS":
                    claimCount.setInProgress(claimCount.getInProgress() + 1);
                    break;
                case "HOLD":
                    claimCount.setHold(claimCount.getHold() + 1);
                    break;
                case "RESOLVE":
                    claimCount.setResolve(claimCount.getResolve() + 1);
                    break;
                case "RETRACTION":
                    claimCount.setRetraction(claimCount.getRetraction() + 1);
                    break;
                case "TRANSFER":
                    claimCount.setTransfer(claimCount.getTransfer() + 1);
                    break;
                case "UNPROCESSED":
                    claimCount.setUnprocessed(claimCount.getUnprocessed() + 1);
                    break;
            }
        }
        returnObj.setClaimCount(claimCount);
        return returnObj;
    }

    @Transactional
    public CreateClaimResponse createClaim(CreateClaimRequest request) throws ApiException {
        request.setCreator(oAuthUserService.getCurrentUser().getId());
        request.setUpdater(oAuthUserService.getCurrentUser().getId());
        request.setCreateDt(convertDateTime());
        request.setUpdateDt(convertDateTime());
        System.out.println(request.toString());
        int claimNo = claimDao.createClaim(request);
        ClaimDetail claimRes = new ClaimDetail();
        int result = claimDao.createOrderClaimRelation(request);
        if (result > 0) {
            Claim beforeUpdateClaim = claimDao.getClaimDetail(request.getClaimNo());
            beforeUpdateClaim.setUpdateDt(beforeUpdateClaim.getUpdateDt());
            insertClaimHistory(beforeUpdateClaim);
            claimRes.setClaim(beforeUpdateClaim);
            claimRes.setOrder(setOrderDto(request.getOrderId()));
            claimRes.setClaimOrder(setOrderDto(request.getClaimOrderId()));
        }
        return new CreateClaimResponse(claimRes);
    }

    @Transactional
    public UpdateClaimResponse updateClaim(UpdateClaimRequest request) {
        request.setUpdater(oAuthUserService.getCurrentUser().getId());
        request.setUpdateDt(convertDateTime());
        claimDao.updateClaim(request);
        claimDao.updateOrderClaimRelation(request);
        Claim beforeUpdateClaim = claimDao.getClaimDetail(request.getClaimInfo().getClaimNo());
        insertClaimHistory(beforeUpdateClaim);

        return new UpdateClaimResponse(request);
    }

    public String convertDateTime() {
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
        return formatter.format(date);
    }

    public void insertClaimHistory(Claim claim) {
        Gson gson = new Gson();
        ClaimHistory history = new ClaimHistory();
        history.setOrderId(claim.getOrderId());
        history.setClaimNo(claim.getClaimNo());
        history.setCreator(oAuthUserService.getCurrentUser().getId());
        history.setJsonString(gson.toJson(claim));
        history.setCreateDt(convertDateTime());
        claimDao.insertClaimHistory(history);
    }

    public void insertAdjustmentHistory(ClaimAdjustment claimAdjustment) {
        Gson gson = new Gson();
        ClaimAdjustmentHistory history = new ClaimAdjustmentHistory();
        history.setClaimAdjustmentNo(claimAdjustment.getClaimAdjustmentNo());
        history.setCreator(oAuthUserService.getCurrentUser().getId());
        history.setJsonString(gson.toJson(claimAdjustment));
        history.setCreateDt(convertDateTime());
        claimDao.insertAdjustmentHistory(history);
    }

    @Transactional
    public UpdateClaimDescriptionResponse updateDescription(UpdateClaimDescriptionRequest request) {
        request.setCreator(oAuthUserService.getCurrentUser().getId());
        request.setCreateDt(convertDateTime());
        claimDao.updateDescription(request);
        List<ClaimDescriptionDto> claimList = claimDao.getClaimDescription(request.getOrderId());
        return new UpdateClaimDescriptionResponse(claimList);
    }

    @Transactional
    public ClaimDescriptionCountResponse getDescriptionCount(Long orderId) {
        return new ClaimDescriptionCountResponse(claimDao.getClaimDescription(orderId).size());
    }

    @Transactional
    public ClaimDescriptionResponse getDescription(Long orderId) {
        return new ClaimDescriptionResponse(claimDao.getClaimDescription(orderId));
    }

    @Transactional
    public ClaimAdjustmentResponse getAdjustment(Long orderId) {
        return new ClaimAdjustmentResponse(claimDao.getClaimAdjustment(orderId));
    }

    @Transactional
    public CreateClaimAdjustmentResponse createClaimAdjustment(CreateClaimAdjustmentRequest request) {
        String dateString = convertDateTime();
        request.setCreator(oAuthUserService.getCurrentUser().getId());
        request.setUpdater(oAuthUserService.getCurrentUser().getId());
        request.setCreateDt(dateString);
        request.setUpdateDt(dateString);
        claimDao.createClaimAdjustment(request);
        ClaimAdjustment beforeUpdateClaimAdjustment = claimDao.getClaimAdjustment(request.getOrderId());
        insertAdjustmentHistory(beforeUpdateClaimAdjustment);
        return new CreateClaimAdjustmentResponse(claimDao.getClaimAdjustment(request.getOrderId()));
    }

    @Transactional
    public UpdateClaimAdjustmentResponse updateClaimAdjustment(UpdateClaimAdjustmentRequest request) {
        request.setCreator(oAuthUserService.getCurrentUser().getId());
        request.setUpdater(oAuthUserService.getCurrentUser().getId());
        request.setUpdateDt(convertDateTime());
        claimDao.updateClaimAdjustment(request);
        ClaimAdjustment beforeUpdateClaimAdjustment = claimDao.getClaimAdjustment(request.getOrderId());
        insertAdjustmentHistory(beforeUpdateClaimAdjustment);
        return new UpdateClaimAdjustmentResponse(claimDao.getClaimAdjustment(request.getOrderId()));
    }

    @Transactional
    public ClaimReasonCodeResponse getClaimReasonCode() {

        String key = "";
        List<ClaimReasonCode> claimReasonCode = claimDao.getClaimReasonCode();
        List<ClaimReasonCodeForConvert> list = new ArrayList<>();

        for (int i = 0; i < claimReasonCode.size(); i++) {
            if (!key.equals(claimReasonCode.get(i).getParentCode())) {
                key = claimReasonCode.get(i).getParentCode();
                ClaimReasonCodeForConvert reason = new ClaimReasonCodeForConvert();
                List<ClaimCode> child = new ArrayList<>();
                ClaimCode parent = new ClaimCode();
                parent.setCode(claimReasonCode.get(i).getParentCode());
                parent.setCodeName(claimReasonCode.get(i).getParentCodeName());
                reason.setParent(parent);
                for (int j = i; j < claimReasonCode.size(); j++) {
                    if (key.equals(claimReasonCode.get(j).getParentCode())) {
                        ClaimCode childCode = new ClaimCode();
                        childCode.setCode(claimReasonCode.get(j).getChildCode());
                        childCode.setCodeName(claimReasonCode.get(j).getChildCodeName());
                        child.add(childCode);
                    } else {
                        break;
                    }
                }
                reason.setChild(child);
                list.add(reason);
            }
        }

        return new ClaimReasonCodeResponse(list);
    }

    @Transactional
    public ClaimCodeResponse getClaimCode(String code) {
        return new ClaimCodeResponse(claimDao.getClaimCode(code));
    }
}
