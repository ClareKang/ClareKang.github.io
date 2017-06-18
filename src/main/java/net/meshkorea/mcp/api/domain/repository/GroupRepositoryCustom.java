package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;

/**
 * Created by reverof on 2017. 6. 18..
 */
@AuthDbConfig.AuthData
public interface GroupRepositoryCustom {
    Group getGroupWithAuthorities(Long groupId);
}
