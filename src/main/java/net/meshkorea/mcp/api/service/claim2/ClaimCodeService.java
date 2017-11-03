package net.meshkorea.mcp.api.service.claim2;

import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimCodeRequest;
import net.meshkorea.mcp.api.domain.repository.ClaimCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimCodeService {

    @Autowired
    private ClaimCodeRepository claimCodeRepository;

    public List<ClaimCode> getClaimCodeList() {
        return claimCodeRepository.findAll();
    }

    public ClaimCode addClaimCode(ClaimCodeRequest.AddClaimCode req) {
        ClaimCode claimCode = new ClaimCode();

        claimCode.setIssueDt(new Date());
        claimCode.setIssuer(req.getEmail());
        claimCode.setClaimCodeName(req.getClaimCodeName());
        claimCode.setUseYn(req.getUseYn());

        claimCode.setOrderCancelYn(req.getOrderCancelYn());
        claimCode.setOverloadYn(req.getOverloadYn());
        claimCode.setReturnYn(req.getReturnYn());
        claimCode.setRetryYn(req.getRetryYn());
        claimCode.setAddressChangeYn(req.getAddressChangeYn());
        claimCode.setPhonePaymentYn(req.getPhonePaymentYn());
        claimCode.setDamegeYn(req.getDamegeYn());

        return claimCodeRepository.save(claimCode);
    }

    public ClaimCode modifyClaimCode(ClaimCodeRequest.ModifyClaimCode req) {
        ClaimCode claimCode = claimCodeRepository.findOne(req.getClaimCodeNo());

        claimCode.setIssueDt(new Date());
        claimCode.setIssuer(req.getEmail());
        claimCode.setUseYn(req.getUseYn());

        claimCode.setOrderCancelYn(req.getOrderCancelYn());
        claimCode.setOverloadYn(req.getOverloadYn());
        claimCode.setReturnYn(req.getReturnYn());
        claimCode.setRetryYn(req.getRetryYn());
        claimCode.setAddressChangeYn(req.getAddressChangeYn());
        claimCode.setPhonePaymentYn(req.getPhonePaymentYn());
        claimCode.setDamegeYn(req.getDamegeYn());

        return claimCodeRepository.save(claimCode);
    }
}
