package net.meshkorea.mcp.api.domain.model.azure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;

import java.util.List;

/**
 * Created by yjhan on 2017. 6. 25..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdUserResponse extends BaseResponse {

    List<AdUserSimple> data;

    public AdUserResponse(ErrorDto errorDto) {
        super(errorDto);
    }
}
