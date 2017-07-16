package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper(
    componentModel = "spring",
    uses = {
        MmsGroupLogMapper.class
    }
)
public interface MmsTransferLogMapper {

    MmsTransferLogMapper INSTANCE = Mappers.getMapper(MmsTransferLogMapper.class);

    MmsTransferLog mmsTransferLogDtoToMmsTransferLog(MmsTransferLogDto mmsTransferLogDto);

    MmsTransferLogDto mmsTransferLogToMmsTransferLogDto(MmsTransferLog mmsTransferLog);

    List<MmsTransferLog> mmsTransferLogDtosToMmsTransferLogs(List<MmsTransferLogDto> mmsTransferLogDtos);

    List<MmsTransferLogDto> mmsTransferLogsToMmsTransferLogDtos(List<MmsTransferLog> mmsTransferLogs);

}
