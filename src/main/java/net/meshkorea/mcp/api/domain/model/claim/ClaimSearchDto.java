package net.meshkorea.mcp.api.domain.model.claim;

import com.vroong.lastmile.api.client.model.ManagerFindOrdersReq;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 13..
 */
@Getter
@Setter
@ToString
public class ClaimSearchDto {

    private ManagerFindOrdersReq request;

    private String claimType;

    private String requestType;

    private List<String> claimStatusType;

    private List<Long> orderIds;

    private String searchType;

    private String searchString;

}
