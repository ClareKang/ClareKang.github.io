package net.meshkorea.mcp.api.domain.model.claim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 15..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateClaimDescriptionResponse extends BaseResponse {
    List<ClaimDescriptionDto> data;

    public UpdateClaimDescriptionResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }
}
