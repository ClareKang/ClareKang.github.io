package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.Authority;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;

import java.util.List;

/**
 * Created by reverof on 2017-06-19.
 */
@AuthDbConfig.AuthData
public interface AuthorityRepositoryCustom {
    List<Authority> getAllAuthoritiesWithGrantedGroups(Long groupId);
}
