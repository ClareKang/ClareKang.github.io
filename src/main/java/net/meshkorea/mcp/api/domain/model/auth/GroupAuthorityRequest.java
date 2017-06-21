package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 20..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupAuthorityRequest extends BaseRequest {
    private List<AuthorityDto> data;
}
