package net.meshkorea.mcp.domain.repository;

import net.meshkorea.mcp.api.config.data.MasterDbConfig;
import net.meshkorea.mcp.domain.entity.claim.ClaimHistory;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by yjhan on 2017. 3. 17..
 */
@MasterDbConfig.MasterData
public interface ClaimHistoryRepository extends JpaSpecificationRepository<ClaimHistory, Long> {
}
