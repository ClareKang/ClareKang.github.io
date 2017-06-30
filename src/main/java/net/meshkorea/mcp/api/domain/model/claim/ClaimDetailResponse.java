package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDetailResponse extends BaseResponse {

    ClaimDetail data;

    public ClaimDetailResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
