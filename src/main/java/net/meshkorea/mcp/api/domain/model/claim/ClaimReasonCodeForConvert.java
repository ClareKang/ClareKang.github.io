package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 19..
 */
@Getter
@Setter
@ToString
public class ClaimReasonCodeForConvert {

    private ClaimCode parent;
    private List<ClaimCode> child;
}
