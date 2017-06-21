package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by sungjae.hong on 2017. 6. 19..
 */
@Getter
@Setter
@ToString
public class ClaimReasonCode {
    String parentCode;
    String parentCodeName;
    String childCode;
    String childCodeName;

}
