package net.meshkorea.mcp.api.service.claim;

import com.vroong.lastmile.api.LastmileManagerOrderApi;
import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerFindOrdersRes;
import com.vroong.lastmile.api.client.model.ManagerGetOrderDetailReq;
import com.vroong.lastmile.api.client.model.ManagerGetOrderDetailRes;
import com.vroong.lastmile.api.client.model.OrderDto;
import com.vroong.lastmile.service.auth.LastmileTokenService;
import net.meshkorea.mcp.api.dao.ClaimDao;
import net.meshkorea.mcp.api.domain.model.claim.*;
import net.meshkorea.mcp.api.domain.repository.ClaimMapper;
import net.meshkorea.mcp.api.domain.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by reverof on 2017. 3. 24..
 */
@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ClaimDao claimDao;

    @Autowired
    private LastmileManagerOrderApi lastmileManagerOrderApi;

    @Autowired
    LastmileTokenService lastmileTokenService;


    @Transactional
    public ClaimDetail getClaimDetail(Long claimNo) throws ApiException {
        ClaimDetail claimDetail = new ClaimDetail();
        Claim claim = claimDao.getClaimDetail(claimNo);
        claimDetail.setClaim(claim);
        claimDetail.setOrder(setOrderDto(claim.getOrderId()));
        claimDetail.setClaimOrder(setOrderDto(claim.getClaimOrderId()));
        claimDetail.setClaimDescriptions(claimDao.getClaimDescription(claimNo));
        claimDetail.setClaimAdjustment(claimDao.getClaimAdjustment(claimNo));

        return claimDetail;
    }

    @Transactional
    public void removeClaim(Claim claim) {
        claimRepository.delete(claim.getClaimNo());
    }

    @Transactional
    public void removeClaim(Long claimNo) {
        claimRepository.delete(claimNo);
    }

    @Transactional
    public List<ClaimRes> findClaims(ClaimSearchDto claimSearchDto) {
        System.out.println(claimSearchDto.toString());
        return claimDao.findClaims(claimSearchDto);
    }

    @Transactional
    public CreateClaimRes createClaim(CreateClaimReq req) throws ApiException {
        req.setCreator("sungjae.hong");
        int claimNo = claimDao.createClaim(req);
        CreateClaimRes claimRes = new CreateClaimRes();
        System.out.println(claimNo);

        int result = claimDao.createOrderClaimRelation(req);

        if(result >0 ) {
            claimRes.setOrder(setOrderDto(req.getOrderId()));
            claimRes.setClaimOrder(setOrderDto(req.getClaimOrderId()));
        }
        return claimRes;
    }

    public OrderDto setOrderDto(Long orderId) throws ApiException {
        ManagerGetOrderDetailReq vroongReq = new ManagerGetOrderDetailReq();
        vroongReq.setOrderId(orderId);
        ManagerGetOrderDetailRes orderDto = lastmileManagerOrderApi.getOrderDetailUsingPOST1(lastmileTokenService.getAuthToken(), vroongReq);
        return orderDto.getOrder();
    }
    @Transactional
    public int updateClaim(UpdateClaimReq req) throws ApiException{
        return claimDao.updateClaim(req);
    }
}
