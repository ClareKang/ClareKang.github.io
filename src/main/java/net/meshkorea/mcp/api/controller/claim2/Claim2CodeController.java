package net.meshkorea.mcp.api.controller.claim2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.meshkorea.mcp.api.domain.entity.claim2.Claim2Code;
import net.meshkorea.mcp.api.domain.model.claim2.Claim2CodeRequest;
import net.meshkorea.mcp.api.domain.model.claim2.Claim2CodeResponse;
import net.meshkorea.mcp.api.domain.model.claim2.Claim2Type;
import net.meshkorea.mcp.api.domain.model.database.Yn;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.claim2.Claim2CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/claim2")
public class Claim2CodeController {

    @Autowired
    private Claim2CodeService claimCodeService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "(useYn | claimCodeName),(asc | desc)", required = false)
    })
    @GetMapping(value = "/codes/all")
    public Claim2CodeResponse.Claim2CodeList getClaimCodeList(
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "useYn", direction = Sort.Direction.DESC),
                    @SortDefault(sort = "claimCodeName", direction = Sort.Direction.ASC)
            }) Sort sort) {

        Claim2CodeResponse.Claim2CodeList result = new Claim2CodeResponse.Claim2CodeList();
        result.setClaim2CodeList(claimCodeService.getClaimCodeList(sort));
        return result;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "(useYn | claimCodeName),(asc | desc)", required = false)
    })
    @GetMapping(value = "/codes", params = {"claimType", "useYn"})
    public Claim2CodeResponse.Claim2CodeList getClaimCodeList(
            @RequestParam(value = "claimType", required = true) Claim2Type claimType,
            @RequestParam(value = "useYn", required = false) Yn useYn,
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "useYn", direction = Sort.Direction.DESC),
                    @SortDefault(sort = "claimCodeName", direction = Sort.Direction.ASC)
            }) Sort sort) {

        Claim2CodeResponse.Claim2CodeList result = new Claim2CodeResponse.Claim2CodeList();
        result.setClaim2CodeList(claimCodeService.getClaimCodeList(claimType, useYn, sort));
        return result;
    }

    @PostMapping(value = "/codes")
    public Claim2Code addClaimCode(@Valid @RequestBody Claim2CodeRequest.AddClaimCode parameter,
                                   BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        return claimCodeService.addClaimCode(parameter);
    }

    @PutMapping(value = "/codes")
    public Claim2Code modifyClaimCode(@Valid @RequestBody Claim2CodeRequest.ModifyClaimCode parameter,
                                      BindingResult bindingResult) throws CustomBindingException {

        if (bindingResult.hasErrors()) {
            throw new CustomBindingException(bindingResult);
        }

        return claimCodeService.modifyClaimCode(parameter);
    }

}
