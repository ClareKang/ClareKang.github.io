package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by sungjae.hong on 2017. 6. 12..
 */
@Getter
@Setter
public class ClaimDescriptionDto {

    private Long claimDescriptionNo;

    private Long orderId;

    private Long claimNo;

    private String description;

    private String creator;

    private Date createDt;
}
