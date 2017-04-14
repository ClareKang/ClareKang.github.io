package net.meshkorea.mcp.api.dto.claim;

import lombok.Data;
import net.meshkorea.mcp.api.dto.ModelMapper;
import net.meshkorea.mcp.api.entity.claim.Claim;
import net.meshkorea.mcp.api.entity.claim.ClaimHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Data
public class ClaimDto implements ModelMapper<ClaimDto, Claim> {

    private Long claimNo;

    private String statusCode;

    private String typeCode;

    private String requestCode;

    private String causeCode;

    private Float customerBlame;

    private Float storeBlame;

    private Float partnerBlame;

    private Float meshBlame;

    private Float noneBlame;

    private String creator;

    private Date createDt;

    private String updater;

    private Date updateDt;

    private List<ClaimHistoryDto> claimHistoryDtos;

    private List<ClaimHistoryDto> from(List<ClaimHistory> claimHistories) {

        List<ClaimHistoryDto> result = new ArrayList<>();
        if (claimHistories == null || claimHistories.size() == 0) {
            return result;
        }

        for (ClaimHistory claimHistory : claimHistories) {
            ClaimHistoryDto claimHistoryDto = new ClaimHistoryDto();
            claimHistoryDto.from(claimHistory);
            result.add(claimHistoryDto);
        }

        return result;
    }

    private List<ClaimHistory> to(List<ClaimHistory> claimHistories) {

        if (claimHistories == null) {
            claimHistories = new ArrayList<>();
        }

        for (ClaimHistoryDto claimHistoryDto : getClaimHistoryDtos()) {
            ClaimHistory claimHistory = new ClaimHistory();
            claimHistories.add(claimHistoryDto.to(claimHistory));
        }

        return claimHistories;
    }

    public ClaimDto from(Claim claim) {
        setClaimNo(claim.getClaimNo());
        setStatusCode(claim.getStatusCode());
        setTypeCode(claim.getTypeCode());
        setRequestCode(claim.getRequestCode());
        setCauseCode(claim.getCauseCode());
        setCustomerBlame(claim.getCustomerBlame());
        setStoreBlame(claim.getStoreBlame());
        setPartnerBlame(claim.getPartnerBlame());
        setMeshBlame(claim.getMeshBlame());
        setNoneBlame(claim.getNoneBlame());
        setCreator(claim.getCreator());
        setCreateDt(claim.getCreateDt());
        setUpdater(claim.getUpdater());
        setUpdateDt(claim.getUpdateDt());
        setClaimHistoryDtos(from(claim.getClaimHistories()));

        return this;
    }

    public Claim to(Claim claim) {
        claim.setClaimNo(getClaimNo());
        claim.setStatusCode(getStatusCode());
        claim.setTypeCode(getTypeCode());
        claim.setRequestCode(getRequestCode());
        claim.setCauseCode(getCauseCode());
        claim.setCustomerBlame(getCustomerBlame());
        claim.setStoreBlame(getStoreBlame());
        claim.setPartnerBlame(getPartnerBlame());
        claim.setMeshBlame(getMeshBlame());
        claim.setNoneBlame(getNoneBlame());
        claim.setCreator(getCreator());
        claim.setCreateDt(getCreateDt());
        claim.setUpdater(getUpdater());
        claim.setUpdateDt(getUpdateDt());
        claim.setClaimHistories(to(claim.getClaimHistories()));

        return claim;
    }

}
