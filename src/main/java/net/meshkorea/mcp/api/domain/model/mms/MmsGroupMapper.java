package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper(
    componentModel = "spring",
    uses = {
        MmsSummaryMapper.class,
        MmsTransferMapper.class
    }
)
public interface MmsGroupMapper {

    MmsGroupMapper INSTANCE = Mappers.getMapper(MmsGroupMapper.class);

    MmsGroup mmsGroupDtoToMmsGroup(MmsGroupDto mmsGroupDto);

    MmsGroupDto mmsGroupToMmsGroupDto(MmsGroup mmsGroup);

    List<MmsGroup> mmsGroupDtosToMmsGroups(List<MmsGroupDto> mmsGroupDtos);

    List<MmsGroupDto> mmsGroupsToMmsGroupDtos(List<MmsGroup> mmsGroups);

}
