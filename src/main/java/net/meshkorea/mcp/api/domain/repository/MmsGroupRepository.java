package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.mms.MmsGroup;
import net.meshkorea.platform.core.web.config.data.MmsDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@MmsDbConfig.MmsData
public interface MmsGroupRepository extends JpaSpecificationRepository<MmsGroup, String> {
}
