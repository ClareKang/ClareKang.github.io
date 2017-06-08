package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.claim.Claim;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by reverof on 2017. 4. 10..
 */
@MasterDbConfig.MasterData
public interface ClaimRepository extends JpaSpecificationRepository<Claim, Long> {
}
