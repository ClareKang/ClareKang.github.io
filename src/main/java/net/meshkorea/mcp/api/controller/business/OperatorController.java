package net.meshkorea.mcp.api.controller.business;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.*;
import net.meshkorea.mcp.api.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chaelee on 2017. 3. 10..
 */
@Controller
public class OperatorController {

    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/findOperators", method = RequestMethod.POST)
    public @ResponseBody
    ManagerFindOperatorsRes findOperators(ManagerFindOperatorsReq req) throws ApiException {
        return operatorService.findOperators(req);
    }

    @RequestMapping(value = "/getOperatorDetail", method = RequestMethod.POST)
    public @ResponseBody
    ManagerGetOperatorDetailRes getOperatorDetail(ManagerGetOperatorDetailReq req) throws ApiException {
        return operatorService.getOperatorDetail(req);
    }

    @RequestMapping(value = "/updateOperator", method = RequestMethod.POST)
    public @ResponseBody
    ManagerUpdateOperatorRes updateOperator(ManagerUpdateOperatorReq req) throws ApiException {
        return operatorService.updateOperator(req);
    }
}
