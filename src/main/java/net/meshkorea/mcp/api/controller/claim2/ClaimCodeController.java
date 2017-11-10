package net.meshkorea.mcp.api.controller.claim2;

import com.vroong.lastmile.api.client.ApiException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimCodeRequest;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimCodeResponse;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimType;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.claim2.ClaimCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimCodeController {

    @Autowired
    private ClaimCodeService claimCodeService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "(useYn | claimCodeName),(asc | desc)", required = false)
    })
    @GetMapping(value = "/codes/all")
    public ClaimCodeResponse.ClaimCodeList getClaimCodeList(
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "useYn", direction = Sort.Direction.DESC),
                    @SortDefault(sort = "claimCodeName", direction = Sort.Direction.ASC)
            }) Sort sort) throws ApiException {

        ClaimCodeResponse.ClaimCodeList result = new ClaimCodeResponse.ClaimCodeList();
        result.setClaimCodeList(claimCodeService.getClaimCodeList(sort));
        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "(useYn | claimCodeName),(asc | desc)", required = false)
    })
    @GetMapping(value = "/codes", params = {"claimType", "useYn"})
    public ClaimCodeResponse.ClaimCodeList getClaimCodeList(
            @RequestParam(value = "claimType", required = true) ClaimType claimType,
            @RequestParam(value = "useYn", required = false) Yn useYn,
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "useYn", direction = Sort.Direction.DESC),
                    @SortDefault(sort = "claimCodeName", direction = Sort.Direction.ASC)
            }) Sort sort) throws ApiException {

        ClaimCodeResponse.ClaimCodeList result = new ClaimCodeResponse.ClaimCodeList();
        result.setClaimCodeList(claimCodeService.getClaimCodeList(claimType, useYn, sort));
        return result;
    }

    @PostMapping(value = "/codes")
    public ClaimCode addClaimCode(@Valid @RequestBody ClaimCodeRequest.AddClaimCode parameter,
                                  BindingResult bindingResult) throws ApiException, CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        return claimCodeService.addClaimCode(parameter);
    }

    @PutMapping(value = "/codes")
    public ClaimCode modifyClaimCode(@Valid @RequestBody ClaimCodeRequest.ModifyClaimCode parameter,
                                     BindingResult bindingResult) throws ApiException, CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        return claimCodeService.modifyClaimCode(parameter);
    }

}
