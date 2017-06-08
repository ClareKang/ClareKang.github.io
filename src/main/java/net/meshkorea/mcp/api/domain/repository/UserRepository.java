package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

@AuthDbConfig.AuthData
public interface UserRepository extends JpaSpecificationRepository<User, Long>, UserRepositoryCustom {

    User findOneByUserName(String userName);

    User findOneByUserId(String userId);

}
