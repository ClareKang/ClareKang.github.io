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
public class UpdateClaimResponse extends BaseResponse {

    private UpdateClaimRequest data;

    public UpdateClaimResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
