package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.auth.Group;
import net.meshkorea.mcp.api.domain.model.auth.GroupListRequest;
import net.meshkorea.platform.core.web.config.data.AuthDbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by reverof on 2017. 6. 18..
 */
@AuthDbConfig.AuthData
public interface GroupRepositoryCustom {

    Page<Group> search(GroupListRequest groupListRequest, Pageable pageable);

}
