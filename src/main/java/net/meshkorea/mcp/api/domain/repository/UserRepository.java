package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.config.data.AuthDbConfig;
import net.meshkorea.mcp.api.domain.entity.auth.Authority;
import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@AuthDbConfig.AuthData
public interface UserRepository extends JpaSpecificationRepository<User, Long> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    User findOneByUserName(String userName);

}
