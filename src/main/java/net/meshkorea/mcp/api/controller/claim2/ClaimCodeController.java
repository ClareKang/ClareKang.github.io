package net.meshkorea.mcp.api.controller.claim2;

import com.vroong.lastmile.api.client.ApiException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.meshkorea.mcp.api.domain.entity.claim2.ClaimCode;
import net.meshkorea.mcp.api.domain.model.claim2.ClaimCodeRequest;
import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import net.meshkorea.mcp.api.service.claim2.ClaimCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimCodeController {

    @Autowired
    private ClaimCodeService claimCodeService;

    @GetMapping(value = "/codes")
    public List<ClaimCode> getClaimCodeList() throws ApiException {
        return claimCodeService.getClaimCodeList();
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
