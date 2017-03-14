package net.meshkorea.mcp.api.controller;

import com.vroong.lastmile.api.client.ApiException;
import com.vroong.lastmile.api.client.model.ManagerGetBanksRes;
import net.meshkorea.mcp.api.service.VroongClientTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by reverof on 2017. 2. 28..
 */
@Controller
public class VroongClientTestController {

    @Autowired
    VroongClientTestService vroongClientTestService;

    @RequestMapping(value = "/systemStatus", method = RequestMethod.GET)
    public String getSystemStatus() throws ApiException {
        return vroongClientTestService.getSystemStatus();
    }

    @RequestMapping(value = "/testGetBanks", method = RequestMethod.GET)
    public @ResponseBody ManagerGetBanksRes getBanks() throws ApiException {
        return vroongClientTestService.getBanks();
    }
}
