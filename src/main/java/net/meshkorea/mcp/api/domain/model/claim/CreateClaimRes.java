package net.meshkorea.mcp.api.domain.model.claim;

import com.vroong.lastmile.api.client.model.OrderDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */

@Getter
@Setter
@ToString
public class CreateClaimRes {

    private OrderDto order;

    private OrderDto claimOrder;

    private Claim claim;

    private List<ClaimDescriptionDto> claimDescriptions;

    private ClaimAdjustment claimAdjustment;


}
