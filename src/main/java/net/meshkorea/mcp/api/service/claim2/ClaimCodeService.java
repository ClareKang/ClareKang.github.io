package net.meshkorea.mcp.api.service.claim2;

import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimCodeRequest;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimType;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.mcp.api.domain.repository.ClaimCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimCodeService {

    @Autowired
    private ClaimCodeRepository claimCodeRepository;

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

    public List<ClaimCode> getClaimCodeList(ClaimType claimType, Yn useYn, Sort sort) {

        switch (claimType) {
            case ORDER_CANCEL:
                return claimCodeRepository.findByOrderCancelYnAndUseYn(Yn.Y, useYn, sort);
            case OVERLOAD:
                return claimCodeRepository.findByOverloadYnAndUseYn(Yn.Y, useYn, sort);
            case RETURN:
                return claimCodeRepository.findAllByReturnYnAndUseYn(Yn.Y, useYn, sort);
            case RETRY:
                return claimCodeRepository.findAllByRetryYnAndUseYn(Yn.Y, useYn, sort);
            case ADDRESS_CHANGE:
                return claimCodeRepository.findAllByAddressChangeYnAndUseYn(Yn.Y, useYn, sort);
            case PHONE_PAYMENT:
                return claimCodeRepository.findAllByPhonePaymentYnAndUseYn(Yn.Y, useYn, sort);
            case DAMEGE:
                return claimCodeRepository.findAllByDamegeYnAndUseYn(Yn.Y, useYn, sort);
        }

        return claimCodeRepository.findAll(sort);
    }

    public List<ClaimCode> getClaimCodeList(Sort sort) {
        return claimCodeRepository.findAll(sort);
    }
}
