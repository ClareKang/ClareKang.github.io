package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 19..
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClaimReasonCodeResponse extends BaseResponse {

    private List<ClaimReasonCodeForConvert> data;

    public ClaimReasonCodeResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
