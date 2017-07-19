package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClaimAdjustmentResponse extends BaseResponse {

    private ClaimAdjustment data;

    public ClaimAdjustmentResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
