package net.meshkorea.mcp.api.service.claim2;

import net.meshkorea.mcp.api.domain.entity.claim2.Claim2Code;
import net.meshkorea.mcp.api.domain.model.claim2.Claim2CodeRequest;
import net.meshkorea.mcp.api.domain.model.claim2.Claim2Type;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.mcp.api.domain.repository.Claim2CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Claim2CodeService {

    @Autowired
    private Claim2CodeRepository claimCodeRepository;

    public Claim2Code addClaimCode(Claim2CodeRequest.AddClaimCode req) {
        Claim2Code claimCode = new Claim2Code();

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

    public Claim2Code modifyClaimCode(Claim2CodeRequest.ModifyClaimCode req) {
        Claim2Code claimCode = claimCodeRepository.findOne(req.getClaimCodeNo());

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

    public List<Claim2Code> getClaimCodeList(Claim2Type claimType, Yn useYn, Sort sort) {

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

    public List<Claim2Code> getClaimCodeList(Sort sort) {
        return claimCodeRepository.findAll(sort);
    }
}
