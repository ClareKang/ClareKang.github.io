package net.meshkorea.mcp.api.domain.model.kmc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;

/**
 * Created by yjhan on 2017. 6. 29..
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertResultRequest extends BaseRequest {

    private String recCert;

    private String certNum;

}
