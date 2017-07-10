package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

/**
 * Created by yjhan on 2017. 7. 9..
 */
@Getter
@Setter
@NoArgsConstructor
public class MmsSendResponse extends BaseResponse {

    public MmsSendResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
