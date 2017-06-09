package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.auth.UserListRequest;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by reverof on 2017-06-06.
 */
@AuthDbConfig.AuthData
public interface UserRepositoryCustom {
    Page<User> search(UserListRequest userListRequest, Pageable pageable);
}
