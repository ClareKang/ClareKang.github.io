package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by reverof on 2017. 6. 18..
 */
@AuthDbConfig.AuthData
public interface GroupRepository extends JpaSpecificationRepository<Group, Long>, GroupRepositoryCustom {
}
