package net.meshkorea.mcp.api.domain.repository;

import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 16..
 */
public interface MmsTransferLogRepositoryCustom {

    List<MmsTransferLog> getMmsTransferLogs();

}
