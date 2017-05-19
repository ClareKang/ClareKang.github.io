package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.business.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@RestController
@RequestMapping("/v1/lastmile/operator")
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/findOperators", method = RequestMethod.POST)
    public ManagerFindOperatorsRes findOperators(ManagerFindOperatorsReq req) throws ApiException {
        return operatorService.findOperators(req);
    }

    @RequestMapping(value = "/getOperatorDetail", method = RequestMethod.POST)
    public ManagerGetOperatorDetailRes getOperatorDetail(ManagerGetOperatorDetailReq req) throws ApiException {
        return operatorService.getOperatorDetail(req);
    }

    @RequestMapping(value = "/addOperator", method = RequestMethod.POST)
    public ManagerAddOperatorRes addOperator(@RequestBody ManagerAddOperatorReq req) throws ApiException {
        return operatorService.addOperator(req);
    }

    @RequestMapping(value = "/removeOperator", method = RequestMethod.POST)
    public ManagerRemoveOperatorRes removeOperator(ManagerRemoveOperatorReq req) throws ApiException {
        return operatorService.removeOperator(req);
    }

    @RequestMapping(value = "/updateOperator", method = RequestMethod.POST)
    public ManagerUpdateOperatorRes updateOperator(@RequestBody ManagerUpdateOperatorReq req) throws ApiException {
        return operatorService.updateOperator(req);
    }
}
