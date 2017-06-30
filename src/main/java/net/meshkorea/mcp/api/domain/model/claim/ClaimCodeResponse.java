package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 19..
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClaimCodeResponse extends BaseResponse {

    List<ClaimCode> data;

    public ClaimCodeResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
