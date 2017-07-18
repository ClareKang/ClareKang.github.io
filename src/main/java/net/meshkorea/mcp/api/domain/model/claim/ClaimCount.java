package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.meshkorea.mcp.api.domain.model.auth.UserDto;

import java.util.Date;

/**
 * Created by sungjae.hong on 2017. 6. 13..
 */

@Getter
@Setter
@ToString
public class ClaimCount {

    private int accept;

    private int inProgress;

    private int hold;

    private int resolve;

    private int retraction;

    private int transfer;

    private int unprocessed;

}
