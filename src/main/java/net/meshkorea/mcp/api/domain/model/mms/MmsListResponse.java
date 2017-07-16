package net.meshkorea.mcp.api.domain.model.mms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;
import net.meshkorea.mcp.api.domain.model.common.PageableResponse;

import java.util.List;

/**
 * Created by reverof on 2017-07-17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MmsListResponse extends BaseResponse implements PageableResponse {

    Integer page;

    Integer size;

    Integer totalPages;

    Long totalItems;

    List<MmsTransferDto> data;

    public MmsListResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
