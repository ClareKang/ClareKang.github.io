package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.common.Codes;
import net.meshkorea.platform.core.web.config.data.MasterDbConfig;
import net.meshkorea.platform.core.web.repository.JpaSpecificationRepository;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@MasterDbConfig.MasterData
public interface CodesRepository extends JpaSpecificationRepository<Codes, Long> {

    Codes findOneByCode(String code);

    List<Codes> findAllByParent(Long parent);

}
