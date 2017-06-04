package net.meshkorea.mcp.api.controller.claim;

import net.meshkorea.mcp.api.domain.model.claim.ClaimDto;
import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by reverof on 2017. 3. 24..
 */
@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping(value = "/{claimNo}")
    public ClaimDto getClaim(@PathVariable Long claimNo) {
        return claimService.getClaim(claimNo);
    }
}
