package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsGroupLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper
public interface MmsGroupLogMapper {

    MmsGroupLogMapper INSTANCE = Mappers.getMapper(MmsGroupLogMapper.class);

    MmsGroupLog mmsGroupLogDtoToMmsGroupLog(MmsGroupLogDto mmsGroupLogDto);

    MmsGroupLogDto mmsGroupLogToMmsGroupLogDto(MmsGroupLog mmsGroupLog);

}
