package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.claim.Claim;
import net.meshkorea.mcp.api.domain.model.auth.UserDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Getter
@Setter
public class ClaimDto {

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

    private UserDto creator;

    private Date createDt;

    private UserDto updater;

    private Date updateDt;

    private List<ClaimHistoryDto> claimHistoryDtos = new ArrayList<>();

    public static ClaimDto toClaimDto(Claim claim) {
        if (claim == null)
            return null;

        ClaimDto claimDto = new ClaimDto();
        claimDto.setClaimNo(claim.getClaimNo());
        claimDto.setStatusCode(claim.getStatusCode());
        claimDto.setTypeCode(claim.getTypeCode());
        claimDto.setRequestCode(claim.getRequestCode());
        claimDto.setCauseCode(claim.getCauseCode());
        claimDto.setCustomerBlame(claim.getCustomerBlame());
        claimDto.setStoreBlame(claim.getStoreBlame());
        claimDto.setPartnerBlame(claim.getPartnerBlame());
        claimDto.setMeshBlame(claim.getMeshBlame());
        claimDto.setNoneBlame(claim.getNoneBlame());
        claimDto.setCreator(UserDto.toUserDto(claim.getCreator()));
        claimDto.setCreateDt(claim.getCreateDt());
        claimDto.setUpdater(UserDto.toUserDto(claim.getUpdater()));
        claimDto.setUpdateDt(claim.getUpdateDt());
        claimDto.setClaimHistoryDtos(ClaimHistoryDto.toClaimHistoryDtos(claim.getClaimHistories()));

        return claimDto;
    }

    public static List<ClaimDto> toClaimDtos(List<Claim> claims) {
        if (claims == null)
            return null;

        List<ClaimDto> claimDtos = new ArrayList<>();
        claims.forEach(claim -> {
            claimDtos.add(ClaimDto.toClaimDto(claim));
        });

        return claimDtos;
    }

    public static Claim toClaim(ClaimDto claimDto) {
        if (claimDto == null)
            return null;

        Claim claim = new Claim();
        claim.setClaimNo(claimDto.getClaimNo());
        claim.setStatusCode(claimDto.getStatusCode());
        claim.setTypeCode(claimDto.getTypeCode());
        claim.setRequestCode(claimDto.getRequestCode());
        claim.setCauseCode(claimDto.getCauseCode());
        claim.setCustomerBlame(claimDto.getCustomerBlame());
        claim.setStoreBlame(claimDto.getStoreBlame());
        claim.setPartnerBlame(claimDto.getPartnerBlame());
        claim.setMeshBlame(claimDto.getMeshBlame());
        claim.setNoneBlame(claimDto.getNoneBlame());
        claim.setCreator(UserDto.toUser(claimDto.getCreator()));
        claim.setCreateDt(claimDto.getCreateDt());
        claim.setUpdater(UserDto.toUser(claimDto.getUpdater()));
        claim.setUpdateDt(claimDto.getUpdateDt());
        claim.setClaimHistories(ClaimHistoryDto.toClaimHistories(claimDto.getClaimHistoryDtos()));

        return claim;
    }

    public static List<Claim> toClaims(List<ClaimDto> claimDtos) {
        if (claimDtos == null)
            return null;

        List<Claim> claims = new ArrayList<>();
        claimDtos.forEach(claimDto -> {
            claims.add(ClaimDto.toClaim(claimDto));
        });

        return claims;
    }

}
