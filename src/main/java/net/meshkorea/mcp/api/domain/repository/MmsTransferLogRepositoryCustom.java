package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import net.meshkorea.mcp.api.domain.model.mms.MmsListRequest;
import net.meshkorea.platform.core.web.config.data.MmsDbConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by yjhan on 2017. 7. 16..
 */
@MmsDbConfig.MmsData
public interface MmsTransferLogRepositoryCustom {

    Page<MmsTransferLog> search(MmsListRequest mmsListRequest, Pageable pageable);

}
