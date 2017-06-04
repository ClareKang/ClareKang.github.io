package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.config.data.AuthDbConfig;
import net.meshkorea.mcp.api.domain.entity.auth.Authority;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

@AuthDbConfig.AuthData
public interface AuthorityRepository extends JpaSpecificationRepository<Authority, Long> {
}
