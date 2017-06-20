package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;
import net.meshkorea.mcp.api.domain.model.common.PageableResponse;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 18..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupListResponse extends BaseResponse implements PageableResponse {

    Integer page;

    Integer size;

    Integer totalPages;

    Long totalItems;

    List<GroupDto> data;

    public GroupListResponse(ErrorDto errorDto) {
        super(errorDto);
    }
}
