package net.meshkorea.mcp.api.controller.claim;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerFindOrdersReq;
import com.vroong.lastmile.api.client.model.ManagerFindOrdersRes;
import net.meshkorea.mcp.api.domain.model.claim.*;
import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 3. 24..
 */
@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    //detail Api
    @GetMapping(value = "/{claimNo}")
    public ClaimDetail getClaim(@PathVariable Long claimNo) throws ApiException{
        return claimService.getClaimDetail(claimNo);
    }

    //List Api
    @PostMapping(value = "/findClaims")
    public List<ClaimRes> findClaims(@RequestBody ClaimSearchDto claimSearchDto) {
        //return new ArrayList<ClaimRes>();
        return claimService.findClaims(claimSearchDto);
    }

    /*@GetMapping(value = "/listClaims")
    public List<>*/

    //Search Order
    @PostMapping("/findOrders")
    public ManagerFindOrdersRes findOrders(@RequestBody ManagerFindOrdersReq req) {
        System.out.println(req);
        return new ManagerFindOrdersRes();
    }


    //insert description
    @PutMapping("/{id}/description")
    public ClaimDescriptionDto updateDescription(@PathVariable Integer id, @RequestBody ClaimDescriptionDto req) {
        System.out.println(req);
        return new ClaimDescriptionDto();
    }

    //create claim
    @PostMapping("/createClaim")
    public CreateClaimRes createClaim(@RequestBody CreateClaimReq req) throws ApiException{
        System.out.println(req);
        return claimService.createClaim(req);
    }


    //2. 클레임 parent 사유 코드 api
    //@GetMapping("/listParentCode")


    //3. 클레임 child 사유 코드 api
    //@GetMapping("/listChildCode")
}
