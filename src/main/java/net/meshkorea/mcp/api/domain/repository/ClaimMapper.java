package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.model.claim.ClaimDescriptionDto;
import net.meshkorea.mcp.api.domain.model.claim.ClaimDto;
import net.meshkorea.mcp.api.domain.model.claim.ClaimSearchDto;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@MasterDbConfig.MasterData
public interface ClaimMapper {

    //List<ClaimRes> findClaims(ClaimSearchDto claimSearchDto);
    ClaimDto findClaims(ClaimSearchDto claimSearchDto);

    List<ClaimDescriptionDto> getClaimDescription(String claim_no);


    Integer test();
}
