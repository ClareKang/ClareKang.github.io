package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsSummary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper
public interface MmsSummaryMapper {

    MmsSummaryMapper INSTANCE = Mappers.getMapper(MmsSummaryMapper.class);

    MmsSummary mmsSummaryDtoToMmsSummary(MmsSummaryDto mmsSummaryDto);

    MmsSummaryDto mmsSummaryToMmsSummaryDto(MmsSummary mmsSummary);

}
