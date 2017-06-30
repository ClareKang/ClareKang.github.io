package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateClaimAdjustmentResponse extends BaseResponse {

    private ClaimAdjustment data;

    public UpdateClaimAdjustmentResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
