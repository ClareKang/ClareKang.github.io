package net.meshkorea.mcp.api.domain.model.claim;

import lombok.*;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateClaimResponse extends BaseResponse {

    ClaimDetail data;

    public CreateClaimResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
