package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.business.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/operator")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @PostMapping("/findOperators")
    public ManagerFindOperatorsRes findOperators(ManagerFindOperatorsReq req) throws ApiException {
        return operatorService.findOperators(req);
    }

    @PostMapping("/getOperatorDetail")
    public ManagerGetOperatorDetailRes getOperatorDetail(ManagerGetOperatorDetailReq req) throws ApiException {
        return operatorService.getOperatorDetail(req);
    }

    @PostMapping("/addOperator")
    public ManagerAddOperatorRes addOperator(@RequestBody ManagerAddOperatorReq req) throws ApiException {
        return operatorService.addOperator(req);
    }

    @PostMapping("/removeOperator")
    public ManagerRemoveOperatorRes removeOperator(ManagerRemoveOperatorReq req) throws ApiException {
        return operatorService.removeOperator(req);
    }

    @PostMapping("/updateOperator")
    public ManagerUpdateOperatorRes updateOperator(@RequestBody ManagerUpdateOperatorReq req) throws ApiException {
        return operatorService.updateOperator(req);
    }
}
