package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by sungjae.hong on 2017. 6. 13..
 */
@Getter
@Setter
@ToString
public class ClaimSearchDto {

    private String startDt;

    private String endDt;

    private String searchType;

    private String keyword;

    private String claimType;

    private String requestCode;

    private String claimStatus;

}
