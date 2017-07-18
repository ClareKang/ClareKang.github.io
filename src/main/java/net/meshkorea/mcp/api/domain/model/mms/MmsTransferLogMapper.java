package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsGroupLog;
import net.meshkorea.mcp.api.domain.entity.mms.MmsSummary;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper
public interface MmsTransferLogMapper {

    MmsTransferLogMapper INSTANCE = Mappers.getMapper(MmsTransferLogMapper.class);

    MmsTransferLog mmsTransferLogDtoToMmsTransferLog(MmsTransferLogDto mmsTransferLogDto);

    MmsTransferLogDto mmsTransferLogToMmsTransferLogDto(MmsTransferLog mmsTransferLog);

    MmsGroupLog mmsGroupLogDtoToMmsGroupLog(MmsGroupLogDto mmsGroupLogDto);

    MmsGroupLogDto mmsGroupLogToMmsGroupLogDto(MmsGroupLog mmsGroupLog);

    MmsSummary mmsSummaryDtoToMmsSummary(MmsSummaryDto mmsSummaryDto);

    MmsSummaryDto mmsSummaryToMmsSummaryDto(MmsSummary mmsSummary);

}
