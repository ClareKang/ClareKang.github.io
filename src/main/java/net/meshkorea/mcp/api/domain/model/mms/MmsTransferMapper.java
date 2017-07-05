package net.meshkorea.mcp.api.domain.model.mms;

import net.meshkorea.mcp.api.domain.entity.mms.MmsTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Mapper(
    componentModel = "spring",
    uses = {
        MmsGroupMapper.class
    }
)
public interface MmsTransferMapper {

    MmsTransferMapper INSTANCE = Mappers.getMapper(MmsTransferMapper.class);

    MmsTransfer mmsTransferDtoToMmsTransfer(MmsTransferDto mmsTransferDto);

    MmsTransferDto mmsTransferToMmsTransferDto(MmsTransfer mmsTransfer);

    List<MmsTransfer> mmsTransfersToMmsTransferDtos(List<MmsTransferDto> mmsTransferDtos);

    List<MmsTransferDto> mmsTransferDtosToMmsTransfers(List<MmsTransfer> mmsTransfers);

}
