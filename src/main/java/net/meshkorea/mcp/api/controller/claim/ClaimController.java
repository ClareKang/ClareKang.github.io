package net.meshkorea.mcp.api.controller.claim;

import net.meshkorea.mcp.api.entity.claim.Claim;
import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 3. 24..
 */
@RestController
@RequestMapping(value = "/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @RequestMapping(value = "/{claimNo}", method = RequestMethod.GET)
    public @ResponseBody
    Claim getClaim(@PathVariable Long claimNo) {
        return claimService.getClaim(claimNo);
    }
}
