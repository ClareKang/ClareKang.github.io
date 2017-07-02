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
public class MobileCertIdentificationResponse extends BaseResponse {

    private String cert;

    private String certNum;

    private String callbackUrl;

    public MobileCertIdentificationResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
