package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClaimHistoryResponse extends BaseResponse {

    List<ClaimHistory> data;

    public ClaimHistoryResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
