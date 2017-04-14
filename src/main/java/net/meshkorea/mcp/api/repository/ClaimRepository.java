package net.meshkorea.mcp.api.repository;

import net.meshkorea.mcp.api.config.data.MasterDbConfig;
import net.meshkorea.mcp.api.entity.claim.Claim;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by reverof on 2017. 4. 10..
 */
@MasterDbConfig.MasterData
public interface ClaimRepository extends JpaSpecificationRepository<Claim, Long> {
}
