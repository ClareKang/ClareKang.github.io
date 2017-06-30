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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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


    @Transactional
    public ClaimDetailResponse getClaimDetail(Long claimNo) throws ApiException {
        ClaimDetail claimDetail = new ClaimDetail();
        Claim claim = claimDao.getClaimDetail(claimNo);
        claimDetail.setClaim(claim);
        claimDetail.setOrder(setOrderDto(claim.getOrderId()));
        claimDetail.setClaimOrder(setOrderDto(claim.getClaimOrderId()));
        claimDetail.setClaimDescriptions(claimDao.getClaimDescription(claimNo));
        claimDetail.setClaimAdjustment(claimDao.getClaimAdjustment(claimNo));
        claimDetail.setClaimDescriptions(claimDao.getClaimDescription(claimNo));
        claimDetail.setClaimAdjustment(claimDao.getClaimAdjustment(claimNo));

        return new ClaimDetailResponse(claimDetail);
    }

    public OrderDto setOrderDto(Long orderId) throws ApiException {
        ManagerGetOrderDetailReq vroongReq = new ManagerGetOrderDetailReq();
        vroongReq.setOrderId(orderId);
        ManagerGetOrderDetailRes orderDto = lastmileManagerOrderApi.getOrderDetailUsingPOST1(lastmileTokenService.getAuthToken(), vroongReq);
        return orderDto.getOrder();
    }


    @Transactional
    public ClaimListResponse findClaims(ClaimSearchDto claimSearchDto) throws ApiException {

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
                IntraErrorDto intraErrorDto = new IntraErrorDto(HttpStatus.NO_CONTENT, "해당 조건의 오더가 없습니다. 조회 조건을 변경해서 재시도하세요.");
                return new ClaimListResponse(intraErrorDto);
            }
            claimSearchDto.setOrderIds(orderIds);
        }
        List<ClaimList> list = claimDao.findClaims(claimSearchDto);

        return new ClaimListResponse(list);
    }

    @Transactional
    public CreateClaimResponse createClaim(CreateClaimRequest request) throws ApiException {
        request.setCreator("sungjae.hong");
        int claimNo = claimDao.createClaim(request);
        ClaimDetail claimRes = new ClaimDetail();

        int result = claimDao.createOrderClaimRelation(request);

        if (result > 0) {
            claimRes.setOrder(setOrderDto(request.getOrderId()));
            claimRes.setClaimOrder(setOrderDto(request.getClaimOrderId()));
        }
        return new CreateClaimResponse(claimRes);
    }


    @Transactional
    public UpdateClaimResponse updateClaim(UpdateClaimRequest request) {
        Claim beforeUpdateClaim = claimDao.getClaimDetail(request.getClaimInfo().getClaimNo());
        Gson gson = new Gson();
        ClaimHistory history = new ClaimHistory();
        history.setOrderId(beforeUpdateClaim.getOrderId());
        history.setClaimNo(beforeUpdateClaim.getClaimNo());
        history.setCreator("sungjae.hong");
        history.setJsonString(gson.toJson(beforeUpdateClaim));
        claimDao.insertClaimHistory(history);
        claimDao.updateClaim(request);

        return new UpdateClaimResponse(request);
    }

    @Transactional
    public UpdateClaimDescriptionResponse updateDescription(UpdateClaimDescriptionRequest request) {
        claimDao.updateDescription(request);
        List<ClaimDescriptionDto> claimList = claimDao.getClaimDescription(request.getClaimNo());
        return new UpdateClaimDescriptionResponse(claimList);
    }

    @Transactional
    public UpdateClaimAdjustmentResponse updateClaimAdjustment(UpdateClaimAdjustmentRequest request) {
        ClaimAdjustment beforeUpdateClaimAdjustment = claimDao.getClaimAdjustment(request.getClaimNo());
        Gson gson = new Gson();
        ClaimAdjustmentHistory history = new ClaimAdjustmentHistory();
        history.setClaimAdjustmentNo(beforeUpdateClaimAdjustment.getClaimAdjustmentNo());
        history.setCreator("sungjae.hong");
        history.setJsonString(gson.toJson(beforeUpdateClaimAdjustment));
        claimDao.updateClaimAdjustment(request);

        return new UpdateClaimAdjustmentResponse();
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
