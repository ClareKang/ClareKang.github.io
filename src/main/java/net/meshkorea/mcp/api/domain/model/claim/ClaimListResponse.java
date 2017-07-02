package net.meshkorea.mcp.api.domain.model.claim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 13..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClaimListResponse extends BaseResponse {

    List<ClaimList> data;

    public ClaimListResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
