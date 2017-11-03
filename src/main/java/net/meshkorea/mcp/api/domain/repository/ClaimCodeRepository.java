package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

@MasterDbConfig.MasterData
public interface ClaimCodeRepository extends JpaSpecificationRepository<ClaimCode, Long> {

}
