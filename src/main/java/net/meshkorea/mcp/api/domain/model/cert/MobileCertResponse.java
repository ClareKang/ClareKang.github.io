package net.meshkorea.mcp.api.domain.model.cert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

/**
 * Created by yjhan on 2017. 6. 27..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MobileCertResponse extends BaseResponse {

    private String result;

    private String certId;

    public MobileCertResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
