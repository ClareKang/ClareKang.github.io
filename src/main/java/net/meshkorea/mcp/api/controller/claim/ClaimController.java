package net.meshkorea.mcp.api.controller.claim;

import com.vroong.lastmile.api.client.ApiException;
import net.meshkorea.mcp.api.domain.model.claim.*;
import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 3. 24..
 */
@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    //detail Api 완료
    @GetMapping(value = "/{claimNo}")
    public ClaimDetailResponse getClaimDetail(@PathVariable Long claimNo) throws ApiException {
        return claimService.getClaimDetail(claimNo);
    }

    //List Api
    @PostMapping(value = "/findClaims")
    public ClaimListResponse findClaims(@RequestBody ClaimSearchDto claimSearchDto) throws ApiException {
        return claimService.findClaims(claimSearchDto);
    }

    //create claim
    @PostMapping("/createClaim")
    public CreateClaimResponse createClaim(@RequestBody CreateClaimRequest request) throws ApiException {
        return claimService.createClaim(request);
    }

    @PutMapping("/updateClaim")
    public UpdateClaimResponse updateClaim(@RequestBody UpdateClaimRequest request) {
        return claimService.updateClaim(request);
    }

    @GetMapping("getClaimHistory")
    public ClaimHistoryResponse getClaimHistory(Long claimNo) {
        return claimService.getClaimHistory(claimNo);
    }

    @GetMapping("getClaimAdjustmentHistory")
    public ClaimAdjustmentHistoryResponse getClaimAdjustmentHistory(Long orderId) {
        return claimService.getClaimAdjustmentHistory(orderId);
    }

    @PostMapping("/addAdjustment")
    public CreateClaimAdjustmentResponse createClaimAdjustment(@RequestBody CreateClaimAdjustmentRequest request) {
        return claimService.createClaimAdjustment(request);
    }

    @PutMapping("/updateAdjustment")
    public UpdateClaimAdjustmentResponse updateClaimAdjustment(@RequestBody UpdateClaimAdjustmentRequest request) {
        return claimService.updateClaimAdjustment(request);
    }

    //insert description
    @PutMapping("/description")
    public UpdateClaimDescriptionResponse updateDescription(@RequestBody UpdateClaimDescriptionRequest request) {
        return claimService.updateDescription(request);
    }

    @GetMapping("/descriptionCount")
    public ClaimDescriptionCountResponse getDescriptionCount(Long orderId) {
        return claimService.getDescriptionCount(orderId);
    }

    @GetMapping("/getDescription")
    public ClaimDescriptionResponse getDescription(Long orderId) {
        return claimService.getDescription(orderId);
    }

    @GetMapping("/getAdjustment")
    public ClaimAdjustmentResponse getAdjustment(Long orderId) {
        return claimService.getAdjustment(orderId);
    }

    @GetMapping("/getClaimReasonCode")
    public ClaimReasonCodeResponse getClaimReasonCode() {
        return claimService.getClaimReasonCode();
    }

    @GetMapping("/getClaimCode")
    public ClaimCodeResponse getClaimCode(String code) {
        return claimService.getClaimCode(code);
    }

}
