package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.entity.claim.ClaimHistory;
import net.meshkorea.mcp.api.domain.model.auth.UserDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Getter
@Setter
public class ClaimHistoryDto {

    private Long claimHistoryNo;

    private ClaimDto claimDto;

    private UserDto creator;

    private Date createDt;

    private String jsonString;

    public void setClaimDto(ClaimDto claimDto) {
        this.claimDto = claimDto;
        if (this.claimDto.getClaimHistoryDtos() != null && !this.claimDto.getClaimHistoryDtos().contains(this)) {
            this.claimDto.getClaimHistoryDtos().add(this);
        }
    }

    public static ClaimHistoryDto toClaimHistoryDto(ClaimHistory claimHistory) {
        if (claimHistory == null)
            return null;

        ClaimHistoryDto claimHistoryDto = new ClaimHistoryDto();
        claimHistoryDto.setClaimHistoryNo(claimHistory.getClaimHistoryNo());
        claimHistoryDto.setClaimDto(ClaimDto.toClaimDto(claimHistory.getClaim()));
        claimHistoryDto.setCreator(UserDto.toUserDto(claimHistory.getCreator()));
        claimHistoryDto.setCreateDt(claimHistory.getCreateDt());
        claimHistoryDto.setJsonString(claimHistory.getJsonString());

        return claimHistoryDto;
    }

    public static List<ClaimHistoryDto> toClaimHistoryDtos(List<ClaimHistory> claimHistories) {
        if (claimHistories == null)
            return null;

        List<ClaimHistoryDto> claimHistoryDtos = new ArrayList<>();
        claimHistories.forEach(claimHistory -> {
            claimHistoryDtos.add(ClaimHistoryDto.toClaimHistoryDto(claimHistory));
        });

        return claimHistoryDtos;
    }

    public static ClaimHistory toClaimHistory(ClaimHistoryDto claimHistoryDto) {
        if (claimHistoryDto == null)
            return null;

        ClaimHistory claimHistory = new ClaimHistory();
        claimHistory.setClaimHistoryNo(claimHistoryDto.getClaimHistoryNo());
        claimHistory.setClaim(ClaimDto.toClaim(claimHistoryDto.getClaimDto()));
        claimHistory.setCreator(UserDto.toUser(claimHistoryDto.getCreator()));
        claimHistory.setCreateDt(claimHistoryDto.getCreateDt());
        claimHistory.setJsonString(claimHistoryDto.getJsonString());

        return claimHistory;
    }

    public static List<ClaimHistory> toClaimHistories(List<ClaimHistoryDto> claimHistoryDtos) {
        if (claimHistoryDtos == null)
            return null;

        List<ClaimHistory> claimHistories = new ArrayList<>();
        claimHistoryDtos.forEach(claimHistoryDto -> {
            claimHistories.add(ClaimHistoryDto.toClaimHistory(claimHistoryDto));
        });

        return claimHistories;
    }
}
